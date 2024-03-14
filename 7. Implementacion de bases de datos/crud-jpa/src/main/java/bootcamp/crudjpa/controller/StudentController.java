package bootcamp.crudjpa.controller;

import bootcamp.crudjpa.model.Student;
import bootcamp.crudjpa.service.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok("El estudiante fue agregado correctamente");
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.findStudents());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable long id,
                                               @RequestParam(value = "name", required = false) String newName,
                                               @RequestParam(value = "lastname", required = false) String newLastname) {
        return ResponseEntity.ok(studentService.updateStudent(id, newName, newLastname));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("El estudiante fue borrado correctamente");
    }

}
