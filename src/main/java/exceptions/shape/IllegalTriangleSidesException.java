package exceptions.shape;

import utils.Dictionary;

public class IllegalTriangleSidesException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Illegal triangle sides";
    private static final String MESS_PL = "Niedozwolone boki trójkąta";

    public IllegalTriangleSidesException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
