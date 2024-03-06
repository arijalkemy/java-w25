package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentDAO studentDAO;

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public void create(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public StudentDTO read(Long id) {
        StudentDTO studentDTO = studentDAO.findById(id);
        if (studentDTO == null) {
            throw new StudentNotFoundException(id);
        }
        return studentDTO;
    }

    @Override
    public void update(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public Boolean delete(Long id) {
        return studentDAO.delete(id);
    }

    @Override
    public Set<StudentDTO> getAll() {
        return this.studentRepository.findAll();
    }
}
