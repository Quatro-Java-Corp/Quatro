package exceptions;

public class InvalidArgumentValueException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Value must be a positive number";

    public InvalidArgumentValueException() {
        super(MESS_ENG);
    }
}
