package com.implementacionbd.ejercicio.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.implementacionbd.ejercicio.dto.req.ProductReqDTO;
import com.implementacionbd.ejercicio.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService employeeService;

    public ProductController(ProductService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllEmployees() {
        return new ResponseEntity<>(employeeService.findAllProducts(), HttpStatusCode.valueOf(201));
    }

    @PostMapping("/")
    public ResponseEntity<?> saveProduct(@RequestBody ProductReqDTO productReqDTO) {
        return new ResponseEntity<>(employeeService.saveProduct(productReqDTO), HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        return new ResponseEntity<>(employeeService.deleteProduct(id), HttpStatusCode.valueOf(204));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody ProductReqDTO productReqDTO) {
        return new ResponseEntity<>(employeeService.updateProduct(id, productReqDTO), HttpStatusCode.valueOf(200));
    }
}
