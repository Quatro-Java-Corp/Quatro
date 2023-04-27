package exceptions;

public class InvalidShapeForCircumscribedCircleException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "No circumscribed circle for this shape";

    public InvalidShapeForCircumscribedCircleException() {
        super(MESS_ENG);
    }
}
