package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.api.services.ItemsApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ItemsService {
    private static final Logger log = LoggerFactory.getLogger(ItemsService.class);
    private ItemsApiService itemsApiService;

    @Autowired
    public ItemsService(ItemsApiService itemsApiService) {
        this.itemsApiService = itemsApiService;
    }

    public Double getItemPrice(String itemId) throws ParseException, RestException {
        ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
        if (log.isDebugEnabled()) {
            log.debug("Item info lookup: {}", itemInfo);
        }
        return itemInfo.getPrice();
    }

    public ItemDTO getItemPriceConverted(String itemId, String currencyTo) throws ParseException, RestException {

        ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
        CurrencyConversionDTO currencyConversionDTO = itemsApiService.getCurrencyConversion(itemInfo.getCurrencyId().toString(), currencyTo);
        itemInfo.setCurrencyId(CurrencyEnum.valueOf(currencyTo));

        BigDecimal price = BigDecimal.valueOf(itemInfo.getPrice())
                .divide(BigDecimal.valueOf(currencyConversionDTO.getInvRate()), 2, RoundingMode.HALF_UP);

        itemInfo.setCurrencyId(CurrencyEnum.valueOf(currencyTo));
        itemInfo.setPrice(price.doubleValue());

        return itemInfo;
    }
}
