package org.example.edadpersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.GregorianCalendar;

@RestController
public class controller {
    @GetMapping ("/{dia}/{mes}/{ano}")
    public int edad(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        Calendar ahora = Calendar.getInstance();
        if (ahora.getTime().getMonth() + 1 <= mes && ahora.getTime().getDate() >= dia){
            return ahora.getTime().getYear() - ano + 1900;
        }
        return ahora.getTime().getYear() - ano - 1 + 1900;
    }
}
