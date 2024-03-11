package meli.com.co.qatesters.dto.request;

import lombok.Data;


@Data
public class UpdateCaseDto {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
}
