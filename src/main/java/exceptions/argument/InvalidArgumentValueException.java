package exceptions.argument;

public class InvalidArgumentValueException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Value must be a positive number";

    public InvalidArgumentValueException() {
        super(ActiveLanguage.language == ActiveLanguage.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
