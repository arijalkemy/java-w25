package org.example.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class morseCodeController {
    @GetMapping("encode/{message}")
    public String encode(@PathVariable MorseDtoCommonMessage message){
        return MorseHelper.encode(message.message());
    }
    @GetMapping("decode/{message}")
    public String decode(@PathVariable MorseDtoCommonMessage message){
        return MorseHelper.decode(message.message());
    }
}
