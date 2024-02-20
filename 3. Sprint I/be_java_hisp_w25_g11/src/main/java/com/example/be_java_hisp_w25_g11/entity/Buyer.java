package com.example.be_java_hisp_w25_g11.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
    private Integer id;
    private String name;
    private Set<Integer> followed;

    public Buyer(
            Integer id,
            String name
    ) {
        this.id = id;
        this.name = name;
        this.followed = new HashSet<>();
    }
}
