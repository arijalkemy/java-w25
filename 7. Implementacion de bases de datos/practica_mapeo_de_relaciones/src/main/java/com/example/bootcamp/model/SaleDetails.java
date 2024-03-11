package com.example.bootcamp.model;

import jakarta.persistence.*;

import java.util.List;

public class SaleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
