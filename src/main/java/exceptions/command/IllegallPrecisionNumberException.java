package exceptions.command;

import utils.ActiveLanguage;

public class IllegallPrecisionNumberException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "The precision function should get non-negative integer as an argument";
    private static final String MESS_PL = "Funkcja precyzji powinna otrzymać jako argument nieujemną liczbę całkowitą";

    public IllegallPrecisionNumberException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
