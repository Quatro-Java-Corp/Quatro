package exceptions.argument;

import utils.ActiveLanguage;

public class OddArgumentsException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Odd number of arguments";
    private static final String MESS_PL = "Nieparzysta liczba argumentów";

    public OddArgumentsException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
