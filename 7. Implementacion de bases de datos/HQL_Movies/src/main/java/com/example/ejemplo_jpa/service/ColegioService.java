package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.CourseDTO;
import com.example.ejemplo_jpa.dto.StudentCoursesDTO;
import com.example.ejemplo_jpa.dto.StudentDTO;
import com.example.ejemplo_jpa.model.many_to_many.Course;
import com.example.ejemplo_jpa.model.many_to_many.Student;
import com.example.ejemplo_jpa.repository.CourseInterface;
import com.example.ejemplo_jpa.repository.StudentInterface;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ColegioService {

    ModelMapper modelMapper = new ModelMapper();

    CourseInterface courseRepo;
    StudentInterface studentRepo;

    public ColegioService(
            CourseInterface courseRepo,
            StudentInterface studentRepo
    ) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    /*public void saveStudentLikes(StudentCoursesDTO studentCoursesDTO) {

        Student student = new Student(
                studentCoursesDTO.getName(),
                studentCoursesDTO.getLastName()
        );
        //Cree un curso

        //Le asigno el curso al estudiante
        //Le asigno el estudiante al curso

        //courseRepo.save();
        studentRepo.save(student);

    }*/

    public void enroll(StudentCoursesDTO studentCoursesDTO) {
        /*Long course_id = studentCoursesDTO.getCourse_id();
        Long student_id = studentCoursesDTO.getStudent_id();

        Course course = courseRepo.findById(course_id).get();
        Student student = studentRepo.findById(student_id).get();

        student.getLikedCourses().add(course);
        course.getLikes().add(student);

        studentRepo.save(student);*/

        //Long course_id = studentCoursesDTO.getCourse_id();
        Long student_id = studentCoursesDTO.getStudent_id();

        //Course course = courseRepo.findById(course_id).get();
        Student student = studentRepo.findById(student_id).get();
        var cors = new Course();
        cors.setDescription("asd");
        student.getLikedCourses().add(
                cors
        );
        //course.getLikes().add(student);

        studentRepo.save(student);
    }

    public void save(StudentDTO studentDTO) {
        Student newStudent = modelMapper.map(studentDTO, Student.class);
        newStudent.setLikedCourses(new HashSet<>());
        studentRepo.save(
                newStudent
        );
    }

    public void save(CourseDTO courseDTO) {
        Course newCourse = modelMapper.map(courseDTO, Course.class);
        newCourse.setLikes(new HashSet<>());
        courseRepo.save(
                newCourse
        );
    }
}
