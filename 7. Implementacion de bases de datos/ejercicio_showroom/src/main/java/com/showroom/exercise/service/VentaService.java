package com.showroom.exercise.service;

import com.showroom.exercise.dto.PrendaDTO;
import com.showroom.exercise.dto.ResponseDTO;
import com.showroom.exercise.dto.VentaDTO;
import com.showroom.exercise.exceptions.NotFoundException;
import com.showroom.exercise.model.Prenda;
import com.showroom.exercise.model.Venta;
import com.showroom.exercise.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaService implements IVentaService {
    private final IVentaRepository ventaRepository;
    private final ModelMapper mapper;

    public VentaService(IVentaRepository ventaRepository, ModelMapper mapper) {
        this.ventaRepository = ventaRepository;
        this.mapper = mapper;
    }

    @Override
    public VentaDTO saveVenta(VentaDTO ventaDTO) {
        Venta venta=mapper.map(ventaDTO, Venta.class);

        // A cada prenda, le seteamos su venta
        venta.getPrendas().forEach(prenda -> prenda.setVenta(venta));

        Venta newVenta=ventaRepository.save(venta);

        return mapper.map(newVenta, VentaDTO.class);
    }

    @Override
    public List<VentaDTO> getAllVentas() {
        return ventaRepository.findAll().stream().map(venta -> mapper.map(venta, VentaDTO.class)).toList();
    }

    @Override
    public VentaDTO getVentaByNumber(Long number) {
        Venta venta=ventaRepository.findById(number).orElseThrow(()-> new NotFoundException("Venta no encontrada"));

        return mapper.map(venta, VentaDTO.class);
    }

    // TODO: REVIEW, INSERTA UN NUEVO PRODUCTO PERO NO LO ACTUALIZA
    @Override
    public VentaDTO updateVenta(Long number, VentaDTO ventaDTO) {
        Venta venta=ventaRepository.findById(number).orElseThrow(()-> new NotFoundException("Venta no encontrada"));

        if(ventaDTO.getFecha()!=null) venta.setFecha(ventaDTO.getFecha());
        if(ventaDTO.getTotal()!=null) venta.setTotal(ventaDTO.getTotal());
        if(ventaDTO.getMedioPago()!=null) venta.setMedioPago(ventaDTO.getMedioPago());
        if(ventaDTO.getPrendas()!=null) venta.setPrendas(ventaDTO.getPrendas()
                .stream().map(prendaDTO->mapper.map(prendaDTO, Prenda.class))
                .collect(Collectors.toSet()));

        Venta savedVenta = ventaRepository.save(venta);

        return mapper.map(savedVenta, VentaDTO.class);
    }

    @Override
    public ResponseDTO deleteVenta(Long number) {
        ventaRepository.findById(number).orElseThrow(()-> new NotFoundException("Venta no encontrada"));
        ventaRepository.deleteById(number);
        return new ResponseDTO("Venta eliminada correctamente");
    }

    @Override
    public List<VentaDTO> getVentasByDate(String date) {
        LocalDate searchDate=LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("---------searchdaTE-----" +searchDate);
        List<Venta> ventaList=ventaRepository.findAll();

        return ventaList.stream()
                .filter(venta -> venta.getFecha().equals(searchDate))
                .map(venta -> mapper.map(venta, VentaDTO.class))
                .toList();
    }

    @Override
    public List<PrendaDTO> getPrendasFromVentaById(Long number) {
        return ventaRepository.findPrendasFromVentaId(number).stream().map(prenda -> mapper.map(prenda, PrendaDTO.class)).toList();
    }

}
