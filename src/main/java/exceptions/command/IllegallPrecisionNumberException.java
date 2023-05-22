package exceptions.command;

public class IllegallPrecisionNumberException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "The precision function should get non-negative integer as an argument";

    public IllegallPrecisionNumberException() {
        super(MESS_ENG);
    }
}
