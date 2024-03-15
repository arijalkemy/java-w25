package com.jpa.relations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String lastname;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    List<Invoice> invoiceList;
}
