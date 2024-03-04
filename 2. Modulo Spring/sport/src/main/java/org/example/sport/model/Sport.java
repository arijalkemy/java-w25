package org.example.sport.model;

import org.example.sport.enums.EnumSportLevel;

public class Sport {
    private String name;
    private EnumSportLevel level;

    public String getName() {
        return name;
    }

    public EnumSportLevel getLevel() {
        return level;
    }

    public Sport(String name, EnumSportLevel level) {
        this.name = name;
        this.level = level;
    }
}
