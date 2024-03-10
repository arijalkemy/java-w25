package com.meli.obtenerdiploma.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService {

    final IStudentDAO studentDAO;

    final IStudentRepository studentRepository;

    StudentService(IStudentDAO studentDAO, IStudentRepository studentRepository) {
        this.studentDAO = studentDAO;
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public StudentDTO read(Long id) {
        return studentDAO.findById(id);
    }

    @Override
    public void update(StudentDTO stu) {
        studentDAO.save(stu);
    }

    @Override
    public void delete(Long id) {
        studentDAO.delete(id);
    }

    @Override
    public Set<StudentDTO> getAll() {
        return this.studentRepository.findAll();
    }
}
