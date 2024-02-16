package com.ejemplo.linkTracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinkResDTO {

    private Integer linkId;
    private Integer count;
    private String message;

    public LinkResDTO(Integer linkId) {
        this.linkId = linkId;
    }

    public LinkResDTO(String message) {
        this.message = message;
    }

    public LinkResDTO(Integer linkId, Integer count) {
        this.linkId = linkId;
        this.count = count;
    }
}
