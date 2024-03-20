package com.bootcamp.ejercicio_showroom.service;

import com.bootcamp.ejercicio_showroom.dto.request.VentaReqDto;
import com.bootcamp.ejercicio_showroom.dto.response.PrendaRespDto;
import com.bootcamp.ejercicio_showroom.dto.response.ResponseDTO;
import com.bootcamp.ejercicio_showroom.dto.response.VentaRespDto;
import com.bootcamp.ejercicio_showroom.model.Prenda;
import com.bootcamp.ejercicio_showroom.model.Venta;
import com.bootcamp.ejercicio_showroom.repository.IClothesRepository;
import com.bootcamp.ejercicio_showroom.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements ISalesService{

    private ISaleRepository saleRepository;
    private IClothesRepository clothesRepository;
    private ModelMapper mapper;
    public SaleServiceImpl(ISaleRepository saleRepository, IClothesRepository clothesRepository) {
        this.saleRepository = saleRepository;
        this.clothesRepository = clothesRepository;
        mapper = new ModelMapper();
    }

    @Override
    public VentaRespDto getSaleByNumber(Long number) {
        Optional<Venta> ventaBuscada = this.saleRepository.findByNumero(number);
        if(ventaBuscada.isEmpty()) {
            throw  new RuntimeException("La venta con el número " + number + " no existe");
        }
        return mapper.map(ventaBuscada.get(), VentaRespDto.class);
    }

    @Override
    public List<VentaRespDto> getAllSales() {
        return this.saleRepository.findAll().stream().map(sale -> mapper.map(sale, VentaRespDto.class)).toList();
    }

    @Override
    public VentaRespDto addVenta(VentaReqDto ventaReqDto) {
        List<Prenda> prendas = clothesRepository.findAllById(ventaReqDto.getPrendas());
        Venta venta = new Venta(
                ventaReqDto.getFecha(),
                ventaReqDto.getTotal(),
                ventaReqDto.getMedio_de_pago(),
                prendas
        );
        return mapper.map(saleRepository.save(venta), VentaRespDto.class);
    }

    @Override
    public VentaRespDto updateVenta(Long id, VentaReqDto ventaReqDto) {
        Optional<Venta> optVenta = saleRepository.findByNumero(id);
        List<Prenda> prendas = clothesRepository.findAllById(ventaReqDto.getPrendas());

        if (optVenta.isEmpty()) {
            throw new RuntimeException("La venta con id " + id + " no se puede actualizar porque no existe");
        }

        optVenta = Optional.of(mapper.map(ventaReqDto, Venta.class));
        optVenta.get().setNumero(id);
        optVenta.get().setPrendas(prendas);

        return mapper.map(saleRepository.save(optVenta.get()), VentaRespDto.class);
    }

    @Override
    public List<PrendaRespDto> getClothesBySaleNumber(Long number) {
        Optional<Venta> optVenta = saleRepository.findByNumero(number);
        if (optVenta.isEmpty()) {
            throw new RuntimeException("La venta con id " + number + " no existe");
        }

        return optVenta.get().getPrendas().stream()
                .map(prenda -> mapper.map(prenda, PrendaRespDto.class)).toList();
    }

    @Override
    public List<VentaRespDto> getSalesOnDate(String date) {

        //Soy malo con LocalDate, quiza no funciona esto!!!

        LocalDate dateObj = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (LocalDate.now().isBefore(dateObj)){
            throw new RuntimeException("La fecha de consulta no puede ser después de la de hoy");
        }
        List<Venta> ventasDelDia = this.saleRepository.getVentaByFecha(dateObj);
        return ventasDelDia.stream()
                .map(v -> mapper.map(v, VentaRespDto.class)).toList();
    }

    @Override
    public ResponseDTO deleteSaleById(Long id){
        Optional<Venta> deleteVenta = saleRepository.findByNumero(id);
        if(deleteVenta.isEmpty()) {
            throw  new RuntimeException("La venta con el número " + id + " no existe");
        }
        Venta sale = deleteVenta.get();
        saleRepository.delete(sale);
        return new ResponseDTO("Venta eliminada con exito");
    }


}
