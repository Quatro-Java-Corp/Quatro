package exceptions.shape;

public class DuplicatedShapeException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Duplicated shape";

    public DuplicatedShapeException() {
        super(MESS_ENG);
    }
}
