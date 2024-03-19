package com.example.practicaES.dto;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDto<T> {
    String message;
    T data;

    public MessageDto(String message){
        this.message = message;
        this.data = null;
    }
}
