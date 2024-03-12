package com.example.relationships.service.impl;

import com.example.relationships.dto.CreateStudentRequestDto;
import com.example.relationships.model.Cart;
import com.example.relationships.model.Student;
import com.example.relationships.repository.StudentRepository;
import com.example.relationships.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final StudentRepository repository;
    private final ModelMapper mapper;
    @Override
    public Student createStudent(CreateStudentRequestDto studentDto){
        Student newStudent = mapper.map(studentDto, Student.class);
        return repository.save(newStudent);
    }
    @Override
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    @Override
    public void removeStudent(Long id){
        repository.deleteById(id);
    }
}
