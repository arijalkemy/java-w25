package com.mercadolibre.linktracker.util;

import com.mercadolibre.linktracker.dto.response.ExceptionResponseDto;

public class ExceptionDtoMapper {
    private ExceptionDtoMapper() {
    }
    public static ExceptionResponseDto newExceptionResponseDto(Exception e) {
        return new ExceptionResponseDto(e.getMessage());
    }
}
