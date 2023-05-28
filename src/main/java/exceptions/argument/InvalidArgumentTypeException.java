package exceptions.argument;

import utils.Dictionary;

public class InvalidArgumentTypeException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Invalid argument type";
    private static final String MESS_PL = "Nieprawidłowy typ argumentu";

    public InvalidArgumentTypeException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
