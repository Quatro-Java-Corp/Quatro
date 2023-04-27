package exceptions;

public class IllegalSortArgumentException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Wrong sort arguments";

    public IllegalSortArgumentException() {
        super(MESS_ENG);
    }
}
