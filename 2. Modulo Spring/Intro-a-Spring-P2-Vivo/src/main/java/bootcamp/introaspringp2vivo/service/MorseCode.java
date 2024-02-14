package bootcamp.introaspringp2vivo.service;

public enum MorseCode {
    A(".-"), B("-..."), C("-.-."), D("-.."), E("."), F("..-."), G("--."), H("...."), I(".."), J(".---"),
    K("-.-"), L(".-.."), M("--"), N("-."), O("---"), P(".--."), Q("--.-"), R(".-."), S("..."), T("-"),
    U("..-"), V("...-"), W(".--"), X("-..-"), Y("-.--"), Z("--.."),
    CERO("-----"),UNO(".----"), DOS("..---"),TRES("...--"), CUATRO("....-"), CINCO("....."),
    SEIS("-...."), SIETE("--..."), OCHO("---.."), NUEVE("----."),
    PUNTO(".-.-.-"), COMA("--..--"), PREGUNTA("..--.."), EXCLAMACION("-.-.--"), BARRA("-..-."),
    ARROBA(".--.-."), ESPACIO(" ");

    private String morseCode;

    MorseCode(String morseCode) {
        this.morseCode = morseCode;
    }

    public String getMorseCode() {
        return morseCode;
    }
}
