package com.example.relations.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Sale {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long Id;

    @OneToMany( cascade = CascadeType.PERSIST)
    @JoinColumn( name = "sale_id" )
    List<SaleDetail> details;

}
