package org.bootcamp.segurosautos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatentBrandDto {
    private String patent;
    private String brand;
}
