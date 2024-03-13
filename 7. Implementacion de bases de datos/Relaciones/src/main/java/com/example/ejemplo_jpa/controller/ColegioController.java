package com.example.ejemplo_jpa.controller;

import com.example.ejemplo_jpa.dto.CourseDTO;
import com.example.ejemplo_jpa.dto.StudentCoursesDTO;
import com.example.ejemplo_jpa.dto.StudentDTO;
import com.example.ejemplo_jpa.service.ColegioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColegioController {

    ColegioService colegioService;

    public ColegioController(ColegioService colegioService) {
        this.colegioService = colegioService;
    }

    /*@PostMapping
    public ResponseEntity<String> saveStudentLikes(
        @RequestBody
        StudentCoursesDTO studentCoursesDTO
    ) {
        colegioService.saveStudentLikes(studentCoursesDTO);
        return ResponseEntity.ok("Todo ok");
    }*/

    @PostMapping("/saveStudent")
    public ResponseEntity<String> saveStudent(
        @RequestBody
        StudentDTO studentDTO
    ) {
        colegioService.save(studentDTO);
        return ResponseEntity.ok("Estudiante guardado exitosamente");
    }

    @PostMapping("/saveCourse")
    public ResponseEntity<String> saveCourse(
            @RequestBody
            CourseDTO courseDTO
    ) {
        colegioService.save(courseDTO);
        return ResponseEntity.ok("Curso guardado exitosamente");
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enroll(
            @RequestBody
            StudentCoursesDTO studentCoursesDTO
    ) {
        colegioService.enroll(studentCoursesDTO);
        return ResponseEntity.ok("Todo ok");
    }

}
