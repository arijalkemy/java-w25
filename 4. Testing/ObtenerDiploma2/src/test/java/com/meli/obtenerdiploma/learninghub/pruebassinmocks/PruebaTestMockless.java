package com.meli.obtenerdiploma.learninghub.pruebassinmocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

//se hace cuando la clase a testear NO tiene dependencias
//ej. repositories
@SpringBootTest
public class PruebaTestMockless {

    /*AlumnoRepository alumnoRepository = new AlumnoRepository();

    @Test
    public void addAlumnoCorrect() {

        //ARRANGE - PREPARAR DATOS A USAR (PARAMETROS, TIPO DE DATO DE DEVOLUCION)
        Alumno param = new Alumno(
                "45244599", "Nachuchi", LocalDate.now(), 25,
                List.of(
                        new MateriaDTO("1", "Matemática", 90)
                )
        );
        Alumno devolucion = param;


        //ACT - CORRER EL METODO
        var obtenido = alumnoRepository.addAlumno(param);

        //ASSERT - COMPROBAR FUNCIONAMIENTO DEL MÉTODO
        Assertions.assertEquals(devolucion, obtenido);
    }

    @Test
    public void addAlumnoException() {

        //ARRANGE - PREPARAR DATOS A USAR (PARAMETROS, TIPO DE DATO DE DEVOLUCION)
        Alumno param = new Alumno(
                "45344599", "Nachuchi", LocalDate.of(1998, 02, 05), 21,
                List.of(
                        new MateriaDTO("1", "Matemática", 90)
                )
        );
        Alumno devolucion = param;


        //ACT + ASSERT
        Assertions.assertThrows(AlumnoYaExisteException,
                () -> {
                    alumnoRepository.addAlumno(param);
                });
    }*/

}
