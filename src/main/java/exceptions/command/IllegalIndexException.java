package exceptions.command;

import utils.ActiveLanguage;

public class IllegalIndexException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Illegal index";
    private static final String MESS_PL = "Nielegalny indeks";

    public IllegalIndexException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
