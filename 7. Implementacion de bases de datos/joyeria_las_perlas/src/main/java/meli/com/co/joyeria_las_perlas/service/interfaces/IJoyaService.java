package meli.com.co.joyeria_las_perlas.service.interfaces;

import meli.com.co.joyeria_las_perlas.dto.request.JoyaDto;
import meli.com.co.joyeria_las_perlas.dto.response.MessageDto;
import meli.com.co.joyeria_las_perlas.dto.response.SavedJoyaDto;

import java.util.List;

public interface IJoyaService {

    public List<JoyaDto> getAll();
    public JoyaDto getById(Long id);
    public SavedJoyaDto create(JoyaDto joyaDto);
    public SavedJoyaDto update(JoyaDto joyaDto, Long id);
    public MessageDto delete(Long id);
}
