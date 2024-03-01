package com.example.be_java_hisp_w25_g11.dto.commons.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;
import java.util.Comparator;

public enum EnumDateOrganizer {
    DATE_ASC("date_asc"),
    DATE_DESC("date_desc");

    private String name;
    private EnumDateOrganizer(String name){
        this.name = name;
    }
    @JsonCreator
    public static EnumDateOrganizer getOrganizer(String value){
        for(EnumDateOrganizer enumOrganizer: EnumDateOrganizer.values()){
            if(enumOrganizer.name.equals(value)){
                return enumOrganizer;
            }
        }

        return DATE_ASC;
    }

    public Comparator<LocalDate> getComparator(){
        return this == DATE_DESC ? Comparator.reverseOrder() : Comparator.naturalOrder();
    }
}
