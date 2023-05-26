package exceptions.argument;

import utils.ActiveLanguage;

public class RedundantArgumentException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "This function don't need any arguments";
    private static final String MESS_PL = "Ta funkcja nie potrzebuje żadnych argumentów";

    public RedundantArgumentException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
