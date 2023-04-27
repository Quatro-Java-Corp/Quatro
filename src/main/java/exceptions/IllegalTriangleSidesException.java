package exceptions;

public class IllegalTriangleSidesException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "2*side length must be bigger than base length";

    public IllegalTriangleSidesException() {
        super(MESS_ENG);
    }
}
