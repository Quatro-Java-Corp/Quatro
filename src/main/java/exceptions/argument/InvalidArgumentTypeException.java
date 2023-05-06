package exceptions.argument;

public class InvalidArgumentTypeException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Invalid argument type";

    public InvalidArgumentTypeException() {
        super(MESS_ENG);
    }
}
