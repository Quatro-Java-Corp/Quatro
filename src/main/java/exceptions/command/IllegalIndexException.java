package exceptions.command;

import utils.Dictionary;

public class IllegalIndexException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Illegal index";
    private static final String MESS_PL = "Nielegalny indeks";

    public IllegalIndexException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
