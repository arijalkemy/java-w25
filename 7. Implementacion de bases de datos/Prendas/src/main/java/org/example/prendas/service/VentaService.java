package org.example.prendas.service;

import org.example.prendas.dto.CreateSaleDTO;
import org.example.prendas.dto.SaleDTO;
import org.example.prendas.entity.Prenda;
import org.example.prendas.entity.Venta;
import org.example.prendas.repository.PrendaRepository;
import org.example.prendas.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class VentaService implements ISaleService{

    private VentaRepository repository;

    private PrendaRepository prendaRepository;

    VentaService(VentaRepository repository, PrendaRepository prendaRepository) {
        this.repository = repository;
        this.prendaRepository = prendaRepository;
    }

    @Override
    public List<Venta> getSales(LocalDate date) {
        return date != null ? repository.findByDate(date) : repository.findAll();
    }

    @Override
    public Venta create(CreateSaleDTO body) {
        Venta venta = new Venta();
        venta.setDate(LocalDate.now());
        venta.setPayment(body.payment());
        venta.setTotal(body.total());

        List<Prenda> prendas = prendaRepository.findAllById(body.prendas());

        venta.setPrendas(new HashSet<>(prendas));

        return repository.save(venta);
    }

    @Override
    public Venta getSale(long number) {
        return repository.findByNumber(number);
    }

    @Override
    public Venta modify(long number, CreateSaleDTO body) {
        Venta venta = repository.findByNumber(number);

        venta.setTotal(body.total());
        venta.setPayment(body.payment());

        return repository.save(venta);
    }

    @Override
    public Object delete(long number) {
        Venta venta = repository.findByNumber(number);
        repository.delete(venta);
        return new HashMap<>();
    }

    @Override
    public List<Prenda> getSaleClothes(long number) {
        return new ArrayList<>(repository.getVentaPrendas(number));
    }
}
