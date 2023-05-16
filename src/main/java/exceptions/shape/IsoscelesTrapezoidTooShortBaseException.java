package exceptions.shape;

public class IsoscelesTrapezoidTooShortBaseException extends IllegalArgumentException {
    private static final String MESS_ENG = "Base is too short for other arguments";

    public IsoscelesTrapezoidTooShortBaseException() {
        super(MESS_ENG);
    }
}
