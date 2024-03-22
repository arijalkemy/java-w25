package com.example.ejercicio_deportistas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SportPersonDTO {
    @JsonProperty("name")
    String name;
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("sport_name")
    String sportName;
}
