package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.MessageDTO;
import com.bootcamp.LasPerlas.exception.NotFoundException;
import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{
    private final IJoyaRepository joyaRepo;

    JoyaService (IJoyaRepository joyaRepo) {
        this.joyaRepo = joyaRepo;
    }

    @Override
    public MessageDTO saveJoya(Joya joya) {
       Joya newJoya = joyaRepo.save(joya);
       return new MessageDTO("Joya guardada correctamente con numero identificatorio " + newJoya.getNro_id());
    }

    @Override
    public List<Joya> getJoyas() {
        List<Joya> joyas = joyaRepo.findAll();
        return joyas.stream()
                .filter(Joya::isVentaONo)
                .collect(Collectors.toList());
    }

    @Override
    public Joya findJoya(Long id) {
        Optional<Joya> joya = joyaRepo.findById(id);
        if (joya.isPresent()) {
            if (joya.get().isVentaONo()) {
                return joya.get();
            }
        }
        throw new NotFoundException("Joya no encontrada"
            + " con el id " + id
            + " o no se encuentra a la venta"
        );
    }

    @Override
    public MessageDTO deleteJoya(Long id) {

        //haremos borrado lógico, por lo cual no eliminamos el registro de la bd
        //sino que solo cambiamos su estado de verdadero (a la venta) a falso (no a la venta)

        Joya joyaOriginal = this.findJoya(id);
        joyaOriginal.setVentaONo(false);
        this.saveJoya(joyaOriginal);

        return new MessageDTO("Joya dada de baja para la venta correctamente");
    }

    @Override
    public MessageDTO editJoya(Long id_modificar, Joya joya_modif) {

        Joya joyaOriginal = this.findJoya(id_modificar);

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.isPosee_piedra());
        joyaOriginal.setVentaONo(joya_modif.isVentaONo());

        this.saveJoya(joyaOriginal);
        return new MessageDTO("Modificaciones guardadas correctamente");

    }
}
