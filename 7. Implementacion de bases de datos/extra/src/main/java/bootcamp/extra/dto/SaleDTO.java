package bootcamp.extra.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleDTO {

    Long id;
    @JsonFormat(pattern="dd/MM/yyyy")
    LocalDate date;
    Double total;
    String paymentMethod;

}
