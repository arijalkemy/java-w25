package com.mercadolibre.be_java_hisp_w25_g15.config;

import com.mercadolibre.be_java_hisp_w25_g15.utils.StringToDateOrderEnumConverter;
import com.mercadolibre.be_java_hisp_w25_g15.utils.StringToPriceOrderEnumConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToDateOrderEnumConverter());
        registry.addConverter(new StringToPriceOrderEnumConverter());
    }
}