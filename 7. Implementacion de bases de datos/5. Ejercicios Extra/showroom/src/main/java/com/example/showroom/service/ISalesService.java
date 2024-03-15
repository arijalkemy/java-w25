package com.example.showroom.service;

import com.example.showroom.dto.request.ClotheReqDto;
import com.example.showroom.dto.request.SaleReqDto;
import com.example.showroom.dto.response.ClotheDto;
import com.example.showroom.dto.response.ConfirmationMessage;
import com.example.showroom.dto.response.SaleDto;

import java.time.LocalDate;
import java.util.List;

public interface ISalesService {
    ConfirmationMessage saveNewSale(SaleReqDto saleReqDto);

    List<SaleDto> getAllSales();

    SaleDto getSaleById(Long id);

    ConfirmationMessage updateSale(SaleReqDto saleReqDto, Long id);

    ConfirmationMessage deleteSaleById(Long id);

    List<SaleDto> getSaleByDate(LocalDate date);
    List<ClotheDto> getListClothesById(Long id);
}
