package com.breakingbytes.be_java_hisp_w25_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionDTO {
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<ExceptionValidatorsDTO> validations;

    public ExceptionDTO(String message){
        this.message = message;
    }
}
