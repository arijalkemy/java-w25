package com.relations.relations.service;

import com.relations.relations.Excepciones.NotFoundException;
import com.relations.relations.dto.request.RequestCarritoDto;
import com.relations.relations.dto.response.GenericReponseDTO;
import com.relations.relations.dto.response.ResponseCarritoDto;
import com.relations.relations.model.Carrito;
import com.relations.relations.repository.ICarritoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServiceImp implements ICarritoService{
    private ModelMapper mapper=new ModelMapper();
    @Autowired
    ICarritoRepository carritoRepository;

    @Override
    public List<ResponseCarritoDto> getAll(){
        return carritoRepository.findAll().stream().map(carrito -> mapper.map(carrito, ResponseCarritoDto.class)).toList();
    }

    @Override
    public ResponseCarritoDto getById(Long id){
        Carrito carrito=carritoRepository.findById(id).orElseThrow(()->new NotFoundException("El carrito con id" + id + " no fue encontrado"));

        return mapper.map(carrito, ResponseCarritoDto.class);
    }


    @Override
    public GenericReponseDTO save(RequestCarritoDto carritoDto){
        System.out.println(carritoDto);
        Carrito carrito = mapper.map(carritoDto, Carrito.class);
        carrito.getProductos().stream().forEach(p-> p.setCarrito(carrito));
        Carrito resulty = carritoRepository.save(carrito);
        String mensaje = resulty != null ? "Carrito guardado Correctamente" : "Error al guardar el carrito";
        return new GenericReponseDTO(mensaje);
    }
    @Override
    public GenericReponseDTO deleteById(Long id){
        getById(id);
        carritoRepository.deleteById(id);
        return new GenericReponseDTO("Carrito eliminado correctamente");
    }
}
