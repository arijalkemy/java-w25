package com.numeros.romanos.service;


import com.numeros.romanos.domain.Numero;
import com.numeros.romanos.repository.NumeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NumeroService {
    private NumeroRepository numeroRepository;

    public Numero findById(Integer id) {
        return this.numeroRepository.findById(id).orElseThrow();
    }

    public Numero save(Numero numero) {
        if(this.numeroRepository.findById(numero.getId()).isPresent())
            return numero;
        else
            return this.numeroRepository.save(numero);
    }

    public void deleteById(Integer id) {
        this.numeroRepository.delete(this.findById(id));
    }
}
