package exceptions.factory;

import utils.ActiveLanguage;

public class InvalidArgumentsNumberException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Invalid number of arguments for ";
    private static final String MESS_PL = "Nieprawidłowa liczba argumentów dla ";

    public InvalidArgumentsNumberException(String shapeName) {
        super((ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL) + shapeName);
    }
}
