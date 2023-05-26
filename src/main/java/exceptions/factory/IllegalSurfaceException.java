package exceptions.factory;

import utils.ActiveLanguage;

public class IllegalSurfaceException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Surface area is to big for this side length";
    private static final String MESS_PL = "Pole powierzchni jest za duże dla tej długości boku";

    public IllegalSurfaceException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
