package exceptions.command;

import utils.ActiveLanguage;

public class InvalidFunctionNameException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Unknown function";
    private static final String MESS_PL = "Nieznana funkcja";

    public InvalidFunctionNameException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
