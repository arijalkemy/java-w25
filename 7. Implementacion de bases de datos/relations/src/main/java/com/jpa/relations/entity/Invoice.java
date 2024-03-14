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
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "invoice_items", joinColumns =
    @JoinColumn(name = "invoice_id"), inverseJoinColumns =
    @JoinColumn(name = "item_id"))
    List<Item> invoice_items;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

}
