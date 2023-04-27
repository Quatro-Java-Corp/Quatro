package utilities;

import java.text.DecimalFormat;

public class Format {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static StringBuffer format(Double d) {
        return df.format(d, null, null);
    }
}
