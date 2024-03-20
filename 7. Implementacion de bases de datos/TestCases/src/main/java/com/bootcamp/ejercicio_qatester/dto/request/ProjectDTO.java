package com.bootcamp.ejercicio_qatester.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class ProjectDTO {
    private String name;
    private Set<TestCaseDTO> tests;
}
