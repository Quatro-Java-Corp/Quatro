package exceptions.command;

import utils.ActiveLanguage;

public class IllegalSortArgumentException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Wrong sort arguments";
    private static final String MESS_PL = "Błędne argumenty sortowania";

    public IllegalSortArgumentException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
