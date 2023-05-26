package exceptions.argument;

import utils.ActiveLanguage;

public class InvalidArgumentValueException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Value must be a positive number";
    private static final String MESS_PL = "Wartość musi być liczbą dodatnią";

    public InvalidArgumentValueException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
