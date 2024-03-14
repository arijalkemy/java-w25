package com.example.qa_testers.utils;

import com.example.qa_testers.exceptions.BadRequestException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public static LocalDate parseDateString(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(dateString, formatter);
        }catch (DateTimeParseException e){
            throw new BadRequestException("Tipo fecha incorrecta");
        }
    }
}
