package com.example.romanNumbers.service;

import com.example.romanNumbers.dto.response.AgeDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

@Service
public class AgeServiceImpl implements IAgeService {

    @Override
    public AgeDTO calculate(Integer day, Integer month, Integer year) {
        LocalDate bornDate = LocalDate.of(year,month,day);
        LocalDate now = LocalDate.now();
        int age = Period.between(bornDate, now).getYears();
        return new AgeDTO(age);
    }
}
