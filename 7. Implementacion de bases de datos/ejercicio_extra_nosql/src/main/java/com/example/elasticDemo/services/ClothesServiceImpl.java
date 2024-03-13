package com.example.elasticDemo.services;

import com.example.elasticDemo.dto.ClothesDTO;
import com.example.elasticDemo.dto.ResponseDTO;
import com.example.elasticDemo.model.Clothes;
import com.example.elasticDemo.repositories.IClothersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesServiceImpl implements IClothesService{
    private IClothersRepository repository;
    private ModelMapper mapper = new ModelMapper();


    public ClothesServiceImpl(IClothersRepository repository){
        this.repository = repository;
    }
    @Override
    public ClothesDTO create(ClothesDTO clothesDTO){
        Clothes clothes = mapper.map(clothesDTO, Clothes.class);
        clothes = repository.save(clothes);
        return mapper.map(clothes, ClothesDTO.class);
    }
    @Override
    public ClothesDTO update(ClothesDTO clothesDTO){
        Optional<Clothes> clothes = repository.findById(clothesDTO.getId());
        if(clothes.isEmpty()) throw new RuntimeException("No se encontró el id solicitado");
        Clothes c = clothes.get();
        c.setCantidad(clothesDTO.getCantidad());
        c.setColor(clothesDTO.getColor());
        c.setNombre(clothesDTO.getNombre());
        c.setMarca(clothesDTO.getNombre());
        c.setTipo(clothesDTO.getTipo());
        c.setTalle(clothesDTO.getTalle());
        c.setPrecio_venta(clothesDTO.getPrecio_venta());
        c = repository.save(c);
        return mapper.map(c, ClothesDTO.class);
    }
    @Override
    public ResponseDTO delete(String id){
        repository.deleteById(id);
        return new ResponseDTO("Se elimino exitosamente el id: " + id);
    }
    @Override
    public List<ClothesDTO> findAll(){
        List<Clothes> clothes = (List<Clothes>) repository.findAll();
        return clothes.stream().map(c -> mapper.map(c, ClothesDTO.class)).toList();
    }
    @Override
    public ClothesDTO findById(String  id){
        Optional<Clothes> clothes = repository.findById(id);
        if(clothes.isEmpty()) throw new RuntimeException("");
        return mapper.map(clothes.get(), ClothesDTO.class);
    }
    @Override
    public List<ClothesDTO> findAllByTalle(Double talle) {
        List<Clothes> clothes = repository.findAllByTalle(talle);
        return clothes.stream().map(c -> mapper.map(c, ClothesDTO.class)).toList();
    }
    @Override
    public List<ClothesDTO> findAllByNameRegex(String clave) {
        List<Clothes> clothes = repository.findAllByNombreMatchesRegex("%" + clave + "%");
        return clothes.stream().map(c -> mapper.map(c, ClothesDTO.class)).toList();
    }

}
