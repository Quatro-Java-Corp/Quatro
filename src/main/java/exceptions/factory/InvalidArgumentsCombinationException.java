package exceptions.factory;

import utils.Dictionary;

public class InvalidArgumentsCombinationException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Invalid combination of arguments for ";
    private static final String MESS_PL = "Nieprawidłowa kombinacja argumentów dla ";

    public InvalidArgumentsCombinationException(String shapeName) {
        super((Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL) + shapeName);
    }
}
