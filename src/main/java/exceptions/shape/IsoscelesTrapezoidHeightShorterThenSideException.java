package exceptions.shape;

public class IsoscelesTrapezoidHeightShorterThenSideException extends IllegalArgumentException {
    private static final String MESS_ENG = "Side can't be shorter or equal then height";

    public IsoscelesTrapezoidHeightShorterThenSideException() {
        super(MESS_ENG);
    }
}
