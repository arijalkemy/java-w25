package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    Sale sale;

    @ManyToOne
    @JoinColumn(name = "clothe_id", nullable = false)
    Clothe clothe;
}
