package exceptions.factory;

public class UnknownShapeException
        extends IllegalArgumentException {

    private static final String MESS_ENG = " is not avaliable shape";

    public UnknownShapeException(String shapeName) {
        super(shapeName.substring(0, 1).toUpperCase() + shapeName.substring(1) + MESS_ENG);
    }
}
