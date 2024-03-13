package com.example.ejemplo_jpa.model.one_to_one;

import com.example.ejemplo_jpa.model.one_to_one.User;

import javax.persistence.*;

@Entity
@Table( name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(mappedBy = "address")
    private User user;
}
