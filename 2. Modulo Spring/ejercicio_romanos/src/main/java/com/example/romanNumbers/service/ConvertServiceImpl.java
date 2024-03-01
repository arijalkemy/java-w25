package com.example.romanNumbers.service;

import com.example.romanNumbers.dto.response.RomanNumberDTO;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Override
    public RomanNumberDTO convert(Integer number) {
        StringBuilder resultado = new StringBuilder();

        int[] numerosDecimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < numerosDecimales.length; i++) {
            while (number >= numerosDecimales[i]) {
                resultado.append(numerosRomanos[i]);
                number -= numerosDecimales[i];
            }
        }

        return new RomanNumberDTO(resultado.toString());
    }
}
