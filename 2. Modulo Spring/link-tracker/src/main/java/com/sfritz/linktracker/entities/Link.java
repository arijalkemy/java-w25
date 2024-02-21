package com.sfritz.linktracker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {

    private Long linkId;
    private String url;
    private String password;
    private Boolean isValid;
    private Integer metric;
}
