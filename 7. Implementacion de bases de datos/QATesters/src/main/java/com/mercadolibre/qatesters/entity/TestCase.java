package com.mercadolibre.qatesters.entity;

import com.mercadolibre.qatesters.dto.request.TestCaseReqDto;
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

    public TestCase(TestCaseReqDto testCaseReqDto){
        this.description = testCaseReqDto.getDescription();
        this.tested = testCaseReqDto.getTested();
        this.passed = testCaseReqDto.getPassed();
        this.numberOfTries = testCaseReqDto.getNumberOfTries();
        this.lastUpdate = testCaseReqDto.getLastUpdate();
    }
}
