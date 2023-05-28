package exceptions.factory;

import utils.Dictionary;

public class UnknownNameException
        extends IllegalArgumentException {

    private static final String MESS_ENG = " is not avaliable word";
    private static final String MESS_PL = " nie jest dostępnym słowem";

    public UnknownNameException(String word) {
        super(word + (Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL));
    }
}
