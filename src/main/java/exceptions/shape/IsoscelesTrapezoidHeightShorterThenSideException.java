package exceptions.shape;

import utils.Dictionary;

public class IsoscelesTrapezoidHeightShorterThenSideException extends IllegalArgumentException {

    private static final String MESS_ENG = "Side can't be shorter or equal then height";
    private static final String MESS_PL = "Bok nie może być krótszy ani równy wysokości";

    public IsoscelesTrapezoidHeightShorterThenSideException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
