package exceptions.command;

import utils.Dictionary;

public class IllegalSortArgumentException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Wrong sort arguments";
    private static final String MESS_PL = "Błędne argumenty sortowania";

    public IllegalSortArgumentException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
