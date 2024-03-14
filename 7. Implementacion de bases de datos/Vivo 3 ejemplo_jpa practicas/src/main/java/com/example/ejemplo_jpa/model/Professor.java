package com.example.ejemplo_jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@SequenceGenerator(name="PRIVATE_SEQ_2", sequenceName="private_sequence_2")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ_2")
    private Long id;
}
