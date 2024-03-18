package org.example.prendas.service;

import org.example.prendas.dto.CreateSaleDTO;
import org.example.prendas.dto.SaleDTO;
import org.example.prendas.entity.Prenda;
import org.example.prendas.entity.Venta;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISaleService {
    List<Venta> getSales(LocalDate date);

    Venta create(CreateSaleDTO body);

    Venta getSale(long number);

    Venta modify(long number, CreateSaleDTO body);

    Object delete(long number);

    List<Prenda> getSaleClothes(long number);
}
