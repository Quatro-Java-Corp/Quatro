package exceptions.shape;

import utils.Dictionary;

public class InvalidShapeForCircumscribedCircleException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "No circumscribed circle for this shape";
    private static final String MESS_PL = "Brak okręgu opisanego dla tego kształtu";

    public InvalidShapeForCircumscribedCircleException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
