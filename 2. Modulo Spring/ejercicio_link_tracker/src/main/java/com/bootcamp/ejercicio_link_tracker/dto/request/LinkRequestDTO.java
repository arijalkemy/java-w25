package com.bootcamp.ejercicio_link_tracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkRequestDTO {
    private String url;
    private String password;
}