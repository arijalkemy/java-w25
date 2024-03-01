package com.example.be_java_hisp_w25_g11.dto.commons.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Comparator;

public enum EnumNameOrganizer {
    NAME_ASC("name_asc"),
    NAME_DESC("name_desc");

    private String name;
    private EnumNameOrganizer(String name){
        this.name = name;
    }

    @JsonCreator
    public static EnumNameOrganizer getOrganizer(String value){
        for(EnumNameOrganizer enumOrganizer: EnumNameOrganizer.values()){
            if(enumOrganizer.name.equals(value)){
                return enumOrganizer;
            }
        }
        return null;
    }

    public Comparator<String> getComparator(){
        return this.equals(NAME_ASC) ?  Comparator.naturalOrder() : Comparator.reverseOrder();
    }

}
