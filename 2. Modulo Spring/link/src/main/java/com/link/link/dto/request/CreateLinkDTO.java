package com.link.link.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateLinkDTO {
    private String link;
    private String password;

    public CreateLinkDTO(String link) {
        this.link = link;
    }
}
