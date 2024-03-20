package com.bootcamp.ejercicio_showroom.service;

import com.bootcamp.ejercicio_showroom.dto.request.VentaReqDto;
import com.bootcamp.ejercicio_showroom.dto.response.PrendaRespDto;
import com.bootcamp.ejercicio_showroom.dto.response.ResponseDTO;
import com.bootcamp.ejercicio_showroom.dto.response.VentaRespDto;
import com.bootcamp.ejercicio_showroom.model.Prenda;

import java.time.LocalDate;
import java.util.List;

public interface ISalesService {

    List<VentaRespDto> getSalesOnDate(String date);

    VentaRespDto getSaleByNumber(Long number);

    List<VentaRespDto> getAllSales();

    VentaRespDto addVenta(VentaReqDto ventaReqDto);

    VentaRespDto updateVenta(Long id, VentaReqDto ventaReqDto);

    List<PrendaRespDto> getClothesBySaleNumber(Long number);

    ResponseDTO deleteSaleById(Long id);
}
