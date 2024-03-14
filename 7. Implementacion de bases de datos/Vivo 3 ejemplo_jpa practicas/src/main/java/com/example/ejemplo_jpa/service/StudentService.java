package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.ClassDto;
import com.example.ejemplo_jpa.dto.StudentDto;
import com.example.ejemplo_jpa.model.Course;
import com.example.ejemplo_jpa.model.Professor;
import com.example.ejemplo_jpa.model.SchoolSupply;
import com.example.ejemplo_jpa.model.Student;
import com.example.ejemplo_jpa.repository.ClassesRepository;
import com.example.ejemplo_jpa.repository.ProfessorRepository;
import com.example.ejemplo_jpa.repository.StudentRepository;
import com.example.ejemplo_jpa.repository.SupplyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class
StudentService implements IStudentService{

private final StudentRepository stuRepo;
private final ProfessorRepository proRepo;
private final SupplyRepository supRepo;
private final ClassesRepository clRepo;
private ModelMapper mapper;


    public StudentService (StudentRepository stuRepo, ModelMapper mapper, ProfessorRepository proRepo, SupplyRepository supRepo, ClassesRepository clRepo) {

        this.stuRepo = stuRepo;
        this.mapper = mapper;
        this.supRepo = supRepo;
        this.proRepo = proRepo;
        this.clRepo = clRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<StudentDto> getStudents() {
        List<Student> studentList = stuRepo.findAll();
        return studentList.stream().map(student -> mapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void saveStudent(StudentDto stu) {
        Professor professor = saveStudentProfessor(stu);
        Student sStudent =mapper.map(stu, Student.class);
        Set<SchoolSupply> supplies = saveStudentSupplies(stu, sStudent);
        Set<Course> classes = saveStudentClasses(stu, sStudent);
        sStudent.setSupplies(supplies);
        sStudent.setProfessor(professor);
        sStudent.setCourses(classes);
        clRepo.saveAll(classes);
        stuRepo.save(sStudent);
        supRepo.saveAll(supplies);
    }

    @Transactional
    public Set<SchoolSupply> saveStudentSupplies(StudentDto stu, Student sStudent){
        Set<SchoolSupply> supplies = stu.getSupplies().stream()
                .map(s -> mapper.map(s, SchoolSupply.class)).collect(Collectors.toSet());
        supplies.forEach(s -> s.setStudent(sStudent));
        return supplies;
    }

    @Transactional
    public Set<Course> saveStudentClasses(StudentDto stu, Student student){
        Set<Course> classes = stu.getCourses().stream()
                .map(c->mapper.map(c, Course.class)).collect(Collectors.toSet());
        classes.forEach(s-> s.setStudent(Set.of(student)));
        return classes;
    }

    @Transactional
    public Professor saveStudentProfessor(StudentDto stu){
        Professor professor = proRepo.findById(stu.getProfessor().getId()).orElse(null);
        if(professor == null){
            professor = proRepo.save((mapper.map(stu.getProfessor(), Professor.class)));
        }
        return professor;
    }

    @Override
    @Transactional
    public void deleteStudent(long id) {
        stuRepo.deleteById(id);
    }

    @Override
    @Transactional (readOnly = true)
    public StudentDto findStudent(long id) {
        Student stu=stuRepo.findById(id).orElse(null);
        return mapper.map(stu, StudentDto.class);
    }

    @Override
    @Transactional
    public StudentDto updateStudent(StudentDto studentDto, long id){
        Student student = mapper.map(studentDto, Student.class);
        StudentDto stu = findStudent(id);
        if(student.getDni() != null){
            stu.setDni(student.getDni());
        }
        if(student.getName() != null){
            stu.setName(student.getName());
        }
        if(student.getLastname() != null){
            stu.setLastname(student.getLastname());
        }
        saveStudent(stu);
        return stu;
    }

}



