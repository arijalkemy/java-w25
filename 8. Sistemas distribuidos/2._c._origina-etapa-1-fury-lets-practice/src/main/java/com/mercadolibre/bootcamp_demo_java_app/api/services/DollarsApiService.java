package com.mercadolibre.bootcamp_demo_java_app.api.services;

import java.io.IOException;

import javax.annotation.PostConstruct;

import com.mercadolibre.bootcamp_demo_java_app.dtos.ConversionRatioDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class DollarsApiService extends RestClientService{
    @Value("${meli.base.url}")
    private String baseUrl;

    @Value("")
    private String dollarsApiBaseUrl;

    private RestClient dollarsApiClient;

    public DollarsApiService() throws IOException{
        super();
    }

    @PostConstruct
    public void init() throws IOException {
        dollarsApiBaseUrl = String.format(
                "%s/currency_conversions/",
                baseUrl
        );
        dollarsApiClient = RestClient.builder()
                .withPool(restPool)
                .build();
    }

    public ConversionRatioDTO getConversionRatio(String currencyIdFrom, String currencyIdTo) throws ParseException, RestException{
        String urlQuery = String.format("search?from=%s&to=%s", currencyIdFrom , currencyIdTo);
        String requestUrl = dollarsApiBaseUrl + urlQuery;
        Response resp = dollarsApiClient.get(requestUrl);
        return resp.getData(ConversionRatioDTO.class);
    }

}