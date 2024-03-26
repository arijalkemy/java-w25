package com.example.SegurosDeAutos.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperUtil {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        return modelMapper;
    }
}

/*
*
*     @Override
    @Transactional(readOnly = true)
    public List<TestCaseResponseIdDTO> getAllTestCasesWithLastUpdateAfter(LocalDate date) {
        List<TestCase> testCaseList = testCaseRepository.findByLastUpdateAfter(date);
        return testCaseList.stream()
                .map(CustomMapper::testCaseToTestCaseResponseId)
                .collect(Collectors.toList());
    }
* */
