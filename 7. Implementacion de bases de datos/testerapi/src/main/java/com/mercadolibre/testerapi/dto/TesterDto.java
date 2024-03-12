package com.mercadolibre.testerapi.dto;

import com.mercadolibre.testerapi.model.TestCase;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TesterDto {
    private Long idTester;
    private String nombre;
    private String apellido;
    private List<TestCaseDto> listTests;
}
