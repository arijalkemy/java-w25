package bootcamp.introaspringp2vivo;

import bootcamp.introaspringp2vivo.service.IMorseService;
import bootcamp.introaspringp2vivo.service.MorseServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MorseServiceTest {

    private final IMorseService morseService = new MorseServiceImp();

    @Test
    public void testTranslation() {
        Assertions.assertEquals("HOLA", morseService.getTranslation(".... --- .-.. .-"));
        Assertions.assertEquals("MERCADO LIBRE", morseService.getTranslation("-- . .-. -.-. .- -.. ---   .-.. .. -... .-. ."));
        Assertions.assertEquals("SPRING", morseService.getTranslation("... .--. .-. .. -. --."));
    }

    @Test
    public void testEncryption() {
        Assertions.assertEquals(".... --- .-.. .-", morseService.getEncryption("HOLA"));
        Assertions.assertEquals("-- . .-. -.-. .- -.. ---   .-.. .. -... .-. .", morseService.getEncryption("MERCADO LIBRE"));
        Assertions.assertEquals("... .--. .-. .. -. --.", morseService.getEncryption("SPRING"));
    }

}
