package com.relations.relations.dto.response;
import com.relations.relations.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCarritoDto {
    private Long id;
    private Boolean lleno;
    private Set<Producto> productos;
}
