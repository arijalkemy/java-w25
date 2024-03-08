package com.bootcamp.ejercicio_link_tracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkRedirectDTO {
    private String url;
    private String password;
}
