package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.StudentDto;
import com.example.ejemplo_jpa.model.Student;
import java.util.List;

public interface IStudentService {

    public List<StudentDto> getStudents ();
    public void saveStudent (StudentDto stu);
    public void deleteStudent (long id);
    public StudentDto findStudent (long id);
    public StudentDto updateStudent(StudentDto stu, long id);



}
