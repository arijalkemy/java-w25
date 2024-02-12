package com.example.concesionaria.service;

import com.example.concesionaria.dto.request.VehicleDTO;
import com.example.concesionaria.dto.response.CompleteVehicleDTO;
import com.example.concesionaria.dto.response.SaveDTO;
import com.example.concesionaria.dto.response.VehicleResponseDTO;

import java.util.List;

public interface IVehicleService {
  SaveDTO save(VehicleDTO vehicle);
  List<VehicleResponseDTO> getAll();
  CompleteVehicleDTO getById(String id);
}
