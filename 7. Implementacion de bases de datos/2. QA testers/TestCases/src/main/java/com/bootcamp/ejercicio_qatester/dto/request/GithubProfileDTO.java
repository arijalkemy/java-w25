package com.bootcamp.ejercicio_qatester.dto.request;

import lombok.Data;

@Data
public class GithubProfileDTO {
    private String username;
    private Boolean proAccount;
    private TesterDTO tester;
}
