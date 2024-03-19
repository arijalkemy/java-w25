package com.example.APInumeroromanos.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanos {

    @GetMapping ("/romano/{num}")
    public String enviarNumero(@PathVariable String num){
        ConvertirNumero conN = new ConvertirNumero();
        return conN.decimalesARomanos(num);
    }

}
