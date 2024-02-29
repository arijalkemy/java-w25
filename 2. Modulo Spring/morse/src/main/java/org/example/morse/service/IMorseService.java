package org.example.morse.service;

import org.example.morse.dto.ResponseDto;

public interface IMorseService {
    public ResponseDto convertMorseToWords(String data);
    public ResponseDto convertWordsToMorse(String data);
}
