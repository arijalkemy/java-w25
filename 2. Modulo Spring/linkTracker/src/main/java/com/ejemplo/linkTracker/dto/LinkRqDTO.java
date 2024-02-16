package com.ejemplo.linkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class LinkRqDTO {

    private String link;
    private String password;
}
