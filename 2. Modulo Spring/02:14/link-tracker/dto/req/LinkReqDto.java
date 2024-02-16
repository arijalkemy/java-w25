package com.spring.linktracker.dto.req;

import lombok.Data;

@Data
public class LinkReqDto {

    private Integer id;

    public LinkReqDto(String link) {
        this.id = Integer.parseInt(link);
    }

}
