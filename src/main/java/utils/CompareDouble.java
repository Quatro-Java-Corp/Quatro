package utils;

import static java.lang.Math.abs;

public class CompareDouble {
    private static final double DELTA = 0.0001;

    public static boolean doubleEquals(double a, double b) {
        return abs(a - b) < DELTA;
    }
}
