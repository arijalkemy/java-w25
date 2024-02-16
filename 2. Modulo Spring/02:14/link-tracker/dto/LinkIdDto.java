package com.spring.linktracker.dto;

import com.spring.linktracker.model.Link;

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
