package com.mercadolibre.qatesters.entity;

import com.mercadolibre.qatesters.dto.TestCaseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    int numberOfTries;
    LocalDate lastUpdate;

    public TestCase(TestCaseDto testCaseDto){
        this.description =testCaseDto.getDescription();
        this.tested = testCaseDto.getTested();
        this.passed = testCaseDto.getPassed();
        this.numberOfTries = testCaseDto.getNumberOfTries();
        this.lastUpdate = testCaseDto.getLastUpdate();
    }
}
