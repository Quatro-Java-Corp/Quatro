package exceptions.shape;

import utils.ActiveLanguage;

public class InvalidShapeForCircumscribedCircleException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "No circumscribed circle for this shape";
    private static final String MESS_PL = "Brak okręgu opisanego dla tego kształtu";

    public InvalidShapeForCircumscribedCircleException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
