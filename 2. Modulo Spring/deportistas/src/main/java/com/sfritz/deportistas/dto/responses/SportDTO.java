package com.sfritz.deportistas.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportDTO {
    private String name;
    private Integer level;
}
