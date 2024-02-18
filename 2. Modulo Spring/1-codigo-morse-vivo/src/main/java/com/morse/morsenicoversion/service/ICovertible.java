package com.morse.morsenicoversion.service;

import java.util.Map;

public interface ICovertible {
    String morseToText(String morseCode);
    String  textToMorse(String text);
}
