package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.exception.BadRequestException;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public static LocalDate parseDateString(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(dateString, formatter);
        }catch (DateTimeParseException e){
            throw new BadRequestException("Tipo fecha incorrecta");
        }
    }

    public static String parseDateLocalDate(LocalDate dateLocalDate){
        return String.format("%02d",dateLocalDate.getDayOfMonth()) + "-" + String.format("%02d", dateLocalDate.getMonthValue())  + "-" + dateLocalDate.getYear();
    }

}
