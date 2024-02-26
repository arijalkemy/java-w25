package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {
    RomanNumeralsRestController controller = new RomanNumeralsRestController();
    @Test
    void toRoman1() {
        assertRoman(1, "I");
    }
    @Test
    void toRoman3() {
        assertRoman(3, "III");
    }
    @Test
    void toRoman5() {
        assertRoman(5, "V");
    }
    @Test
    void toRoman10() {
        assertRoman(10, "X");
    }
    @Test
    void toRoman50() {
        assertRoman(50, "L");
    }
    private void assertRoman(Integer number, String expectedRoman) {
        String result = controller.toRoman(number);

        Assertions.assertEquals(expectedRoman, result);
    }
}