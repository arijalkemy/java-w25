package org.example.prendas.controller;

import org.example.prendas.entity.Prenda;
import org.example.prendas.repository.PrendaRepository;
import org.example.prendas.service.IPrendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrendasController {
    private final IPrendaService prendaService;

    public PrendasController(IPrendaService prendaService){
        this.prendaService = prendaService;
    }

    @PostMapping
    public Prenda crearPrenda(@RequestBody Prenda prenda) {
        return prendaService.crearPrenda(prenda);
    }

    @GetMapping
    public List<Prenda> obtenerTodasPrendas() {
        return prendaService.obtenerTodasPrendas();
    }

    @GetMapping("/{codigo}")
    public Prenda obtenerPrendaPorCodigo(@PathVariable Long codigo) {
        return prendaService.obtenerPrendaPorCodigo(codigo);
    }

    @PutMapping("/{codigo}")
    public Prenda actualizarPrenda(@PathVariable Long codigo, @RequestBody Prenda prendaActualizada) {
        return prendaService.actualizarPrenda(codigo,prendaActualizada);
    }

    @DeleteMapping("/{codigo}")
    public void eliminarPrenda(@PathVariable Long codigo) {
        prendaService.eliminarPrenda(codigo);
    }

    @GetMapping("/size/{talle}")
    public List<Prenda> obtenerPrendasPorTalle(@PathVariable String talle) {
        return prendaService.obtenerPrendasPorTalle(talle);
    }

    @GetMapping
    public List<Prenda> buscarPrendasPorNombre(@RequestParam String name) {
        return prendaService.buscarPrendasPorNombre(name);
    }
}
