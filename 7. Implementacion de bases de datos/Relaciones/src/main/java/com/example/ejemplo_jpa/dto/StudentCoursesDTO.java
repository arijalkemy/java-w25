package com.example.ejemplo_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCoursesDTO {
    private Long student_id;
    private Long course_id;
}
