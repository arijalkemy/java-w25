package com.dto.deportistas.dto;

import com.dto.deportistas.model.Deporte;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonaDTO {
    public String nombre;
    public String apellido;
    public String deporte;
}
/*
private void loadJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = null;
        try {
            // Lee el archivo JSON
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            this.personajes = objectMapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 */