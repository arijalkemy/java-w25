package org.example.morse.service.impl;

import org.example.morse.dto.ResponseDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MorseServiceTest {

    private final MorseService morseService = new MorseService();


    @Test
    public void convertMorseToWordsOneWordTest(){
        //Arrange
        String morseCode = ".... --- .-.. .-";
        ResponseDto responseDtoExpected = new ResponseDto("HOLA");

        //Act
        ResponseDto result = this.morseService.convertMorseToWords(morseCode);

        //Assert

        assertEquals(responseDtoExpected, result);

    }

    @Test
    public void convertMorseToWordsMoreOneWordTest(){
        //Arrange
        String morseCode = ".... --- .-.. .-   -- ..- -. -.. ---";
        ResponseDto responseDtoExpected = new ResponseDto("HOLA MUNDO");

        //Act
        ResponseDto result = this.morseService.convertMorseToWords(morseCode);

        //Assert
        assertEquals(responseDtoExpected, result);
    }

    @Test
    public void convertWordsToMorseOneWordTest(){
        //Arrange
        String word = "HOLA";
        ResponseDto responseDtoExpected = new ResponseDto(".... --- .-.. .-");

        //Act
        ResponseDto result = this.morseService.convertWordsToMorse(word);

        //Assert
        assertEquals(responseDtoExpected, result);
    }

    @Test
    public void convertWordsToMorseMoreOneWordTest(){
        //Arrange
        String word = "HOLA MUNDO";
        ResponseDto responseDtoExpected = new ResponseDto(".... --- .-.. .-    -- ..- -. -.. ---");

        //Act
        ResponseDto result = this.morseService.convertWordsToMorse(word);

        //Assert
        assertEquals(responseDtoExpected, result);
    }
}