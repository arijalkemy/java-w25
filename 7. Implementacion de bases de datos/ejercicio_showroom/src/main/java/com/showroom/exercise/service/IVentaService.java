package com.showroom.exercise.service;

import com.showroom.exercise.dto.PrendaDTO;
import com.showroom.exercise.dto.ResponseDTO;
import com.showroom.exercise.dto.VentaDTO;

import java.util.List;

public interface IVentaService {
    VentaDTO saveVenta(VentaDTO ventaDTO);
    List<VentaDTO> getAllVentas();
    VentaDTO getVentaByNumber(Long number);
    VentaDTO updateVenta(Long number, VentaDTO ventaDTO);
    ResponseDTO deleteVenta(Long number);
    List<VentaDTO> getVentasByDate(String date);
    List<PrendaDTO> getPrendasFromVentaById(Long number);
}
