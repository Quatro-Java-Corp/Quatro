package exceptions.argument;

public class OddArgumentsException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Odd number of arguments";

    public OddArgumentsException() {
        super(MESS_ENG);
    }
}
