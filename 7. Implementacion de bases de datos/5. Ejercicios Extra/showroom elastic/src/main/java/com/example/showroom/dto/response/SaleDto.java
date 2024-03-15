package com.example.showroom.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {
    private String id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String date;
    private Double total;
    private String paymentMethod;
}
