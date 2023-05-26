package exceptions.argument;

public class NegativeArgumentValueException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Values must be non-negative";

    public NegativeArgumentValueException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
