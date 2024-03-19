package com.mercadolibre.java_applications.service;

import org.eclipse.jetty.http.HttpTester.Response;

import com.mercadolibre.java_applications.dtos.response.ResponseDTO;

public interface iService {
    ResponseDTO getResponse();
}
