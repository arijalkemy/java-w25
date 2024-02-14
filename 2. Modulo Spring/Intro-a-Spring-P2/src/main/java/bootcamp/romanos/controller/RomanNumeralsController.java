package bootcamp.romanos.controller;

import bootcamp.romanos.response.RomanNumberResponse;
import bootcamp.romanos.service.IRomanNumeralsService;
import bootcamp.romanos.service.RomanNumeralsServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("Roman numerals")
@RequestMapping("roman-numerals")
public class RomanNumeralsController {

    private IRomanNumeralsService romanNumeralsService = new RomanNumeralsServiceImp();

    @GetMapping("/{number}")
    private ResponseEntity<RomanNumberResponse> getRomanNumber(@PathVariable Integer number) {
        String romanNumber = romanNumeralsService.getRomanNumeralOfNumber(number);

        return new ResponseEntity<>(RomanNumberResponse.builder().originalNumber(number).romanNumber(romanNumber).build(), HttpStatus.OK);
    }

}
