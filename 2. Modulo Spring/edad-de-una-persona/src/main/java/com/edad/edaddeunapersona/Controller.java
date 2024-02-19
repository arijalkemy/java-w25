import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@RestController
public class Controller {
    @GetMapping("/{dia}/{mes}/{anio}")
    public long calcular(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) throws Exception {

        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = LocalDate.of(anio, mes, dia);
        if (nacimiento.isAfter(hoy))
            throw new Exception("Debes ingresar una fecha anterior");

        return ChronoUnit.YEARS.between(nacimiento, hoy);
    } }

//Tambien se podria hacer con Period calcular el periodo entre los años