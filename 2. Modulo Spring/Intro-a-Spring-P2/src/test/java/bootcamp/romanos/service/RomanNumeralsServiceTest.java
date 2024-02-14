package bootcamp.romanos.service;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsServiceTest {

    private final IRomanNumeralsService romanNumeralsService = new RomanNumeralsServiceImp();
    private final Map<Integer, String> valuesToTest = new HashMap<>()
    {{
        put(1, "I");
        put(2, "II");
        put(3, "III");
        put(4, "IV");
        put(5, "V");
        put(7, "VII");
        put(8, "VIII");
        put(9, "IX");
        put(10, "X");
        put(11, "XI");
        put(12, "XII");
        put(13, "XIII");
        put(14, "XIV");
        put(15, "XV");
        put(16, "XVI");
        put(49, "XLIX");
        put(50, "L");
        put(51, "LI");
    }};

     @Test
    public void testListOfValues() {
        for (Integer number : valuesToTest.keySet()) {
            String romanNumerical = romanNumeralsService.getRomanNumeralOfNumber(number);
            System.out.println("Roman numerical of " + number + " is: " + romanNumerical);
            String mappedValue = valuesToTest.get(number);
            assert romanNumerical.equals(mappedValue);
        }
    }

}
