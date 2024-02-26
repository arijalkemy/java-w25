package com.meli.obtenerdiploma.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class TestUtilsGenerator {

    public static void emptyUsersFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/test/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        assert writer != null;
        writer.print("[]");
        writer.close();
    }
    public static void erraseFile() throws FileNotFoundException {
        File usersJson = ResourceUtils.getFile("./src/test/resources/users.json");
        usersJson.delete();
    }
    public static void createFile() throws IOException {
        File resources = ResourceUtils.getFile("./src/test/resources/users.json");
        resources.createNewFile();
        emptyUsersFile();
    }

    public static void loadUserFile(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(ResourceUtils.getFile("./src/test/resources/users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        assert writer != null;
        writer.print("[{\n" +
                "    \"id\": 1,\n" +
                "    \"studentName\": \"Juan\",\n" +
                "    \"subjects\": [\n" +
                "      {\n" +
                "        \"name\": \"Matematica\",\n" +
                "        \"score\": 7\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Fisica\",\n" +
                "        \"score\": 7\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Quimica\",\n" +
                "        \"score\": 7\n" +
                "      }\n" +
                "    ]\n" +
                "  }]");
        writer.close();
    }
    public static StudentDTO getExampleStudent(){
        return new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO(
                                "Matematica",
                                7.0
                        ),
                        new SubjectDTO(
                                "Fisica", 7.0

                        ),
                        new SubjectDTO("Quimica", 7.0)
                )
        );
    }
    public static StudentDTO getExampleStudentWith9(){
        return new StudentDTO(
                1L,
                "Juan",
                null,
                null,
                List.of(
                        new SubjectDTO(
                                "Matematica",
                                9.0
                        ),
                        new SubjectDTO(
                                "Fisica", 9.0

                        ),
                        new SubjectDTO("Quimica", 9.0)
                )
        );
    }



}
