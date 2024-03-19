package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDTO;
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
public class ItemsApiService extends RestClientService {
    @Value("${meli.base.url}")
    private String baseUrl;

    private String itemsApiBaseUrl;
    private RestClient itemsApiClient;

    private String currencyConversionsApiBaseUrl;
    private RestClient currencyConversionsApiClient;

    public ItemsApiService() throws IOException {
        super();
    }

    @PostConstruct
    public void init() throws IOException {
        itemsApiBaseUrl = String.format("%s/items/", baseUrl);
        itemsApiClient = RestClient.builder()
                .withPool(restPool)
                .build();

        currencyConversionsApiBaseUrl = String.format("%s/currency_conversions/", baseUrl);
        currencyConversionsApiClient = RestClient.builder()
                .withPool(restPool)
                .build();
    }

    public ItemDTO getItemInfo(String itemId) throws ParseException, RestException {
        String currentItemUrl = itemsApiBaseUrl + itemId;
        Response resp = itemsApiClient.get(currentItemUrl);
        return resp.getData(ItemDTO.class);
    }

    public CurrencyConversionDTO getCurrencyConversion(String currencyFrom, String currencyTo) throws ParseException, RestException {
        String url = currencyConversionsApiBaseUrl + "search?from=" + currencyFrom + "&to=" + currencyTo;
        Response resp = currencyConversionsApiClient.get(url);
        return resp.getData(CurrencyConversionDTO.class);
    }
}
