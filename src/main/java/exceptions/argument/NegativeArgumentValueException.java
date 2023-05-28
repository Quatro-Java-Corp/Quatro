package exceptions.argument;

import utils.Dictionary;

public class NegativeArgumentValueException
        extends IllegalArgumentException {

    private static final String MESS_ENG = "Values must be non-negative";
    private static final String MESS_PL = "Wartości nie mogą być ujemne";

    public NegativeArgumentValueException() {
        super(Dictionary.activeLanguage == Dictionary.Language.ENG ? MESS_ENG : MESS_PL);
    }
}
