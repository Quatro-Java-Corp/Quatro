package exceptions;

public class NegativeArgumentValueException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Values must be non-negative";

    public NegativeArgumentValueException() {
        super(MESS_ENG);
    }
}
