package meli.com.co.joyeria_las_perlas.util;

import meli.com.co.joyeria_las_perlas.dto.request.JoyaDto;
import meli.com.co.joyeria_las_perlas.model.Joya;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    private final ModelMapper modelMapper;

    public Mapper() {
        this.modelMapper = new ModelMapper();
    }

    public Joya toJoya(JoyaDto joyaDto){
        return modelMapper.map(joyaDto, Joya.class);
    }

    public JoyaDto toDto(Joya joya){
        return modelMapper.map(joya, JoyaDto.class);
    }

}
