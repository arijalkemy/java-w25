package com.joyeriaLaPerla.joyeriaLaPerla.service;

import com.joyeriaLaPerla.joyeriaLaPerla.dto.JewerlyDTO;
import com.joyeriaLaPerla.joyeriaLaPerla.dto.MessageDTO;
import com.joyeriaLaPerla.joyeriaLaPerla.exception.BadRequestException;
import com.joyeriaLaPerla.joyeriaLaPerla.exception.NotFoundException;
import com.joyeriaLaPerla.joyeriaLaPerla.model.Jewerly;
import com.joyeriaLaPerla.joyeriaLaPerla.repository.IJewerlyRepository;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewerlyServiceImp implements IJewerlyService{

    private final IJewerlyRepository jwRepo;

    public JewerlyServiceImp(IJewerlyRepository jwRepo) {
        this.jwRepo = jwRepo;
    }

    @Override
    @Transactional
    public MessageDTO saveJewerly(JewerlyDTO jewerly) {
        Jewerly jw = jwRepo.save(convertJewerlyDtoToJewerly(jewerly));
        return new MessageDTO("Jewerly ID: "+jw.getNro_id()+" save successfully.");
    }

    @Override
    @Transactional
    public MessageDTO deleteJewerly(Long id) {
        Jewerly jw = jwRepo.findById(id).orElse(null);
        if(jw.equals(null)){
            throw new NotFoundException("Jewer ID: "+id+" not found");
        }
        if(!jw.isAvailableForSale()){
            throw new BadRequestException("Jewer ID: "+id+" is alredy logic deleted");
        }
        jw.setAvailableForSale(false);
        jwRepo.save(jw);
        return new MessageDTO("Jewerly ID: "+id+" delete succesfully.");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jewerly> getAllJewerly() {
        return jwRepo.findAll().stream()
                .filter(x -> x.isAvailableForSale())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MessageDTO editJewerly(Long id,JewerlyDTO jwEdited) {
        Jewerly jw = jwRepo.findById(id).orElse(null);
        if(jw.equals(null)){
            throw new NotFoundException("Jewer ID: "+id+" not found");
        }

        if(jw.getName()!=jwEdited.getName()){
            jw.setName(jwEdited.getName());
        }
        if(jw.getMaterial()!=jwEdited.getMaterial()){
            jw.setMaterial(jwEdited.getMaterial());
        }
        if(jw.isHasStone()!=jwEdited.isHasStone()){
            jw.setHasStone(jwEdited.isHasStone());
        }
        if(jw.isAvailableForSale()!=jwEdited.isAvailableForSale()){
            jw.setAvailableForSale(jwEdited.isAvailableForSale());
        }
        if(jw.getParticularity()!=jwEdited.getParticularity()){
            jw.setParticularity(jwEdited.getParticularity());
        }
        if(jw.getWeight()!=jwEdited.getWeight()){
            jw.setWeight(jwEdited.getWeight());
        }

        return new MessageDTO("Jewerly ID: "+id+" edited successfully.");
    }

    private Jewerly convertJewerlyDtoToJewerly(JewerlyDTO jewerlyDTO){
        return new Jewerly(
                jewerlyDTO.getName(),
                jewerlyDTO.getMaterial(),
                jewerlyDTO.getWeight(),
                jewerlyDTO.getParticularity(),
                jewerlyDTO.isHasStone(),
                jewerlyDTO.isAvailableForSale()
        );
    }
}
