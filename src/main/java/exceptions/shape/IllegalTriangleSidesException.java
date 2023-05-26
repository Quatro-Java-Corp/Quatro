package exceptions.shape;

import utils.ActiveLanguage;

public class IllegalTriangleSidesException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Illegal triangle sides";
    private static final String MESS_PL = "Niedozwolone boki trójkąta";

    public IllegalTriangleSidesException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
