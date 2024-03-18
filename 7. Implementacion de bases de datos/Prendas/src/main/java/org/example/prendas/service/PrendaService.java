package org.example.prendas.service;

import org.example.prendas.repository.PrendaRepository;

import org.example.prendas.entity.Prenda;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrendaService implements  IPrendaService{
    private final PrendaRepository prendaRepository;

    public PrendaService(PrendaRepository prendaRepository){
        this.prendaRepository = prendaRepository;
    }

    @Override
    public Prenda crearPrenda(Prenda prenda) {
        return prendaRepository.save(prenda);
    }

    @Override
    public List<Prenda> obtenerTodasPrendas() {
        return prendaRepository.findAll();
    }

    @Override
    public Prenda obtenerPrendaPorCodigo(Long codigo) {
        return prendaRepository.findByCodigo(codigo);
    }

    @Override
    public Prenda actualizarPrenda(Long codigo, Prenda prendaActualizada) {
        Prenda prendaExistente = prendaRepository.findByCodigo(codigo);

        prendaExistente.setNombre(prendaActualizada.getNombre());
        prendaExistente.setCantidad(prendaActualizada.getCantidad());
        prendaExistente.setMarca(prendaActualizada.getMarca());
        prendaExistente.setColor(prendaActualizada.getColor());
        prendaExistente.setTipo(prendaActualizada.getTipo());
        prendaExistente.setTalle(prendaActualizada.getTalle());
        prendaExistente.setPrecioVenta(prendaActualizada.getPrecioVenta());

        return prendaRepository.save(prendaExistente);
    }

    @Override
    public void eliminarPrenda(Long codigo) {
        Prenda prenda = prendaRepository.findByCodigo(codigo);
        prendaRepository.delete(prenda);
    }

    @Override
    public List<Prenda> obtenerPrendasPorTalle(String talle) {
        return prendaRepository.findByTalle(talle);
    }

    @Override
    public List<Prenda> buscarPrendasPorNombre(String name) {
        return prendaRepository.findByNombreContainingIgnoreCase(name);
    }
}
