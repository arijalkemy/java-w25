package com.player.api.classes;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Person {
    String firstName;
    String lastName;
    int age;
    List<Sport> Sports;
}
