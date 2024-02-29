package org.clase08_02_24.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Localizador {
    int id;
    Cliente cliente;
    List<Reservas> reservasList;
    Double totalAPagar;
}
