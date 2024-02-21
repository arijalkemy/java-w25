package com.example.be_java_hisp_w25_g10.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;



//LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private User user;
    private LocalDate date;
    private Product product;
}

