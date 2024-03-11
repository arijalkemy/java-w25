package com.crud.crud_con_jpa.service;

import com.crud.crud_con_jpa.dto.JewelDTO;
import com.crud.crud_con_jpa.models.Jewel;
import com.crud.crud_con_jpa.repository.JewelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JewelServiceImpl implements JewelService {
    JewelRepository jewelRepository;

    public JewelServiceImpl(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jewel> getAllJewels() {
        return jewelRepository.findAll();
    }

    @Override
    @Transactional
    public void saveJewel(Jewel newJewel) {
        jewelRepository.save(newJewel);
    }

    @Override
    @Transactional
    // Se debe implementar borrado lógico, seteando forSale a False
    public void deleteJewel(Long id){
        Optional<Jewel> myOptionalJewel = jewelRepository.findById(id);
        if (myOptionalJewel.isEmpty()){
            // Manejar excepcion aqui
            return;
        }
        Jewel myJewel = myOptionalJewel.get();
        myJewel.setForSale(false);
        jewelRepository.save(myJewel);
    };

    @Override
    @Transactional(readOnly = true)
    public Optional<Jewel> getJewelById(Long id) {
        return jewelRepository.findById(id);
    }


    @Override
    @Transactional
    // En este caso, se solicita implementar borrado lógico, seteando forSale a False
    public void modifyJewel(Long id_modificar, Jewel jewelMod){
        Optional<Jewel> originalJewelOptional = jewelRepository.findById(id_modificar);
        if (originalJewelOptional.isEmpty()) {
            System.out.println("ID de joya no encontrado");
            // Manejar excepcion aqui
            return;
        }
        Jewel originalJewel = originalJewelOptional.get();
        // originalJewel.setId(jewelMod.getId()); NO SE DEBE INTENTAR MODIFICAR EL ID!!!
        originalJewel.setParticularity(jewelMod.getParticularity());
        originalJewel.setMaterial(jewelMod.getMaterial());
        jewelRepository.save(originalJewel);
    };

}
