package com.prendas.service;

import com.prendas.dto.PrendaDto;
import com.prendas.dto.ResponseDto;
import com.prendas.dto.VentaDto;
import com.prendas.entity.Prenda;
import com.prendas.entity.Venta;
import com.prendas.exceptions.BadRequestException;
import com.prendas.exceptions.NotFoundException;
import com.prendas.repository.IVentaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements IVentaService {

    private final IVentaRepository ventaRepository;

    private final ModelMapper mapper;

    public VentaServiceImpl(IVentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
        this.mapper = new ModelMapper();
    }


    /**
     * Guarda una venta en la base de datos.
     *
     * @param ventaDto objeto venta que se desea guardar
     * @return ResponseDto que indica el resultado de la operación de guardado.
     */
    @Override
    public ResponseDto save(VentaDto ventaDto) {
        Venta venta = mapper.map(ventaDto, Venta.class);
        venta.setPrendaList(ventaDto.getPrendaList().stream()
                .map(
                        prenda -> mapper.map(prenda, Prenda.class)
                ).collect(Collectors.toSet()));
        Venta result = ventaRepository.save(venta);
        if (result == null) throw new BadRequestException("Algo salio mal");
        return new ResponseDto("Venta guardada con exito", HttpStatus.CREATED.value());
    }

    @Override
    public List<VentaDto> listVentas() {
        return ventaRepository.findAll().stream().map(venta -> mapper.map(venta, VentaDto.class)).toList();
    }

    @Override
    public VentaDto findByNumber(Long number) {
        Venta venta = ventaRepository.findById(number).orElseThrow(() -> new NotFoundException("Venta no encontrada"));
        return mapper.map(venta, VentaDto.class);
    }

    @Override
    public ResponseDto update(Long number, VentaDto ventaDto) {
        Venta venta = ventaRepository.findById(number).orElseThrow(() -> new NotFoundException("Venta no encontrada"));
        if (ventaDto.getFecha() != null) venta.setFecha(ventaDto.getFecha());
        if (ventaDto.getTotal() != null) venta.setTotal(ventaDto.getTotal());
        if (ventaDto.getMedioPago() != null) venta.setMedioPago(ventaDto.getMedioPago());
        if (ventaDto.getPrendaList() != null) venta.setPrendaList(ventaDto.getPrendaList().stream()
                .map(
                        prenda -> mapper.map(prenda, Prenda.class)
                ).collect(Collectors.toSet()));
        ventaRepository.save(venta);
        return new ResponseDto("Venta actualizada con exito", HttpStatus.OK.value());
    }

    /**
     * Elimina una venta utilizando su número de identificación
     *
     * @param number El número de identificación único de la venta que se desea eliminar.
     * @return ResponseDto indicando el resultado de la operación de eliminación.
     * @throws NotFoundException Si no se encuentra una venta con el número proporcionado.
     */
    @Override
    public ResponseDto remove(Long number) {
        // Busca la venta en el ventaRepository por su número de identificación
        Venta venta = ventaRepository.findById(number).orElseThrow(() -> new NotFoundException("Venta no encontrada"));

        // Elimina la venta de la base de datos
        this.ventaRepository.delete(venta);

        // Devuelve una respuesta indicando que la venta se eliminó con éxito
        return new ResponseDto("Venta eliminada con éxito", HttpStatus.OK.value());
    }


    /**
     * Obtiene una lista de ventas realizadas en una fecha específica.
     *
     * @param date La fecha para la cual se desean obtener las ventas.
     * @return Una lista de objetos VentaDto que representan las ventas realizadas en la fecha especificada.
     */
    @Override
    public List<VentaDto> listByDate(LocalDate date) {
        // Utiliza el método findByFecha del ventaRepository para obtener las ventas realizadas en la fecha especificada
        return this.ventaRepository.findByFecha(date)
                .stream()
                .map(v -> {
                    // Mapea cada objeto Venta a un objeto VentaDto
                    VentaDto ventaDto = mapper.map(v, VentaDto.class);
                    // Establece la lista de prendas en el objeto VentaDto
                    ventaDto.setPrendaList(v.getPrendaList());
                    return ventaDto;
                })
                .toList();
    }


    @Override
    public List<PrendaDto> listVentaPrendas(Long number) {
        Venta venta = ventaRepository.findById(number).orElseThrow(() -> new NotFoundException("Venta no encontrada"));
        return venta.getPrendaList().stream().map(prenda -> mapper.map(prenda, PrendaDto.class)).toList();
    }
}
