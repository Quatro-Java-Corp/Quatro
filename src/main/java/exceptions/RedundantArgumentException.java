package exceptions;

public class RedundantArgumentException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "This function don't need any arguments";

    public RedundantArgumentException() {
        super(MESS_ENG);
    }
}
