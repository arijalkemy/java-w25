package bootcamp.introaspringp2vivo.controller;

import bootcamp.introaspringp2vivo.exception.NotValidMorseCodeException;
import bootcamp.introaspringp2vivo.exception.NotValidTextException;
import bootcamp.introaspringp2vivo.response.MorseResponse;
import bootcamp.introaspringp2vivo.service.IMorseService;
import bootcamp.introaspringp2vivo.service.MorseServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("morse")
public class MorseController {

    private final IMorseService morseService = new MorseServiceImp();

    @GetMapping("/translate/{code}")
    public ResponseEntity<MorseResponse> getTranslation(@PathVariable String code){
        String translation;
        try {
            translation = morseService.getTranslation(code);
        } catch (NotValidMorseCodeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new MorseResponse(code, translation), HttpStatus.OK);
    }

    @GetMapping("/encrypt/{text}")
    public ResponseEntity<MorseResponse> getEncryption(@PathVariable String text){
        String encryption;
        try {
            encryption = morseService.getEncryption(text);
        } catch (NotValidTextException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new MorseResponse(text, encryption), HttpStatus.OK);
    }

}
