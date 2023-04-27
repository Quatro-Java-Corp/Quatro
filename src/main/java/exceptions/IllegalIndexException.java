package exceptions;

public class IllegalIndexException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Illegal index";

    public IllegalIndexException() {
        super(MESS_ENG);
    }
}
