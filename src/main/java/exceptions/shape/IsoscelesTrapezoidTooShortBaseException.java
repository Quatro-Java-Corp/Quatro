package exceptions.shape;

import utils.ActiveLanguage;

public class IsoscelesTrapezoidTooShortBaseException extends IllegalArgumentException {

    private static final String MESS_ENG = "Base is too short for other arguments";
    private static final String MESS_PL = "Podstawa jest za krótka dla innych argumentów";

    public IsoscelesTrapezoidTooShortBaseException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
