package shapes;

import java.util.Optional;

import exceptions.NegativeArgumentValueException;
import utilities.Format;

import static java.lang.Math.*;

public class Rhombus implements Shape {

    private final double shortDiagonalLength;
    private final double longDiagonalLength;

    public double getShortDiagonalLength() {
        return shortDiagonalLength;
    }

    public double getLongDiagonalLength() {
        return longDiagonalLength;
    }

    public double getSideLength() {
        return sqrt(pow(shortDiagonalLength, 2) + pow(longDiagonalLength, 2)) / 2;
    }

    @Override
    public double getSurfaceArea() {
        return shortDiagonalLength * longDiagonalLength / 2;
    }

    @Override
    public double getCircuit() {
        return 4 * getSideLength();
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.empty();
    }

    @Override
    public Rhombus getDoubledSized() {
        return withShortDiagonalAndSurfaceArea(sqrt(2.0) * shortDiagonalLength, 2 * getSurfaceArea());
    }

    private Rhombus(double shortDiagonalLength, double longDiagonalLength) {
        if (shortDiagonalLength > longDiagonalLength) {
            this.shortDiagonalLength = longDiagonalLength;
            this.longDiagonalLength = shortDiagonalLength;
        } else {
            this.shortDiagonalLength = shortDiagonalLength;
            this.longDiagonalLength = longDiagonalLength;
        }
    }

    public static Rhombus withShortDiagonalAndLongDiagonal(double shortDiagonalLength, double longDiagonalLength) {
        if (shortDiagonalLength <= 0 || longDiagonalLength <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Rhombus(shortDiagonalLength, longDiagonalLength);
    }

    public static Rhombus withShortDiagonalAndSide(double shortDiagonalLength, double sideLength) {
        if (shortDiagonalLength <= 0 || sideLength <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Rhombus(shortDiagonalLength, sqrt(4 * pow(sideLength, 2) - pow(shortDiagonalLength, 2)));
    }

    public static Rhombus withShortDiagonalAndSurfaceArea(double shortDiagonalLength, double surfaceArea) {
        if (shortDiagonalLength <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Rhombus(shortDiagonalLength, 2 * surfaceArea / shortDiagonalLength);
    }

    public static Rhombus withLongDiagonalAndSide(double longDiagonalLength, double sideLength) {
        if (longDiagonalLength <= 0 || sideLength <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Rhombus(sqrt(4 * pow(sideLength, 2) - pow(longDiagonalLength, 2)), longDiagonalLength);
    }

    public static Rhombus withLongDiagonalAndSurfaceArea(double longDiagonalLength, double surfaceArea) {
        if (longDiagonalLength <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Rhombus(2 * surfaceArea / longDiagonalLength, longDiagonalLength);
    }

    public static Rhombus withSideLengthAndSurfaceArea(double sideLength, double surfaceArea) {
        if (sideLength <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        double cos = sqrt(1 - pow(surfaceArea / pow(sideLength, 2), 2));
        return new Rhombus(sideLength * sqrt(2 - 2 * cos), sideLength * sqrt(2 + 2 * cos));
    }

    @Override
    public String toString() {
        return "Rhombus{" +
                "sideLength=" + Format.format(getSideLength()) +
                ", shortDiagonalLength=" + Format.format(shortDiagonalLength) +
                ", longDiagonalLength=" + Format.format(longDiagonalLength) +
                ", surfaceArea=" + Format.format(getSurfaceArea()) +
                '}';
    }
}
