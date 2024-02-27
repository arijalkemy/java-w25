package com.example.link_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Link {
    private int id;
    private String url;
    private boolean valid;
    private int counter;
}
