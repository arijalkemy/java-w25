package com.meli.showroom.service;

import com.meli.showroom.dto.PrendaDTO;
import com.meli.showroom.dto.ResponseDTO;
import com.meli.showroom.dto.VentaDTO;
import com.meli.showroom.entity.Prenda;
import com.meli.showroom.entity.Venta;
import com.meli.showroom.exception.NotFoundException;
import com.meli.showroom.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements IVentaService{
    private final IVentaRepository ventaRepository;
    private final ModelMapper modelMapper;

    public VentaServiceImpl(IVentaRepository ventaRepository, ModelMapper modelMapper){
        this.ventaRepository= ventaRepository;
        this.modelMapper=modelMapper;
    }
    @Override
    public VentaDTO newVenta(VentaDTO ventaDTO){
        Venta venta = modelMapper.map(ventaDTO, Venta.class);
        venta.getListPrendas().forEach(prenda -> prenda.setVenta(venta));
        Venta newVenta = ventaRepository.save(venta);
        return modelMapper.map(newVenta, VentaDTO.class);
    }
    @Override
    public List<VentaDTO> saveAll(List<VentaDTO> ventas) {
        List<Venta> createdVentas = ventaRepository.saveAll(
                ventas.stream().map(ventaDTO -> {
                    Venta venta = modelMapper.map(ventaDTO, Venta.class);
                    venta.getListPrendas().forEach(p-> p.setVenta(venta));
                    return venta;
                }).toList()
        );
        return createdVentas.stream().map(
                venta -> modelMapper.map(venta, VentaDTO.class)
        ).toList();
    }
    @Override
    public List<VentaDTO> getAllVentas(){
        return ventaRepository.findAll().stream().map(v-> modelMapper.map(v, VentaDTO.class)).toList();
    }
    @Override
    public VentaDTO getVentaByNumber(Long number) {
        Optional<Venta> ventaFound = ventaRepository.findById(number);
        if(ventaFound.isEmpty()){
            return null;
        }
        return modelMapper.map(ventaFound.get(), VentaDTO.class);
    }
    @Override
    public VentaDTO updateVenta(VentaDTO ventaDTO, Long number){
        Venta venta = ventaRepository.findById(number).orElseThrow(() -> new NotFoundException("La venta no existe"));
        if(ventaDTO.getFecha()!=null) venta.setFecha(ventaDTO.getFecha());
        if(ventaDTO.getTotal()!=null) venta.setTotal(ventaDTO.getTotal());
        if(ventaDTO.getMedioPago()!=null) venta.setMedioPago(ventaDTO.getMedioPago());
        if(ventaDTO.getListPrendas()!=null) venta.setListPrendas(ventaDTO.getListPrendas().stream()
                .map(p -> modelMapper.map(p, Prenda.class)).collect(Collectors.toSet()));
        Venta savedVenta = ventaRepository.save(venta);
        return modelMapper.map(savedVenta, VentaDTO.class);

    }
    @Override
    public ResponseDTO deleteVentaByNumber(Long number){
        ventaRepository.deleteById(number);
        return new ResponseDTO("Venta fue eliminada correctamente.");
    }
    @Override
    public List<VentaDTO> getVentasByDate(String date){
        LocalDate searchedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        List<Venta> listVentas = ventaRepository.findAll();
        return listVentas.stream()
                .filter(venta -> venta.getFecha().equals(searchedDate))
                .map(venta -> modelMapper.map(venta, VentaDTO.class))
                .toList();
    }
    public List<PrendaDTO> getPrendasFromVenta(Long number){
        return ventaRepository.findPrendasFromVendaById(number).stream().map(prenda -> modelMapper.map(prenda, PrendaDTO.class)).toList();
    }
}
