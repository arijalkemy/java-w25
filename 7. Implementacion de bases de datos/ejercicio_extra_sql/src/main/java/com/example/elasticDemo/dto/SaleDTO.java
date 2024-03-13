package com.example.elasticDemo.dto;

import com.example.elasticDemo.model.Clothes;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleDTO {
    Long id;
    LocalDate fecha;
    Double total;
    String medio_pago;
    @JsonFormat(pattern = "dd/MM/yyyy")
    List<Clothes> prendas;
}
