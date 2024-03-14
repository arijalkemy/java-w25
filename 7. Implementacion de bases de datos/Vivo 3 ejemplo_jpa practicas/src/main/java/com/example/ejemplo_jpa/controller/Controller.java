package com.example.ejemplo_jpa.controller;

import com.example.ejemplo_jpa.dto.MessageDto;
import com.example.ejemplo_jpa.dto.StudentDto;
import com.example.ejemplo_jpa.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private IStudentService stuServ;

    @GetMapping ("/students")
    public ResponseEntity<List<StudentDto>> getStudents () {

        List<StudentDto> studentList = stuServ.getStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);

    }

    @GetMapping ("/{id}")
    public ResponseEntity<StudentDto> getStudents (@PathVariable long id) {

        StudentDto stu = stuServ.findStudent(id);

        return new ResponseEntity<>(stu, HttpStatus.OK);

    }

    @PostMapping ("/create")
      public ResponseEntity<MessageDto> createStudent(@RequestBody StudentDto student) {
        stuServ.saveStudent(student);
        return new ResponseEntity<>(new MessageDto("El estudiante fue agregado correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<MessageDto>  deleteStudent (@PathVariable long id) {
        stuServ.deleteStudent(id);
        return new ResponseEntity<>(new MessageDto("El estudiante fue borrado correctamente"), HttpStatus.OK);
    }

    @PutMapping ("edit/{id}")
    public ResponseEntity<StudentDto> editStudent (@PathVariable long id,
                                @RequestBody StudentDto studentDto) {
        StudentDto stu = stuServ.updateStudent(studentDto, id);
        return new ResponseEntity<>(stu, HttpStatus.OK);
    }

}
