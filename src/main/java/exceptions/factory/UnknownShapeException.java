package exceptions.factory;

import utils.ActiveLanguage;

public class UnknownShapeException
        extends IllegalArgumentException {

    private static final String MESS_ENG = " is not avaliable shape";
    private static final String MESS_PL = " nie jest dostępnym kształtem";

    public UnknownShapeException(String shapeName) {
        super(Character.toUpperCase(shapeName.charAt(0))
                + shapeName.substring(1)
                + (ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL));
    }
}
