package exceptions.argument;

import utils.ActiveLanguage;

public class NotEnoughArgumentException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Not enough arguments";
    private static final String MESS_PL = "Za mało argumentów";

    public NotEnoughArgumentException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
