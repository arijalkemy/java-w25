package com.mercadolibre.be_java_hisp_w25_g15.utils;

import com.mercadolibre.be_java_hisp_w25_g15.dto.request.DateOrderEnumDto;
import org.springframework.core.convert.converter.Converter;

public class StringToDateOrderEnumConverter implements Converter<String, DateOrderEnumDto> {
    @Override
    public DateOrderEnumDto convert(String source) {
        return DateOrderEnumDto.valueOf(source.toUpperCase());
    }
}
