package com.sfritz.numerosromanos.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumeroRomano {

    private String numero;

    private static final Map<Integer, String> ROMANOS_MAP = new LinkedHashMap<>();
    
    static {
        ROMANOS_MAP.put(1000, "M");
        ROMANOS_MAP.put(900, "CM");
        ROMANOS_MAP.put(500, "D");
        ROMANOS_MAP.put(400, "CD");
        ROMANOS_MAP.put(100, "C");
        ROMANOS_MAP.put(90, "XC");
        ROMANOS_MAP.put(50, "L");
        ROMANOS_MAP.put(40, "XL");
        ROMANOS_MAP.put(10, "X");
        ROMANOS_MAP.put(9, "IX");
        ROMANOS_MAP.put(5, "V");
        ROMANOS_MAP.put(4, "IV");
        ROMANOS_MAP.put(1, "I");
    }

    public NumeroRomano(Integer numero) {
        StringBuilder resultado = new StringBuilder();
        for (Map.Entry<Integer, String> entry : ROMANOS_MAP.entrySet()) {
            int valor = entry.getKey();
            while (numero >= valor) {
                resultado.append(entry.getValue());
                numero -= valor;
            }
        }
        this.numero = resultado.toString();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
