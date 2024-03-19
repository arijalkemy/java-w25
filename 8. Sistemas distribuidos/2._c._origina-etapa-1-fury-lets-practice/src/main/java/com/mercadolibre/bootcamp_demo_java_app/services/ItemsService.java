package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.api.services.CurrencyConversionApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.*;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.api.services.ItemsApiService;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class ItemsService {
	private static final Logger log = LoggerFactory.getLogger(ItemsService.class);
	private ItemsApiService itemsApiService;
	private CurrencyConversionApiService currencyConversionApiService;
	
	@Autowired
	public ItemsService(ItemsApiService itemsApiService, CurrencyConversionApiService currencyConversionApiService) {
		this.itemsApiService = itemsApiService;
        this.currencyConversionApiService = currencyConversionApiService;
    }
	
	public ItemPriceDTO getItemPrice(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
		}
		return new ItemPriceDTO(itemInfo.getItemId(), itemInfo.getPrice());
	}

	public ItemPriceUsdDTO getItemPriceInUsd(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		CurrencyEnum quote = CurrencyEnum.USD;
		CurrencyEnum base = itemInfo.getCurrencyId();
		CurrencyConversionDTO currencyConversionInfo = currencyConversionApiService.getCurrencyConversionInfo(base, quote);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
			log.debug("Item info lookup: {}",currencyConversionInfo);
		}
		return new ItemPriceUsdDTO(
				itemInfo.getItemId(),
				calculateValueWithRate(itemInfo.getPrice(), currencyConversionInfo.getRate())
		);
	}

	private Double calculateValueWithRate(@NonNull Double value, @NonNull Double rate){
		return value * rate;
	}
}
