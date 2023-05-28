package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DictionaryTest {

    private final String ENG_WORD = "semimajoraxis";
    private final String PL_WORD = "półoświelka";

    /**
     * Translate to ENG
     */
    @Test
    public void shouldTranslateToENG() {
        Dictionary.activeLanguage = Dictionary.Language.PL;
        assertEquals(ENG_WORD, Dictionary.toENG(PL_WORD));
        Dictionary.activeLanguage = Dictionary.Language.ENG;
    }

    /**
     * Translate from ENG
     */
    @Test
    public void shouldTranslateToPL() {
        Dictionary.activeLanguage = Dictionary.Language.PL;
        assertEquals(PL_WORD, Dictionary.fromENG(ENG_WORD));
        Dictionary.activeLanguage = Dictionary.Language.ENG;
    }
}
