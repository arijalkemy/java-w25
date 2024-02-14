package bootcamp.romanos.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RomanNumeralsServiceImp implements IRomanNumeralsService {

    private final Map<Integer, String> values = new HashMap<>()
    {{
        put(1, "I");
        put(5, "V");
        put(10, "X");
        put(50, "L");
        put(100, "C");
        put(500, "D");
        put(1000, "M");
    }};
    private final List<Integer> divisors = Arrays.asList(1000, 500, 100, 50, 10, 5, 1);

    /*
    I
    ..
    IV
    V
    VI
    VII
    VIII
    IX
    X
    XI
    XII
    XIII
    XIV
    */

    @Override
    public String getRomanNumeralOfNumber(Integer number) {
        StringBuilder romanNumber = new StringBuilder();

        int remaining = number;
        for (int i = 0; i < divisors.size(); i++) {
            int divisor = divisors.get(i);
            int rest = remaining;
            int added = 0;
            int n;
            if (i < divisors.size()-1 && divisors.get(i + 1) == 5) n = 8;
            else n = i < divisors.size()-1 ? divisor - (divisors.get(i + 1) * 2) : 0;
            if (n > 0 && n <= rest && rest - n == 1 && i < divisors.size()-1) {
                int preValue = divisors.get(i + 1);
                if (preValue == 5) preValue = divisors.get(i + 2);
                romanNumber.append((values.get(preValue)));
                added -= preValue;
                rest += preValue;
            }
            int integerDivision = Math.floorDiv(rest, divisor);
            while(integerDivision >= 1) {
                romanNumber.append(values.get(divisor));
                added += divisor;
                rest -= divisor;
                integerDivision = Math.floorDiv(rest, divisor);
            }
            remaining -= added;
        }

        return romanNumber.toString();
    }

}
