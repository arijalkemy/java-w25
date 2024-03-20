package com.prendas.service;

import com.prendas.dto.PrendaDto;
import com.prendas.dto.ResponseDto;
import com.prendas.dto.VentaDto;
import com.prendas.entity.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    ResponseDto save(VentaDto ventaDto);
    List<VentaDto> listVentas();
    VentaDto findByNumber(Long number);
    ResponseDto update(Long number, VentaDto ventaDto);
    ResponseDto remove(Long number);
    List<VentaDto> listByDate(LocalDate date);
    List<PrendaDto> listVentaPrendas(Long number);

}
