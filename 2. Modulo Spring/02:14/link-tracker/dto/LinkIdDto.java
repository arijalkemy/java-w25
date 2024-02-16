package com.linktraker.ejercicio2.dto;

import com.linktraker.ejercicio2.model.Link;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkIdDto {
    private Integer id;

    public LinkIdDto(Link link) {
        this.id = link.getId();
    }
}
