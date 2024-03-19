package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDto;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

import java.io.IOException;

@Service
public class CurrencyConversionService extends RestClientService{

    @Value("${meli.base.url}")
    private String baseUrl;

    private String conversionApiBaseUrl;

    private RestClient conversionApiClient;

    public CurrencyConversionService() throws IOException{
        super();
    }


    @PostConstruct
    public void init() throws IOException {
        conversionApiBaseUrl = String.format("%s/currency_conversions/search",baseUrl);
        conversionApiClient = RestClient.builder()
                .withPool(restPool)
                .build();
    }

    public Double convertToUsd(ItemDTO item) throws RestException, ParseException {
        Double ratio = getRatio(item.getCurrencyId(), CurrencyEnum.USD);
        return item.getPrice() * ratio;
    }

    private Double getRatio(CurrencyEnum from, CurrencyEnum to) throws RestException, ParseException {
        String url = String.format("%s?from=%s&to=%s",
                conversionApiBaseUrl,
                from.toString(),
                to.toString());
        Response response = conversionApiClient.get(url);
        CurrencyConversionDto ratio = response.getData(CurrencyConversionDto.class);
        return ratio.getRatio();
    }
}
