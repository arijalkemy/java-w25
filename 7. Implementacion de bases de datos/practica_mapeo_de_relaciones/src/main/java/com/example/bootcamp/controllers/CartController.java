package com.example.bootcamp.controllers;

import com.example.bootcamp.dto.CartDTO;
import com.example.bootcamp.services.CartServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
    @Autowired
    CartServicesImp cartService;

    @GetMapping("/api/carts")
    public ResponseEntity<?> getSingleCase(){
        return new ResponseEntity<>(cartService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/api/carts/new")
    public ResponseEntity<?> saveTest(@RequestBody CartDTO cartNuevo) {
        return new ResponseEntity<>(cartService.create(cartNuevo), HttpStatus.OK);
    }

    /*@GetMapping("/api/carts/{id}")
    public ResponseEntity<?> getSingleCase(@PathVariable long id){
        return new ResponseEntity<>(cartService.findCartById(id), HttpStatus.OK);
    }*/

    @DeleteMapping ("/api/carts/{id}")
    public ResponseEntity<?> deleteTest(@PathVariable Long id) {
        cartService.delete(id);
        return ResponseEntity.ok("Se elimino correctamente");
    }

    /*@PutMapping ("/api/carts/{id}")
    public ResponseEntity<?> updateTest (@PathVariable Long id, @RequestBody CartDTO test) {
        return new ResponseEntity<>(cartService.editCart(id, test), HttpStatus.OK);
    }*/
}