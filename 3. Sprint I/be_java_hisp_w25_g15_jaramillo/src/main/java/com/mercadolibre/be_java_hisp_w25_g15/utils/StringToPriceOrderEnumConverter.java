package com.mercadolibre.be_java_hisp_w25_g15.utils;

import com.mercadolibre.be_java_hisp_w25_g15.dto.request.PriceOrderEnumDto;
import org.springframework.core.convert.converter.Converter;

public class StringToPriceOrderEnumConverter  implements Converter<String, PriceOrderEnumDto> {
    @Override
    public PriceOrderEnumDto convert(String source) {
        return PriceOrderEnumDto.valueOf(source.toUpperCase());
    }
}
