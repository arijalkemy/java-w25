package bootcamp.introaspringp2vivo.service;

import bootcamp.introaspringp2vivo.exception.NotValidMorseCodeException;
import bootcamp.introaspringp2vivo.exception.NotValidTextException;

public interface IMorseService {

    String getTranslation(String morseCode) throws NotValidMorseCodeException;

    String getEncryption(String text) throws NotValidTextException;

}
