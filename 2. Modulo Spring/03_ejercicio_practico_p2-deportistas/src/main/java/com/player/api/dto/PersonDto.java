package com.player.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.util.List;
import com.player.api.classes.Person;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
class PersonDto {
    List<Person> PersonaList;
}
