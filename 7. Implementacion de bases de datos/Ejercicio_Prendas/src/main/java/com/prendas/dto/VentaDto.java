package com.prendas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.prendas.entity.Prenda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDto {
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate fecha;
    Double total;
    @JsonProperty("medio_pago")
    String medioPago;
    @JsonProperty("prenda_list")
    Set<Prenda> prendaList;
}

/*
{
    "fecha": "01/01/2000",
    "total": 1000.0,
    "medio_pago": "Mercado Pago",
    "prenda_list": [
        {
            "nombre": "Lacoste Air",
            "tipo": "Chomba",
            "marca": "Lacoste",
            "color": "Verde",
            "cantidad": 5,
            "talle": "M",
            "precio_venta": 100.0
        },
        {
            "nombre": "Adidas New",
            "tipo": "Short",
            "marca": "Adidas",
            "color": "Rojo",
            "cantidad": 10,
            "talle": "M",
            "precio_venta": 100.0
        }
     ]
}*/
