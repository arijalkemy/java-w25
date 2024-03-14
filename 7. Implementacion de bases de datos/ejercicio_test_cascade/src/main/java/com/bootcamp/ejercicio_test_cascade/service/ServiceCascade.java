package com.bootcamp.ejercicio_test_cascade.service;

import com.bootcamp.ejercicio_test_cascade.model.Direccion;
import com.bootcamp.ejercicio_test_cascade.model.Mascota;
import com.bootcamp.ejercicio_test_cascade.model.Propietario;
import com.bootcamp.ejercicio_test_cascade.model.Vacuna;
import com.bootcamp.ejercicio_test_cascade.repository.IMascotaRepository;
import com.bootcamp.ejercicio_test_cascade.repository.IPropietarioRepository;
import com.bootcamp.ejercicio_test_cascade.repository.IVacunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServiceCascade implements IServiceCascade {
    @Autowired
    IPropietarioRepository propietarioRepository;
    @Autowired
    IMascotaRepository mascotaRepository;
    @Autowired
    IVacunaRepository vacunaRepository;

    public void SetupDesdePropietario() {
        Propietario propietario = new Propietario(
                "Juan Carlos"
        );
        Mascota mascota = new Mascota(
                "pedro",
                propietario
        );
        Mascota mascota1 = new Mascota(
                "Juana",
                propietario
        );
        propietario.getMascotas().addAll(List.of(mascota1, mascota));
        propietario = propietarioRepository.save(propietario);
        Vacuna vacuna = new Vacuna(
                "vacuna",
                1,
                Set.of(mascota)
        );

        vacunaRepository.save(vacuna);
        //agregar direccion
        Direccion direccion = new Direccion(
                "Belgrano 247",
                propietario
        );

        propietario.setDireccion(direccion);
        propietarioRepository.save(propietario);
    }

}


