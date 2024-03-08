package com.bootcamp.ejercicio_link_tracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkPasswordDTO {
    private Integer linkId;
    private String password;
}