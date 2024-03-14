package bootcamp.relations.controller;

import bootcamp.relations.dto.request.SaleRequestDTO;
import bootcamp.relations.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private ISaleService saleService;

    @PostMapping
    private ResponseEntity<String> createSale(@RequestBody SaleRequestDTO request) {
        saleService.createSale(request);
        return ResponseEntity.ok("Se guardó la venta exitosamente...");
    }


}
