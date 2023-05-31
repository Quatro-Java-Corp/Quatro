package exceptions.shape;

import utils.Dictionary;

public class DuplicatedShapeException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Duplicated shape";
    private static final String MESS_PL = "Zduplikowany kształt";

    public DuplicatedShapeException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
