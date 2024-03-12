package com.mercadolibre.testerapi.service;

import com.mercadolibre.testerapi.dto.MessageDto;
import com.mercadolibre.testerapi.dto.TesterDto;

public interface ITesterService {
    MessageDto save(TesterDto testerDto);

    MessageDto deleteById(Long id);

    // TesterDto findTesterById(Long id);
}
