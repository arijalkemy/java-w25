package com.meli.obtenerdiploma.learninghub.pruebasconmocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PruebaTestMockful {
    /*@Mock
    AlumnoRepository alumnoRepository;

    @InjectMocks
    AlumnoService alumnoService;

    ModelMapper mapper = new ModelMapper();

    @Test
    public void addAlumno() {

        //ARRANGE
        AlumnoDTO devolucion = new AlumnoDTO("45244599", "Nachuchi", LocalDate.now(), 21,
                List.of(
                        new MateriaDTO("1", "Matemática", 8),
                        new MateriaDTO("1", "Matemática", 8)
                ));

        Alumno paramMock = mapper.map(param, Alumno.class);

        //ACT
        Mockito.when(alumnoRepository.addAlumno(paramMock)).thenReturn(paramMock);
        AlumnoDTO obtained = alumnoService.createAlumno(devolucion);

        //ASSERT
        Assertions.assertEquals(devolucion, obtained);
    }

    @Test
    public void findByIdException() {

        //ARRANGE
        String dni = "45244599";

        Alumno paramMock = mapper.map(param, Alumno.class);

        //ACT & ASSERT
        Mockito.when(alumnoRepository.findById(dni)).thenReturn(Optional.empty());

        Assertions.assertThrows(IdNoEncontradoException.class,
                () -> alumnoService.findById(dni));
    }*/
}
