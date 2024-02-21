package ejercicios.spring.edad_persona.Controllers;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import ejercicios.spring.edad_persona.Modelo.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/persons")
public class PersonaController {

    @GetMapping("/{day}/{month}/{year}")
    public String getAge(@PathVariable String day, @PathVariable String month, @PathVariable String year) {
        String date = day + "/" + month + "/" + year;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(date, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        return Integer.toString(periodo.getYears());
    }

    @GetMapping("/hola")
    ResponseEntity<Person> holaMundo() {
        return ResponseEntity.status(200).body(new Person("Juan Manuel", 12345678));
    }
}
