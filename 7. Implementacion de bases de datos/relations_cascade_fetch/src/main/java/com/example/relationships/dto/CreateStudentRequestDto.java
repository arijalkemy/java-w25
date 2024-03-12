package com.example.relationships.dto;

import com.example.relationships.model.Course;
import lombok.Data;

import java.util.Set;
@Data
public class CreateStudentRequestDto {
    private String name;
    private Set<Course> courses;
}
