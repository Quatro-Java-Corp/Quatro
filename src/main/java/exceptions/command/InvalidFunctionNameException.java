package exceptions.command;

import utils.Dictionary;

public class InvalidFunctionNameException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Unknown function";
    private static final String MESS_PL = "Nieznana funkcja";

    public InvalidFunctionNameException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
