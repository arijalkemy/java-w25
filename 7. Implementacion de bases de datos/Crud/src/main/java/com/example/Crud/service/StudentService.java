package com.example.Crud.service;

import com.example.Crud.model.Student;
import com.example.Crud.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    private final StudentRepository stuRepo;

    public StudentService(StudentRepository stuRepo) {
        this.stuRepo = stuRepo;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        List<Student> studentList= stuRepo.getAll();
        return studentList;
    }

    @Override
    @Transactional
    public void saveStudent(Student stu) {
        stuRepo.save(stu);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        stuRepo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findStudent(Long id) {
        Student stu= stuRepo.findBy(id).orElse(null);
        return stu;
    }
}
