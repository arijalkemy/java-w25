package com.meli.obtenerdiploma.repository;

import java.io.File;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;

@Repository
public class StudentDAO implements IStudentDAO {

    private String scope;

    private Set<StudentDTO> students;

    public StudentDAO() {
        Properties properties = new Properties();
        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.scope = properties.getProperty("api.scope");
            this.loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(StudentDTO stu) {
        boolean removed = this.delete(stu.getId());

        if (!removed)
            stu.setId((this.students.size() + 1L));

        students.add(stu);

        this.saveData();
    }

    @Override
    public boolean delete(Long id) {
        boolean ret = false;

        try {
            StudentDTO found = this.findById(id);

            students.remove(found);
            ret = true;
            this.saveData();

        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public boolean exists(StudentDTO stu) {
        boolean ret = false;
        try {
            ret = this.findById(stu.getId()) instanceof StudentDTO;
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

        return ret;
    }

    @Override
    public StudentDTO findById(Long id) {
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst().orElseThrow(() -> new StudentNotFoundException(id));
    }

    private void loadData() {
        Set<StudentDTO> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = ResourceUtils.getFile("./src/" + scope + "/resources/users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<StudentDTO>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.students = loadedData;
    }

    private void saveData() {
        try {
            File file = ResourceUtils.getFile("./src/" + scope + "/resources/users.json");
            new ObjectMapper().writeValue(file, this.students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
