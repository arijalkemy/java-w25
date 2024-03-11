package ejer.probandohibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    public String createStudent (@RequestBody Student student){
        studentService.saveStudent(student);
        return "Estudiante creado";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("edit/{id}")
    public Student editStudent(@PathVariable Long id,
                               @RequestParam ("name") String newName,
                               @RequestParam("lastname") String newLastName){
        Student student = studentService.findStudent(id);
        student.setName(newName);
        student.setLastname(newLastName);
        studentService.saveStudent(student);
        return student;
    }

    @PostMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id){
    studentService.deleteStudent(id);
    return "eliminado el estudiante";
    }
}
