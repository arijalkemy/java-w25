package com.example.relations.service;

import com.example.relations.dto.ResponseDTO;
import com.example.relations.entity.Course;
import com.example.relations.entity.Student;
import com.example.relations.repository.IStudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService{
    private final IStudentRepository studentRepository;
    private final ModelMapper mapper;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        mapper = new ModelMapper();
    }

    @Override
    public ResponseDTO saveStudent(String name) {
        Student student = new Student();
        student.setName(name);
        studentRepository.save(student);

        return mapper.map(student, ResponseDTO.class);
    }
}
