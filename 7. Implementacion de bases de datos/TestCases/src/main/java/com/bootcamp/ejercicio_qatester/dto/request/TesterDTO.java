package com.bootcamp.ejercicio_qatester.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class TesterDTO {
    private String name;
    private List<TestCaseDTO> tests;
    private GithubProfileDTO githubProfile;
}
