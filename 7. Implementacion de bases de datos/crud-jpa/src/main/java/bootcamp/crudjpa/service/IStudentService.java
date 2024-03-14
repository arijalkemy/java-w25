package bootcamp.crudjpa.service;

import bootcamp.crudjpa.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findStudents();
    Student findStudentById(long id);
    void saveStudent(Student student);
    Student updateStudent(long id, String newName, String newLastname);
    void deleteStudent(long id);

}
