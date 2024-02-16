package com.player.api.classes;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Sport {
    String name;
    String level;
}


