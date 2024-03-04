package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    private String date;
    private String kilometers;
    private String description;
}
