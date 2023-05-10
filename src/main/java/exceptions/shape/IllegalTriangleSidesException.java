package exceptions.shape;

public class IllegalTriangleSidesException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Illegal triangle sides";

    public IllegalTriangleSidesException() {
        super(MESS_ENG);
    }
}
