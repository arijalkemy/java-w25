package org.example.cardeale.dto.vehicle.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceRangeDTO {
    double since;
    double to;
}
