package com.bootcamp.ejercicio_qatester.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "profile")
public class GithubProfile {
    @Id
    String username;
    Boolean proAccount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tester_id", referencedColumnName =  "id")
    Tester tester;
}
