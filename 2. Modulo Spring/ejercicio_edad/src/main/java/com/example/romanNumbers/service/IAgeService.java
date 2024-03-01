package com.example.romanNumbers.service;

import com.example.romanNumbers.dto.response.AgeDTO;

public interface IAgeService {
    AgeDTO calculate(Integer day, Integer month, Integer year);

}
