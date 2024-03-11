package com.example.relationships.controller;

import com.example.relationships.dto.CreateStudentRequestDto;
import com.example.relationships.model.Student;
import com.example.relationships.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final IStudentService service;

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudentRequestDto student){
        return ResponseEntity.ok(this.service.createStudent(student));
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(this.service.getAllStudents());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
         this.service.removeStudent(id);
         return ResponseEntity.ok(null);
    }
}
