package com.example.romanNumbers.controller;

import com.example.romanNumbers.dto.response.AgeDTO;
import com.example.romanNumbers.service.IAgeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {
    IAgeService ageService;

    public AgeController(IAgeService ageService) {
        this.ageService = ageService;
    }

    @GetMapping("/calculate/{day}/{month}/{year}")
    public ResponseEntity<AgeDTO> getPostOfVendorsFollowedByUser(
            @PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return ResponseEntity.ok()
                .body(ageService.calculate(day, month, year));
    }
}
