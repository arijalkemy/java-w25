package bootcamp.extra.service.implementation;

import bootcamp.extra.dto.ResponseDTO;
import bootcamp.extra.dto.RequestClothDTO;
import bootcamp.extra.model.Cloth;
import bootcamp.extra.repository.IClothRepository;
import bootcamp.extra.service.IClothService;
import bootcamp.extra.dto.ClothDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothServiceImp implements IClothService {

    private final IClothRepository prendaRepository;

    private final ModelMapper mapper = new ModelMapper();

    public ClothServiceImp(IClothRepository prendaRepository){
        this.prendaRepository = prendaRepository;
    }


    @Override
    public ClothDTO createPrenda(RequestClothDTO cloth) {
        Cloth savedCloth = prendaRepository.save(mapper.map(cloth, Cloth.class));
        return mapper.map(savedCloth, ClothDTO.class);
    }

    @Override
    public List<ClothDTO> getPrendas(String name) {
        List<Cloth> clothes = name.isBlank() ? prendaRepository.findAll() : prendaRepository.findByNameContaining(name);

        return clothes.stream().map(c -> mapper.map(c, ClothDTO.class)).toList();
    }

    @Override
    public ClothDTO getPrendaByCode(String code) {
        return mapper.map(prendaRepository.getClothByCode(code), ClothDTO.class);
    }

    @Override
    public ClothDTO updatePrenda(String code, RequestClothDTO body) {
        Cloth clothToUpdate = mapper.map(body, Cloth.class);
        clothToUpdate.setCode(code);
        return mapper.map(prendaRepository.save(clothToUpdate), ClothDTO.class);
    }

    @Override
    public ResponseDTO deletePrenda(String code) {
        if(prendaRepository.getClothByCode(code) == null)
            return new ResponseDTO("Prenda inexistente");

        prendaRepository.deleteByCode(code);
        return new ResponseDTO("Prendas eliminadas con código: " + code);
    }

    @Override
    public List<ClothDTO> getPrendasBySize(String size) {
        return prendaRepository.findAllBySize(size).stream().map(c -> mapper.map(c, ClothDTO.class)).toList();
    }
}
