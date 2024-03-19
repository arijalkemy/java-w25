package com.mercadolibre.java_applications.controller;

import com.newrelic.api.agent.NewRelic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mercadolibre.java_applications.dtos.response.ResponseDTO;
import com.mercadolibre.java_applications.service.iService;
import org.springframework.http.HttpStatus;

/**
 * Controller responsible for /ping implementation.
 */
@RestController
public class PingController {

  @Autowired
  iService service;

  /**
   * @return "pong" String.
   */
  @GetMapping("/ping")
  public ResponseEntity<ResponseDTO> ping() {
    return new ResponseEntity<>(service.getResponse(), HttpStatus.OK);
  }
}
