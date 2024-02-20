package com.example.LinkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Link {
    private int linkId;
    private String originalUrl;
    private String password;
    private int redirectCount;
}
