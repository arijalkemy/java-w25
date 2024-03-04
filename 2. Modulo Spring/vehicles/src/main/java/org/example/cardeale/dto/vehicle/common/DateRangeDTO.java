package org.example.cardeale.dto.vehicle.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateRangeDTO {
    LocalDate since;
    LocalDate to;
}
