package com.numeros.romanos.controller;


import com.numeros.romanos.annotation.RequestDTO;
import com.numeros.romanos.domain.Numero;
import com.numeros.romanos.dto.mapper.NumeroMapper;
import com.numeros.romanos.dto.response.NumeroResponseDTO;
import com.numeros.romanos.repository.NumeroRepository;
import com.numeros.romanos.service.NumeroService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/numeros")
public class NumeroController {

    private NumeroService numeroService;
    private NumeroRepository numeroRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NumeroResponseDTO> todosNumeros() {
        return NumeroMapper.getInstance(this.numeroRepository.findAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NumeroResponseDTO buscarPorId(@PathVariable int id) {
        return NumeroMapper.getInstance(this.numeroService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NumeroResponseDTO create(@Valid @RequestDTO(NumeroResponseDTO.class) Numero numero) {
        return NumeroMapper.getInstance(this.numeroService.save(numero));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        this.numeroService.deleteById(id);
    }

}
