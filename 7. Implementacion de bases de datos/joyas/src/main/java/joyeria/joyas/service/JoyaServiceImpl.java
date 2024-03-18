package joyeria.joyas.service;

import joyeria.joyas.DTO.Response.GenericResponseDto;
import joyeria.joyas.DTO.Response.JoyaDTO;
import joyeria.joyas.entity.Joya;
import joyeria.joyas.exception.NotFoundException;
import joyeria.joyas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class JoyaServiceImpl implements IJoyaService{

    private final IJoyaRepository repo;

    public JoyaServiceImpl(IJoyaRepository repo) {
        this.repo = repo;
    }

    @Override
    public GenericResponseDto create(JoyaDTO joya) {
        Joya nuevaJoya = joyaTranslator(joya);
        Joya joyaGuardada = repo.save(nuevaJoya);
        return new GenericResponseDto("Joya nueva creada exitosamente con el id " + joyaGuardada.getId());
    }


    @Override
    public List<Joya> findAll() {
        return repo.findAll().stream().filter(joya -> joya.getVentaONo().equals(true)).toList();
    }

    @Override
    public GenericResponseDto delete(Long id) {
        Optional<Joya> joyaBuscada = repo.findById(id);
        if(joyaBuscada.isEmpty()){
            throw new NotFoundException("No se encontró esa joya");
        }
        joyaBuscada.get().setVentaONo(false);
        repo.save(joyaBuscada.get());
        return new GenericResponseDto("Joya con id "+id+" dada de baja con éxito.");
    }

    @Override
    public GenericResponseDto update(JoyaDTO joyaUpdate, Long id) {
        Optional<Joya> optionalJoyaExistente = repo.findById(id);
        if (optionalJoyaExistente.isEmpty()) {
            throw new NotFoundException("No se encontró esa joya");
        }
        Joya joyaExistente = optionalJoyaExistente.get();
        joyaExistente.setNombre(joyaUpdate.getNombre());
        joyaExistente.setMaterial(joyaUpdate.getMaterial());
        joyaExistente.setPeso(joyaUpdate.getPeso());
        joyaExistente.setParticularidad(joyaUpdate.getParticularidad());
        joyaExistente.setPosee_piedra(joyaUpdate.getPosee_piedra());
        repo.save(joyaExistente);

        return new GenericResponseDto("Joya actualizada exitosamente con datos: " + joyaExistente);
    }


    public Joya joyaTranslator(JoyaDTO joyaDTO){
        Joya joya = new Joya();
        joya.setNombre(joyaDTO.getNombre());
        joya.setMaterial(joyaDTO.getMaterial());
        joya.setPeso(joyaDTO.getPeso());
        joya.setParticularidad(joyaDTO.getParticularidad());
        joya.setPosee_piedra(joyaDTO.getPosee_piedra());
        joya.setVentaONo(true);

        return joya;
    }
}
