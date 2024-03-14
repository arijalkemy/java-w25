package com.bootcamp.ejercicio_relaciones.controller;

import com.bootcamp.ejercicio_relaciones.dto.AdressDTO;
import com.bootcamp.ejercicio_relaciones.dto.ResponseDTO;
import com.bootcamp.ejercicio_relaciones.dto.UserDTO;
import com.bootcamp.ejercicio_relaciones.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@RequestBody UserDTO user) {
        return ResponseEntity.ok(userService.save(user));
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable String dni) {
        return ResponseEntity.ok(userService.delete(dni));
    }
}
