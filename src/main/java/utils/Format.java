package utils;

import java.text.DecimalFormat;

import exceptions.command.IllegallPrecisionNumberException;

public class Format {

    private static final String basePattern = "0";
    private static final String doublePattern = "0.";

    private static DecimalFormat df = new DecimalFormat("0.00");

    public static String format(Double d) {
        return df.format(d);
    }

    public static void setPrecision(int k) {
        if (k < 0) {
            throw new IllegallPrecisionNumberException();
        }

        if (k == 0) {
            df = new DecimalFormat(basePattern);
        } else {
            df = new DecimalFormat(doublePattern + basePattern.repeat(k));
        }
    }
}
