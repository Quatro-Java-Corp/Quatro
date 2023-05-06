package exceptions.factory;

public class InvalidArgumentsCombinationException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Invalid combination of arguments for ";

    public InvalidArgumentsCombinationException(String shapeName) {
        super(MESS_ENG + shapeName);
    }
}
