package com.COVID19.COVID19.service;

import com.COVID19.COVID19.dto.RiskPersonDto;

import java.util.List;

public interface IPersonsService {
    public List<RiskPersonDto> getRiskPersons();
}
