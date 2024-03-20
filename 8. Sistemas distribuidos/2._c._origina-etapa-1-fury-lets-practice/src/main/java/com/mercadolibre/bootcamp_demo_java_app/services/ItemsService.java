package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.api.services.DollarsApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ConversionRatioDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemPriceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.api.services.ItemsApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class ItemsService {
	private static final Logger log = LoggerFactory.getLogger(ItemsService.class);
	private ItemsApiService itemsApiService;

	private DollarsApiService dollarsApiService;
	
	@Autowired
	public ItemsService(ItemsApiService itemsApiService, DollarsApiService dollarsApiService) {

		this.itemsApiService = itemsApiService;
		this.dollarsApiService = dollarsApiService;

	}
	
	public ItemPriceDTO getItemPrice(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
		}
		ItemPriceDTO ansDTO = new ItemPriceDTO(itemInfo.getTitle(), itemInfo.getPrice(), itemInfo.getCurrencyId());
		return ansDTO;
	}

	public ItemPriceDTO getItemPriceInDollars(String itemId) throws ParseException, RestException {
		ItemDTO itemInfoDTO = itemsApiService.getItemInfo(itemId);
		ConversionRatioDTO dollarConversionRatioDTO = dollarsApiService.getConversionRatio(
				itemInfoDTO.getCurrencyId().toString(),
				CurrencyEnum.USD.toString()
				);
		Double priceInDollars = itemInfoDTO.getPrice() * dollarConversionRatioDTO.getRatio();
		ItemPriceDTO ansDTO = new ItemPriceDTO(itemInfoDTO.getTitle(), priceInDollars, CurrencyEnum.USD);
		return ansDTO;
	}
}
