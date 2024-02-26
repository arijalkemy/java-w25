package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {
    private RomanNumeralsRestController  romanNumeralsRestController = new RomanNumeralsRestController();
    @Test
    void toRoman1() {
        verifyRomanConvertion("I", 1);
    }

    @Test
    void toRoman3() {
        verifyRomanConvertion("III", 3);
    }
    @Test
    void toRoman5() {
        verifyRomanConvertion("V", 5);

    }
    @Test
    void toRoman7() {
        verifyRomanConvertion("VII", 7);
    }
    @Test
    void toRoman10() {
        verifyRomanConvertion("X", 10);
    }
    @Test void toRoman49(){
        verifyRomanConvertion("XLIX", 49);
    }
    @Test
    void toRoman50() {
        verifyRomanConvertion("L", 50);
    }
    private void verifyRomanConvertion(String expectedRomanNumber, Integer integerNumberToConvert){
        String actualRomanNumber = romanNumeralsRestController.toRoman(integerNumberToConvert);
        assertEquals(expectedRomanNumber, actualRomanNumber);
    }
}