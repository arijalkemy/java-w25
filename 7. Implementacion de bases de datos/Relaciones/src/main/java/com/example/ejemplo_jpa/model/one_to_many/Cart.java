package com.example.ejemplo_jpa.model.one_to_many;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToMany(mappedBy = "cart")
    private Set<Item> items;
}
