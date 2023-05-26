package exceptions.argument;

import utils.ActiveLanguage;

public class InvalidArgumentTypeException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Invalid argument type";
    private static final String MESS_PL = "Nieprawidłowy typ argumentu";

    public InvalidArgumentTypeException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
