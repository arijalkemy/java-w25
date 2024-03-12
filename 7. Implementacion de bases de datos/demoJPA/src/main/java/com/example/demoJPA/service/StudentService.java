package com.example.demoJPA.service;

import com.example.demoJPA.repository.IStudentRepository;

public class StudentService {
    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
