package com.example.showroom.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {
    private Long id;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
}
