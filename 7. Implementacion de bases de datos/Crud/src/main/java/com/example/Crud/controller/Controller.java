package com.example.Crud.controller;

import com.example.Crud.model.Student;
import com.example.Crud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private IStudentService stuService;

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student) {
        stuService.saveStudent(student);
        return "El estudiante se guardo bien";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> studentList = stuService.getStudents();
        return  studentList;
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable long id, @RequestParam("name") String newName,
                               @RequestParam ("lastname") String newLastName){
        Student stu = stuService.findStudent(id);
        stu.setName(newName);
        stu.setLastName(newLastName);
        stuService.saveStudent(stu);
        return stu;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable long id){
        stuService.deleteStudent(id);
        return "El estudiante fue boorado correctamente";
    }
}
