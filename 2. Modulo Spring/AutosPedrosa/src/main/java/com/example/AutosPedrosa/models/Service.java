package com.example.AutosPedrosa.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Service {

    private Date date;
    private Long kilometers;
    private String descriptions;

}
