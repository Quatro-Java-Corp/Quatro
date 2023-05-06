package exceptions.factory;

public class IllegalSurfaceException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Surface area is to big for this side lenght";

    public IllegalSurfaceException() {
        super(MESS_ENG);
    }
}
