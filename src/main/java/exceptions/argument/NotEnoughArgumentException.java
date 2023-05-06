package exceptions.argument;

public class NotEnoughArgumentException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Not enough arguments";

    public NotEnoughArgumentException() {
        super(MESS_ENG);
    }
}
