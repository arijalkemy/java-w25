package com.meli.obtenerdiploma;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;
    StudentDTO studentDTO;
    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @BeforeEach
    public void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(getThreeSubjects());
        //studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
        //studentDTO.setAverageScore(7.333333333333333);
    }

    @Test
    void getStudentOkTest() throws Exception {
        String expected = writer.writeValueAsString(studentDTO);
        MvcResult responseMvc = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        Assertions.assertEquals(expected,responseMvc.getResponse().getContentAsString());
    }

    @Test
    void getStudentNotFoundTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}","3"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 3 no se encuetra registrado."));
    }

    /*@Test
    void deleteStudentOkTest() throws Exception {
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",2L))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assertions.assertEquals("",response.getResponse().getContentAsString());
    }

    @Test
    void updateStudentOkTest() throws Exception {
        String expected = writer.writeValueAsString(studentDTO);
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals("",response.getResponse().getContentAsString());
    }

    @Test
    void registerStudentOkTest() throws Exception {

        String expected = writer.writeValueAsString(studentDTO);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals("",response.getResponse().getContentAsString());
    }*/

    @Test
    void listStudentsOkTest() throws Exception{

        Set<StudentDTO> ListStudentsDto = loadStudents();

        String expected = writer.writeValueAsString(ListStudentsDto);

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(expected,response.getResponse().getContentAsString());
    }

    @Test
    void registerStudentMethodArgumentNotValidExceptionTest() throws Exception {
        studentDTO.setStudentName(null);
        validateMethodArgument("El nombre del estudiante no puede estar vacío.");
    }

    @Test
    void registerStudentMethodArgumentNotValidPatternErrorTest() throws Exception {
        studentDTO.setStudentName("jose");
        validateMethodArgument("El nombre del estudiante debe comenzar con mayúscula.");

    }

    @Test
    void registerStudentMethodArgumentNotValidExceptionStudentNamelengthTest() throws Exception {
        studentDTO.setStudentName(studentDTO.getStudentName().repeat(1000));
        validateMethodArgument("La longitud del nombre del estudiante no puede superar los 50 caracteres.");
    }

    @Test
    void registerStudentMethodArgumentNotValidExceptionStudentEmptySubjectsTest() throws Exception {
        studentDTO.setSubjects(List.of());
        validateMethodArgument("La lista de materias no puede estar vacía.");
    }

    @Test
    void registerStudentMethodArgumentNotValidExceptionStudentEmptyNameSubjectsErrorTest() throws Exception {
        studentDTO.setSubjects(List.of(new SubjectDTO(null,5.0)));
        validateMethodArgument("El nombre de la materia no puede estar vacío.");
    }

    @Test
    void registerStudentMethodArgumentNotValidExceptionStudentBadNameSubjectsErrorTest() throws Exception {
        studentDTO.setSubjects(List.of(new SubjectDTO("aB",5.0)));
        validateMethodArgument("El nombre de la materia debe comenzar con mayúscula.");

    }

    @Test
    void registerStudentMethodArgumentNotValidExceptionStudentBadLengthNameSubjectsErrorTest() throws Exception {

        studentDTO.setSubjects(List.of(new SubjectDTO("A".repeat(51),5.0)));
        validateMethodArgument("La longitud del nombre de la materia no puede superar los 30 caracteres.");
    }

    @Test
    void registerStudentMethodArgumentNotValidExceptionStudentEmptyGradeErrorTest() throws Exception {
        studentDTO.setSubjects(List.of(new SubjectDTO("Ab",null)));
        validateMethodArgument("La nota de la materia no puede estar vacía.");
    }

    @Test
    void registerStudentMethodArgumentNotValidExceptionStudentMinNoteErrorTest() throws Exception {
        studentDTO.setSubjects(List.of(new SubjectDTO("Ab",-1.0)));
        validateMethodArgument("La nota mínima de la materia es de 0 pts.");
    }

    @Test
    void registerStudentMethodArgumentNotValidExceptionStudentMaxNoteErrorTest() throws Exception {
        studentDTO.setSubjects(List.of(new SubjectDTO("Ab",11.0)));
        validateMethodArgument("La nota máxima de la materia es de 10 pts.");
    }

    private List<SubjectDTO> getThreeSubjects() {
        return Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        );
    }

    private List<SubjectDTO> getThreeSubjects2() {
        return Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Fisica", 8.0),
                new SubjectDTO("Quimica", 4.0)
        );
    }

    private Set<StudentDTO> loadStudents() {
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setId(1L);
        studentDTO1.setStudentName("Juan");
        studentDTO1.setSubjects(getThreeSubjects());
        StudentDTO studentDTO2 = new StudentDTO();
        studentDTO2.setId(2L);
        studentDTO2.setStudentName("Pedro");
        studentDTO2.setSubjects(getThreeSubjects2());

        Set<StudentDTO> studentDTOList = new HashSet<>();
        studentDTOList.add(studentDTO1);
        studentDTOList.add(studentDTO2);

        return studentDTOList;
    }
    private void validateMethodArgument(String errorMessage) throws Exception{
        String expected = writer.writeValueAsString(studentDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value(errorMessage));
    }

}
