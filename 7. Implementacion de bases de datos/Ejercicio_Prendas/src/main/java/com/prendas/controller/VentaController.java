package com.prendas.controller;

import com.prendas.dto.VentaDto;
import com.prendas.service.IVentaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/api/sale")
public class VentaController {
    private final IVentaService ventaService;

    /**
     * Crear una nueva venta.
     * @param ventaDto DTO de venta
     * @return DTO de venta + Status Created (201)
     */
    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody VentaDto ventaDto){
        return new ResponseEntity<>(ventaService.save(ventaDto), HttpStatus.CREATED);
    }

    /**
     * Devuelve un listado de todas las ventas cargadas
     * @return List de DTO de venta
     */
    @GetMapping
    public ResponseEntity<?> getAllSales(){
        return ResponseEntity.ok().body(ventaService.listVentas());
    }

    /**
     * Devuelve un venta específica
     * @param saleNumber numero identificador de una venta
     * @return DTO de venta buscada
     */
    @GetMapping("/{number}")
    public ResponseEntity<?> getOneSale(@PathVariable("number") Long saleNumber){
        return ResponseEntity.ok().body(ventaService.findByNumber(saleNumber));
    }

    /**
     * Actualizar una venta en particular
     * @param saleNumber numero identificador de una venta
     * @param newSale DTO de venta con informacion actualizada
     * @return DTO de venta actualizado
     */
    @PutMapping("/{number}")
    public ResponseEntity<?> updateOneSale(@PathVariable("number") Long saleNumber, @RequestBody VentaDto newSale){
        return ResponseEntity.ok().body(ventaService.update(saleNumber, newSale));
    }

    /**
     * Eliminar una venta en particular
     * @param saleNumber numero identificador de una venta
     * @return DTO de venta eliminado
     */
    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteOneSale(@PathVariable("number") Long saleNumber){
        return ResponseEntity.ok().body(ventaService.remove(saleNumber));
    }

    /**
     * Traer todas las prendas de una determinada fecha
     * @param date fecha a buscar
     * @return Listado de DTO de Venta filtrado por fecha
     */
    @GetMapping("/date")
    public ResponseEntity<?> getSalesByDate(@RequestParam("date") LocalDate date){
        return ResponseEntity.ok().body(ventaService.listByDate(date));
    }

    /**
     * Traer la lista completa de prendas de una determinada venta.
     * @param saleNumber numero identificador de una venta
     * @return Listado de DTO de Prenda de una venta en especifico
     */
    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getPrendasBySaleNumber(@PathVariable("number") Long saleNumber){
        return ResponseEntity.ok().body(ventaService.listVentaPrendas(saleNumber));
    }
}
