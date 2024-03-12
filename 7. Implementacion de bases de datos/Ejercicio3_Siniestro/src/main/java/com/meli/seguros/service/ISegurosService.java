package com.meli.seguros.service;

import com.meli.seguros.dto.*;
import java.util.List;

public interface ISegurosService {
    ResNewVehiculoDto addNewVehiculo(NewVehiculoDto v);
    ResSiniestroDto addNewSiniestro(NewSiniestroDto s);

    List<String> listarPatentes();

}
