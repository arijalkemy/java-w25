package com.mercadolibre.java_applications.service;

import org.springframework.stereotype.Service;

import com.mercadolibre.java_applications.dtos.response.ResponseDTO;

@Service
public class iServiceImp implements iService{
    @Override
    public ResponseDTO getResponse() {
        return new ResponseDTO("pong");
    }
}
