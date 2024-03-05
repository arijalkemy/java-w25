package org.example.age.helper;

import java.time.LocalDate;
import java.time.Period;

public class AgeHelper {

    public static boolean isValidBirthday(int day, int month, int year) {
        return LocalDate.now().isAfter(LocalDate.of(year, month, day));
    }

    public static int getAgeByBirthday(int day, int month, int year) {
        return Period.between(LocalDate.of(year, month, day), LocalDate.now()).getYears();
    }
}
