package exceptions.factory;

public class InvalidArgumentsNumberException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Invalid number of arguments for ";

    public InvalidArgumentsNumberException(String shapeName) {
        super(MESS_ENG + shapeName);
    }
}
