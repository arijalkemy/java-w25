package bootcamp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {
    private LocalDate date;
    private Integer kilometers;
    private String descriptions;
}
