package com.example.qatestersvivo.controller;

import com.example.qatestersvivo.entity.Tester;
import com.example.qatestersvivo.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tester")
public class TesterController {

    @Autowired()
    TesterService service;
    @PostMapping("")
    public Tester createUser(@RequestBody  Tester obj){
        return service.createTester(obj);
    }
}
