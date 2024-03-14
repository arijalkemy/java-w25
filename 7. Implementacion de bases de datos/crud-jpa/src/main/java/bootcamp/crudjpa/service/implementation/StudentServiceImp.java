package bootcamp.crudjpa.service.implementation;

import bootcamp.crudjpa.exception.StudentAlreadyExistsException;
import bootcamp.crudjpa.exception.StudentNotFoundException;
import bootcamp.crudjpa.model.Student;
import bootcamp.crudjpa.repository.StudentRepository;
import bootcamp.crudjpa.service.IStudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements IStudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public void saveStudent(Student student) {
        Long studentId = student.getId();
        if (studentId != null && studentRepository.existsById(studentId))
            throw new StudentAlreadyExistsException(studentId);
        studentRepository.save(student);
    }

    @Override
    public Student updateStudent(long id, String newName, String newLastname) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty())
            throw new StudentNotFoundException(id);
        Student student = studentOptional.get();
        if (newName != null) student.setName(newName);
        if (newLastname != null) student.setLastName(newLastname);
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(long id) {
        if (!studentRepository.existsById(id))
            throw new StudentNotFoundException(id);
        studentRepository.deleteById(id);
    }
}
