package com.meli.obtenerdiploma.repository;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;

@Repository
public class StudentRepository implements IStudentRepository {

    @Value("${api.scope}")
    private String scope;

    @Override
    public Set<StudentDTO> findAll() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + scope + "/resources/users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loadedData;
    }
}
