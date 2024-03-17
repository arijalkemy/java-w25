package com.meli.showroom.service;

import com.meli.showroom.dto.PrendaDTO;
import com.meli.showroom.dto.ResponseDTO;
import com.meli.showroom.dto.VentaDTO;
import com.meli.showroom.entity.Venta;

import java.time.LocalDateTime;
import java.util.List;

public interface IVentaService {
    VentaDTO newVenta(VentaDTO ventaDTO);
    List<VentaDTO> saveAll(List<VentaDTO> ventas);
    List<VentaDTO> getAllVentas();
    VentaDTO getVentaByNumber(Long number);
    VentaDTO updateVenta(VentaDTO ventaDTO, Long number);
    ResponseDTO deleteVentaByNumber(Long number);
    List<VentaDTO> getVentasByDate(String date);
    List<PrendaDTO> getPrendasFromVenta(Long number);

}
