package demoW25.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import demoW25.model.Sports;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SportDTO {

    private Sports sport;

    private String message;
}
