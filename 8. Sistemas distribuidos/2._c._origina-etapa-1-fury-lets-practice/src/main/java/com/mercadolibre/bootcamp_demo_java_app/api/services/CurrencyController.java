package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class CurrencyController extends RestClientService{
    @Value("${meli.base.url}")
    private String baseUrl;

    private String currencyApiBaseUrl;

    private RestClient currencyApiClient;

    public CurrencyController() throws IOException {
        super();
    }

    @PostConstruct
    public void init() throws IOException {
        currencyApiBaseUrl = String.format("%s/currency_conversions/",baseUrl);
        currencyApiClient = RestClient.builder()
                .withPool(restPool)
                .build();
    }

    public CurrencyConversionDTO getCurrencyConversionInfo(CurrencyEnum base, CurrencyEnum quote) throws ParseException, RestException {
        Response resp = currencyApiClient.get(currencyApiBaseUrl + "search?from=" + base + "&to=" + quote);
        return resp.getData(CurrencyConversionDTO.class);
    }
}