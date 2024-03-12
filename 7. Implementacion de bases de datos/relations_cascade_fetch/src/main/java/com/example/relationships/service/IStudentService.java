package com.example.relationships.service;

import com.example.relationships.dto.CreateStudentRequestDto;
import com.example.relationships.model.Student;

import java.util.List;

public interface IStudentService {
    Student createStudent(CreateStudentRequestDto student);

    List<Student> getAllStudents();

    void removeStudent(Long id);
}
