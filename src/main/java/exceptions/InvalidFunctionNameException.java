package exceptions;

public class InvalidFunctionNameException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Unknown function";

    public InvalidFunctionNameException() {
        super(MESS_ENG);
    }
}
