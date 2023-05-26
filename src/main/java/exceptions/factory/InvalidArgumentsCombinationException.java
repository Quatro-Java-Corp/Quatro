package exceptions.factory;

import utils.ActiveLanguage;

public class InvalidArgumentsCombinationException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Invalid combination of arguments for ";
    private static final String MESS_PL = "Nieprawidłowa kombinacja argumentów dla ";

    public InvalidArgumentsCombinationException(String shapeName) {
        super((ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL) + shapeName);
    }
}
