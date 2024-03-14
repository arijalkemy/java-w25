package com.example.vehiculossiniestros.service;

import com.example.vehiculossiniestros.dto.PatenteMarcaDto;
import com.example.vehiculossiniestros.dto.PatenteMarcaModeloDto;
import com.example.vehiculossiniestros.dto.VehiculoDto;
import com.example.vehiculossiniestros.dto.VehiculoSiniestroDto;
import com.example.vehiculossiniestros.entity.Vehiculo;
import org.aspectj.weaver.ast.Literal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IVehiculoService{

  VehiculoDto createVehicle(VehiculoDto vehiculoDto);
  List<VehiculoDto> getAllVehicles();
  List<String> getAllPatents();
  List<PatenteMarcaDto> getAllPatentsAndBrands();
  List<String> getFourWheelsAndCurrentYearVehicles();
  List<PatenteMarcaModeloDto> getMajorsSinisterInfo();
  List<VehiculoSiniestroDto> getMajorsSinisterFullInfo();


}
