package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.exception.BadRequestException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    /**
     * Receive a String format date to be converted to a LocalDate format date
     * @param dateString String date to be converted to LocalDate
     * @return Returns a new LocalDate
     */
    public static LocalDate parseDateString(String dateString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(dateString, formatter);
        }catch (DateTimeParseException e){
            throw new BadRequestException("Tipo fecha incorrecta");
        }
    }

    /**
     * Receive a LocalDate date to be converted to a String date with format "dd-MM-yyyy"
     * @param dateLocalDate LocalDate date to be converted
     * @return Returns a String formatted date
     */
    public static String parseDateLocalDate(LocalDate dateLocalDate){
        return String.format("%02d",dateLocalDate.getDayOfMonth()) + "-" + String.format("%02d", dateLocalDate.getMonthValue())  + "-" + dateLocalDate.getYear();
    }

}
