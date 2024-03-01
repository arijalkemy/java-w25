package com.example.romanNumbers.controller;

import com.example.romanNumbers.dto.response.RomanNumberDTO;
import com.example.romanNumbers.service.IConvertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertController {
    IConvertService convertService;

    public ConvertController(IConvertService convertService) {
        this.convertService = convertService;
    }

    @GetMapping("/convert/{number}")
    public ResponseEntity<RomanNumberDTO> getPostOfVendorsFollowedByUser(
            @PathVariable Integer number) {
        return ResponseEntity.ok()
                .body(convertService.convert(number));
    }
}
