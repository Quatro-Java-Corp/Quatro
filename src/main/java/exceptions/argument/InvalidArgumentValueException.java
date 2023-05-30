package exceptions.argument;

import utils.Dictionary;

public class InvalidArgumentValueException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Value must be a positive number";
    private static final String MESS_PL = "Wartość musi być liczbą dodatnią";

    public InvalidArgumentValueException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
