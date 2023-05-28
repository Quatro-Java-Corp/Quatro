package exceptions.argument;

import utils.Dictionary;

public class OddArgumentsException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Odd number of arguments";
    private static final String MESS_PL = "Nieparzysta liczba argumentów";

    public OddArgumentsException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
