package com.example.relations.controller;

import com.example.relations.service.ICourseService;
import com.example.relations.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final ICourseService courseService;
    private final IStudentService studentService;

    public Controller(ICourseService courseService, IStudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @PostMapping("course/new")
    public ResponseEntity<?> createCourse (@RequestBody String name){
        return new ResponseEntity<>(courseService.saveCourse(name), HttpStatus.OK);
    }

    @PostMapping("student/new")
    public ResponseEntity<?> createStudent(@RequestBody String name){
        return new ResponseEntity<>(studentService.saveStudent(name), HttpStatus.OK);
    }
}
