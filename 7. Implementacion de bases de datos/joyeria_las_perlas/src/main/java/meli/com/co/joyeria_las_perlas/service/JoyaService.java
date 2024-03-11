package meli.com.co.joyeria_las_perlas.service;

import meli.com.co.joyeria_las_perlas.dto.request.JoyaDto;
import meli.com.co.joyeria_las_perlas.dto.response.MessageDto;
import meli.com.co.joyeria_las_perlas.dto.response.SavedJoyaDto;
import meli.com.co.joyeria_las_perlas.service.interfaces.IJoyaService;
import meli.com.co.joyeria_las_perlas.exception.NotFoundException;
import meli.com.co.joyeria_las_perlas.model.Joya;
import meli.com.co.joyeria_las_perlas.repository.IJoyaRepository;
import meli.com.co.joyeria_las_perlas.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    private final IJoyaRepository joyaRepository;
    private final Mapper mapper;

    public JoyaService(IJoyaRepository joyaRepository, Mapper mapper) {
        this.joyaRepository = joyaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<JoyaDto> getAll() {
        List<Joya> result = joyaRepository.findAll();
        List<JoyaDto> dto = result.stream().filter(Joya::getVentaONo).map(mapper::toDto).toList();
        if (result.isEmpty() || dto.isEmpty()) throw new NotFoundException("No hay ninguna joya almacenada");
        return dto;
    }

    @Override
    public JoyaDto getById(Long id) {
        return mapper.toDto(joyaRepository.findById(id).orElse(new Joya()));
    }

    @Override
    public SavedJoyaDto create(JoyaDto joyaDto) {
        return save(mapper.toJoya(joyaDto));
    }

    @Override
    public SavedJoyaDto update(JoyaDto joyaDto, Long id) {
        Joya toSave = joyaRepository.findById(id).orElse(null);
        if (toSave == null) throw new NotFoundException("El id de la joya ingresado no existe");
        toSave.setNombre(joyaDto.getNombre());
        toSave.setMaterial(joyaDto.getMaterial());
        toSave.setParticularidad(joyaDto.getParticularidad());
        toSave.setPeso(joyaDto.getPeso());
        toSave.setPoseePiedra(joyaDto.getPosee_piedra());
        return save(toSave);
    }

    @Override
    public MessageDto delete(Long id) {
        Joya toSave = joyaRepository.findById(id).orElse(null);
        if (toSave == null || !toSave.getVentaONo()) throw new NotFoundException("El id de la joya ingresado no existe");
        toSave.setVentaONo(false);
        joyaRepository.save(toSave);
        return new MessageDto("Joya borrada correctamente");
    }

    private SavedJoyaDto save(Joya joya){
        Joya result = joyaRepository.save(joya);
        return new SavedJoyaDto("La joya fue guardada correctamente", result.getId());
    }
}
