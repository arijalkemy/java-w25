package com.example.relations.service;

import com.example.relations.dto.ResponseDTO;
import com.example.relations.entity.Course;
import com.example.relations.repository.ICourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements ICourseService{
    private final ICourseRepository courseRepository;
    private final ModelMapper mapper;

    public CourseServiceImpl(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        mapper = new ModelMapper();
    }

    @Override
    public ResponseDTO saveCourse(String name) {
        Course course = new Course();
        course.setName(name);
        courseRepository.save(course);

        return mapper.map(course, ResponseDTO.class);
    }
}
