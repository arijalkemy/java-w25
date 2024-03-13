package com.example.elasticDemo.services;

import com.example.elasticDemo.dto.ClothesDTO;
import com.example.elasticDemo.dto.ResponseDTO;
import com.example.elasticDemo.dto.SaleDTO;
import com.example.elasticDemo.model.Clothes;
import com.example.elasticDemo.model.Sale;
import com.example.elasticDemo.repositories.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements ISaleService{
    private ISaleRepository repository;
    private ModelMapper mapper = new ModelMapper();

    public SaleServiceImpl(ISaleRepository repository){
        this.repository = repository;
    }
    @Override
    public SaleDTO create(SaleDTO saleDTO) {
        Sale sale = mapper.map(saleDTO, Sale.class);
        sale = repository.save(sale);
        return mapper.map(sale, SaleDTO.class);
    }

    @Override
    public SaleDTO update(SaleDTO saleDTO) {
        Optional<Sale> sale = repository.findById(saleDTO.getId());
        if(sale.isEmpty()) throw new RuntimeException("No se encontró el id solicitado");
        Sale s = sale.get();
        s.setFecha(saleDTO.getFecha());
        s.setTotal(saleDTO.getTotal());
        s.setPrendas(saleDTO.getPrendas());
        s.setMedio_pago(saleDTO.getMedio_pago());
        s = repository.save(s);
        return mapper.map(s, SaleDTO.class);
    }

    @Override
    public ResponseDTO delete(String id) {
        repository.deleteById(id);
        return new ResponseDTO("Se elimino correctamente el ID: " + id);
    }

    @Override
    public List<SaleDTO> findAll() {
        List<Sale> sales = (List<Sale>) repository.findAll();
        return sales.stream().map(s -> mapper.map(s, SaleDTO.class)).toList();
    }

    @Override
    public SaleDTO findById(String id) {
        Optional<Sale> sale = repository.findById(id);
        if(sale.isEmpty()) throw new RuntimeException("");
        return mapper.map(sale.get(), SaleDTO.class);
    }

    @Override
    public List<SaleDTO> findAllByFecha(LocalDate fecha) {
        List<Sale> sales = repository.findAllByFecha(fecha);
        return sales.stream().map(s -> mapper.map(s, SaleDTO.class)).toList();
    }

    @Override
    public SaleDTO findClothesBySale(String id) {
        Optional<Sale> sale = repository.findById(id);
        if(sale.isEmpty()) throw new RuntimeException("");
        return mapper.map(sale.get(), SaleDTO.class);
    }
}
