package exceptions.factory;

import utils.ActiveLanguage;

public class UnknownShapeException
        extends IllegalArgumentException {

    private static final String MESS_ENG = " is not avaliable shape";
    private static final String MESS_PL = " nie jest dostępnym kształtem";

    public UnknownShapeException(String shapeName) {
        super(shapeName.substring(0, 1).toUpperCase()
                + shapeName.substring(1)
                + (ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL));
    }
}
