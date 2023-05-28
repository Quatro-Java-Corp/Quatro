package exceptions.command;

import utils.Dictionary;

public class IllegallPrecisionNumberException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "The precision function should get non-negative integer as an argument";
    private static final String MESS_PL = "Funkcja precyzji powinna otrzymać jako argument nieujemną liczbę całkowitą";

    public IllegallPrecisionNumberException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
