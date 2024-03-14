package com.meli.showroom.service;

import com.meli.showroom.dto.PrendaDTO;
import com.meli.showroom.entity.Prenda;
import com.meli.showroom.exception.NotFoundException;
import com.meli.showroom.repository.IPrendaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaServiceImpl implements IPrendaService{

    private final IPrendaRepository prendaRepository;
    private final ModelMapper mapper;

    public PrendaServiceImpl(IPrendaRepository prendaRepository, ModelMapper mapperConfig) {
        this.prendaRepository = prendaRepository;
        this.mapper= mapperConfig;
    }

    @Override
    public void savePrenda(PrendaDTO prendaDTO) {
        prendaRepository.save(mapper.map(prendaDTO, Prenda.class));
    }

    @Override
    public void saveAll(List<PrendaDTO> prendas) {
        prendaRepository.saveAll(
                prendas.stream().map(prendaDTO -> mapper.map(prendaDTO, Prenda.class)).toList()
        );
    }

    @Override
    public List<PrendaDTO> getPrendas() {
        return prendaRepository.findAll().stream().map(prenda -> mapper.map(prenda, PrendaDTO.class)).toList();
    }

    @Override
    public PrendaDTO getPrenda(Long id) {
        Prenda prenda = prendaRepository.findById(id).orElseThrow(() -> new NotFoundException("La prenda no existe"));
        return mapper.map(prenda, PrendaDTO.class);
    }

    @Override
    public void updatePrenda(Long id, PrendaDTO prendaDTO) {
        Prenda prenda = prendaRepository.findById(id).orElseThrow(() -> new NotFoundException("La prenda no existe"));

        if (prendaDTO.getCantidad() != null) prenda.setCantidad(prendaDTO.getCantidad());
        if (prendaDTO.getMarca() != null) prenda.setMarca(prendaDTO.getMarca());
        if (prendaDTO.getColor() != null) prenda.setColor(prendaDTO.getColor());
        if (prendaDTO.getTalla() != null) prenda.setTalla(prendaDTO.getTalla());
        if (prendaDTO.getNombre() != null) prenda.setTalla(prendaDTO.getTalla());
        if (prendaDTO.getTipo() != null) prenda.setTipo(prendaDTO.getTipo());
        if (prendaDTO.getPrecio_venta() != null) prenda.setPrecio_venta(prendaDTO.getPrecio_venta());

        prendaRepository.save(prenda);
    }

    @Override
    public void deletePrenda(Long id) {
        prendaRepository.deleteById(id);
    }

    @Override
    public List<PrendaDTO> getPrendasByTalla(String talla) {
        return prendaRepository.findAllByTalla(talla).stream().map(prenda -> mapper.map(prenda, PrendaDTO.class)).toList();
    }

    @Override
    public List<PrendaDTO> getPrendasByNombre(String nombre) {
        return prendaRepository.findAllByNombreContains(nombre).stream().map(prenda -> mapper.map(prenda, PrendaDTO.class)).toList();
    }
}
