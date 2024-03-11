package joyeria.joyas.service;

import joyeria.joyas.DTO.Response.GenericResponseDto;
import joyeria.joyas.DTO.Response.JoyaDTO;
import joyeria.joyas.entity.Joya;
import joyeria.joyas.exception.NotFoundException;
import joyeria.joyas.repository.IJoyaRepository;

import java.util.List;
import java.util.Optional;

public class JoyaServiceImpl implements IJoyaService{

    private final IJoyaRepository repo;

    public JoyaServiceImpl(IJoyaRepository repo) {
        this.repo = repo;
    }

    @Override
    public GenericResponseDto create(JoyaDTO joya) {
        Joya joyaGuardada = repo.save(joya);

        return new GenericResponseDto("Joya nueva creada exitosamente con el id " + joyaGuardada.getId());
    }


    @Override
    public List<Joya> findAll() {
        return repo.findAll();
    }

    @Override
    public GenericResponseDto delete(Long id) {
        Optional<Joya> joyaBuscada = repo.findAll().stream().filter(joya -> joya.getId().equals(id)).findFirst();
        if(joyaBuscada.isEmpty()){
            throw new NotFoundException("No se encontró esa joya");
        }
        joyaBuscada.get().setVentaONo(false);

        return new GenericResponseDto("Joya con id "+id+"eliminada dada de baja con éxito.");
    }

    @Override
    public GenericResponseDto update(Joya joyaUpdate) {
        Joya previousJoya = (Joya) repo.findAll().stream().filter(joya -> joya.getId().equals(joyaUpdate.getId()));
        if(repo.findAll().stream().noneMatch(joya -> joya.getId().equals(joyaUpdate.getId()))){
            throw new NotFoundException("No se encontró esa joya");
        }
        previousJoya.setPeso(joyaUpdate.getPeso());
        previousJoya.setPosee_piedra(joyaUpdate.getPosee_piedra());
        previousJoya.setNombre(joyaUpdate.getNombre());
        previousJoya.setParticularidad(joyaUpdate.getParticularidad());
        previousJoya.setMaterial(joyaUpdate.getMaterial());
        repo.save(previousJoya);

        return new GenericResponseDto("Joya actualizada exitosamente con datos: "+ previousJoya);
    }
}
