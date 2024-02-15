package com.example.linktracker.utils;

import com.example.linktracker.dto.request.RedirectRequestDTO;
import com.example.linktracker.dto.response.RedirectResponseDTO;
import com.example.linktracker.entity.Link;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class RedirectMapper {
    public static RedirectRequestDTO toRedirectRequestDTO(int linkId,String password){
        return new RedirectRequestDTO(linkId,password);
    }

    public static RedirectResponseDTO toRedirectResponseDTO(Link link){
        return  new RedirectResponseDTO(link.getUrl(),link.getValido());
    }
}
