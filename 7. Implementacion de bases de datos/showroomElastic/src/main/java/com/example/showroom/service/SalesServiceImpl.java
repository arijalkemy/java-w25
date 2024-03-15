package com.example.showroom.service;


import com.example.showroom.dto.request.ItemReqDto;
import com.example.showroom.dto.request.SaleReqDto;
import com.example.showroom.dto.response.ClotheDto;
import com.example.showroom.dto.response.ConfirmationMessage;
import com.example.showroom.dto.response.ErrorMessage;
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
import java.time.format.DateTimeFormatter;
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
        String formattedDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE);

        sale.setDate(formattedDate);
        sale.setTotal(total);
        sale.setPaymentMethod(saleReqDto.getPaymentMethod());

        Sale newSale = this.saleRepository.save(sale);
        for(Item item: items){
            item.setSaleId(newSale.getId());
        }

        this.itemRepository.saveAll(items);

        return new ConfirmationMessage("Sale created");
    }

    @Override
    public List<SaleDto> getAllSales() {
        List<Sale> listSale = this.saleRepository.findAll();
        return listSale.stream().map(c->mapper.map(c, SaleDto.class)).toList();
    }

    @Override
    public SaleDto getSaleById(String id) {
        Optional<Sale> sale = this.saleRepository.findById(id);
        if(sale.isPresent()){
            return mapper.map(sale.get(), SaleDto.class);
        }else{
            throw new RuntimeException("Sale not found");
        }

    }

    @Override
    public ConfirmationMessage updateSale(SaleReqDto saleReqDto, String id) {
        Sale existingSale = this.saleRepository.findById(id).orElseThrow();
        Sale newSale = mapper.map(saleReqDto, Sale.class);
        newSale.setId(existingSale.getId());
        String formattedDate = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        newSale.setDate(formattedDate);

        List<Item> updatedItems = new ArrayList<>();
        Double total = 0.0;

        for(ItemReqDto itemReqDto: saleReqDto.getClothes()){
            Optional<Clothe> clothe = this.clotheRepository.findById(itemReqDto.getClotheId());
            if(clothe.isEmpty())
                throw new RuntimeException("Clothe not found");
            total += clothe.get().getPrecio() * itemReqDto.getQuantity();
            Item newItem = new Item();
            newItem.setClothe(clothe.get());
            newItem.setSaleId(newSale.getId());
            newItem.setQuantity(itemReqDto.getQuantity());
            updatedItems.add(newItem);
        }

        newSale.setTotal(total);
        List<Item> itemsToDelete = this.itemRepository.findItemsBySaleId(existingSale.getId());
        this.itemRepository.deleteAll(itemsToDelete);
        this.itemRepository.saveAll(updatedItems);

        return new ConfirmationMessage("La prenda con codigo: " + this.saleRepository.save(newSale).getId() + " fue actualizada exitosamente.");
    }

    @Override
    public ConfirmationMessage deleteSaleById(String id){
        List<Item> itemsToDelete = this.itemRepository.findItemsBySaleId(id);
        this.itemRepository.deleteAll(itemsToDelete);
        this.saleRepository.deleteById(id);
        return new ConfirmationMessage("Venta eliminada exitosamente...");
    }

    @Override
    public List<SaleDto> getSaleByDate(LocalDate date) {
        return this.saleRepository.findSalesByDate(date).stream()
                .map(sale -> mapper.map(sale, SaleDto.class))
                .toList();
    }

    @Override
    public List<ClotheDto> getListClothesById(String id) {
        List<Item> items = this.itemRepository.findItemsBySaleId(id);
        return items.stream().map(item -> mapper.map(item.getClothe(), ClotheDto.class)).toList();
    }
}
