package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;

public interface IStudentDAO {
    void save(StudentDTO stu);
    Boolean delete(Long id);
    boolean exists(StudentDTO stu);
    StudentDTO findById(Long id);
}