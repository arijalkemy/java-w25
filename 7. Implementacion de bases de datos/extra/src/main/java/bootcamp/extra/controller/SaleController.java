package bootcamp.extra.controller;

import bootcamp.extra.dto.ClothDTO;
import bootcamp.extra.dto.SaleDTO;
import bootcamp.extra.dto.request.SaleRequest;
import bootcamp.extra.service.ISaleService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final ISaleService ventaService;

    private final String DELETE_SALE_SUCCESS_MESSAGE = "Se eliminó la venta correctamente...";

    public SaleController(ISaleService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleRequest request) {
        return ResponseEntity.ok(ventaService.createSale(request));
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getSales() {
        return ResponseEntity.ok(ventaService.getSales());
    }

    @GetMapping("/{number}")
    public ResponseEntity<SaleDTO> getSaleByNumber(@PathVariable Long number) {
        return ResponseEntity.ok(ventaService.getSaleByNumber(number));
    }

    @PutMapping("/{number}")
    public ResponseEntity<SaleDTO> updateSale(
            @PathVariable Long number,
            @RequestBody SaleRequest request) {
        return ResponseEntity.ok(ventaService.updateSale(number, request));
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<String> updateSale(@PathVariable Long number) {
        ventaService.deleteSaleByNumber(number);
        return ResponseEntity.ok(DELETE_SALE_SUCCESS_MESSAGE);
    }

    @GetMapping(params = "date")
    public ResponseEntity<List<SaleDTO>> getVentasByDate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy")LocalDate date){
        return new ResponseEntity<>(ventaService.getVentasByDate(date), HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<ClothDTO>> getPrendasByVentaNumber(@PathVariable Long number){
        return new ResponseEntity<>(ventaService.getPrendasByVentasNumber(number), HttpStatus.OK);
    }
}
