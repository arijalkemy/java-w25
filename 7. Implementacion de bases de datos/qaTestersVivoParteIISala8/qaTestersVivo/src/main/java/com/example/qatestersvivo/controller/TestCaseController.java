package com.example.qatestersvivo.controller;

import com.example.qatestersvivo.entity.TestCase;
import com.example.qatestersvivo.service.ITestCaseService;
import com.example.qatestersvivo.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    @Autowired
    ITestCaseService service ;

    @PostMapping("/new")
    public TestCase createTest(@RequestBody TestCase body){
        return service.create(body);
    }

    @GetMapping("/")
    public List<TestCase> getAll(@RequestParam (value = "last_update", required = false) String date){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TestCase getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public TestCase updateById(@PathVariable Long id,
                               @RequestBody TestCase obj)
    {
        return service.updateById(id, obj);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}
