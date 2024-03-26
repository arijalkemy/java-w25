package com.example.QATesters.dto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MessageDto {
    String message;
}
