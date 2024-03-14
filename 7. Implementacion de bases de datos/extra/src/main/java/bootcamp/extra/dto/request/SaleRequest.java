package bootcamp.extra.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaleRequest {

    //String numero; // TODO en la entidad Sale no existe este atributo
    @JsonFormat(pattern="dd/MM/yyyy")
    LocalDate date;
    Double total;
    String paymentMethod;
}
