package bootcamp.dtoresponseentityvivo.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class BirthdayServiceImp implements IBirthdayService {
    @Override
    public boolean checkDate(Integer day, Integer month, Integer year){
        Date birthday = new Date(year-1900,month, day); //Se resta 1900 por como funciona el new Date con parametros
        Date today = new Date();
        return birthday.before(today);
    }

    @Override
    public int calculateAge(Integer day, Integer month, Integer year){
        LocalDate today = LocalDate.now();
        int age = today.getYear() - year;
        if (month > today.getMonthValue() || month == today.getMonthValue() && day > today.getDayOfMonth()) age -= 1;

        return age;
    }
    private int calcularEdad2(int day, int month, int year){
        LocalDate fechaLocal= LocalDate.now();
        LocalDate cumpleaños = LocalDate.of(day, month, year);

        Period period = Period.between(cumpleaños,fechaLocal);
        int edad = period.getYears();
        return edad;
    }
}
