package com.example.showroom.service;


import com.example.showroom.dto.request.ItemReqDto;
import com.example.showroom.dto.request.SaleReqDto;
import com.example.showroom.dto.response.ClotheDto;
import com.example.showroom.dto.response.ConfirmationMessage;
import com.example.showroom.dto.response.SaleDto;
import com.example.showroom.model.Clothe;
import com.example.showroom.model.Item;
import com.example.showroom.model.Sale;
import com.example.showroom.repository.ClotheRepository;
import com.example.showroom.repository.ItemRepository;
import com.example.showroom.repository.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements ISalesService{

    private final SaleRepository saleRepository;
    private final ItemRepository itemRepository;
    private final ClotheRepository clotheRepository;
    private final ModelMapper mapper;

    public SalesServiceImpl(SaleRepository saleRepository, ItemRepository itemRepository, ClotheRepository clotheRepository, ModelMapper mapper) {
        this.saleRepository = saleRepository;
        this.itemRepository = itemRepository;
        this.clotheRepository = clotheRepository;
        this.mapper = mapper;
    }

    @Override
    public ConfirmationMessage saveNewSale(SaleReqDto saleReqDto) {
        List<Item> items = new ArrayList<>();
        Double total = 0.0;

        for(ItemReqDto itemReqDto: saleReqDto.getClothes()){
            Optional<Clothe> clothe = this.clotheRepository.findById(itemReqDto.getClotheId());
            if(clothe.isEmpty())
                throw new RuntimeException("Clothe not found");
            total += clothe.get().getPrecio() * itemReqDto.getQuantity();
            Item newItem = new Item();
            newItem.setClothe(clothe.get());
            newItem.setQuantity(itemReqDto.getQuantity());
            items.add(newItem);
        }

        Sale sale = new Sale();
        sale.setDate(LocalDate.now());
        sale.setTotal(total);
        sale.setPaymentMethod(saleReqDto.getPaymentMethod());

        Sale newSale = this.saleRepository.save(sale);
        for(Item item: items){
            item.setSale(newSale);
        }

        this.itemRepository.saveAll(items);

        return new ConfirmationMessage("Sale created");
    }
    @Override
    public List<SaleDto> getAllSales() {
        List<Sale> listSale = saleRepository.findAll();
        return listSale.stream().map(c->mapper.map(c, SaleDto.class)).toList();
    }

    @Override
    public SaleDto getSaleById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        if(sale.isPresent()){
            return mapper.map(sale.get(), SaleDto.class);
        }else{
            throw new RuntimeException("Sale not found");
        }

    }

    @Override
    public ConfirmationMessage updateSale(SaleReqDto saleReqDto, Long id) {
        Sale existingSale = this.saleRepository.findById(id).orElseThrow();
        Sale newSale = mapper.map(saleReqDto, Sale.class);
        newSale.setId(existingSale.getId());
        return new ConfirmationMessage("La prenda con codigo: " + this.saleRepository.save(newSale).getId() + " fue actualizada exitosamente.");

    }

    @Override
    public ConfirmationMessage deleteSaleById(Long id){
        saleRepository.deleteById(id);
        return new ConfirmationMessage("Venta eliminada exitosamente...");
    }

    @Override
    public List<SaleDto> getSaleByDate(LocalDate date) {
        return this.saleRepository.findSalesByDate(date).stream()
                .map(sale -> mapper.map(sale, SaleDto.class))
                .toList();
    }

    @Override
    public List<ClotheDto> getListClothesById(Long id) {
        Sale foundSale = saleRepository.findById(id).orElseThrow();
        return foundSale.getItems().stream()
                .map(item -> mapper.map(item.getClothe(),ClotheDto.class))
                .toList();
    }
}
