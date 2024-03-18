package org.example.prendas.service;
import org.example.prendas.entity.Prenda;
import java.util.List;

public interface IPrendaService {
    Prenda crearPrenda(Prenda prenda);
    List<Prenda> obtenerTodasPrendas();
    Prenda obtenerPrendaPorCodigo(Long codigo);
    Prenda actualizarPrenda(Long codigo, Prenda prendaActualizada);
    void eliminarPrenda(Long codigo);
    List<Prenda> obtenerPrendasPorTalle(String talle);
    List<Prenda> buscarPrendasPorNombre(String name);
}
