package shapes;

import java.util.Optional;

import static java.lang.Math.*;

public class Rectangle implements Shape {

    private final double shortSideLength;
    private final double longSideLength;

    public double getShortSideLength() {
        return shortSideLength;
    }

    public double getLongSideLength() {
        return longSideLength;
    }

    public double getDiagonalLength() {
        return sqrt(pow(shortSideLength, 2) + pow(longSideLength, 2));
    }

    @Override
    public double getSurfaceArea() {
        return shortSideLength * longSideLength;
    }

    @Override
    public double getCircuit() {
        return 2 * shortSideLength + 2 * longSideLength;
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withDiameter(getDiagonalLength()));
    }

    private Rectangle(double shortSideLength, double longSideLength) {
        if (shortSideLength > longSideLength) {
            this.shortSideLength = longSideLength;
            this.longSideLength = shortSideLength;
        } else {
            this.shortSideLength = shortSideLength;
            this.longSideLength = longSideLength;
        }
    }

    public static Rectangle withShortSideAndLongSide(double shortSideLength, double longSideLength) {
        if (shortSideLength <= 0 || longSideLength <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new Rectangle(shortSideLength, longSideLength);
    }

    public static Rectangle withShortSideAndDiagonal(double shortSideLength, double diagonalLength) {
        if (shortSideLength <= 0 || diagonalLength <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new Rectangle(shortSideLength, sqrt(pow(diagonalLength, 2) - pow(shortSideLength, 2)));
    }

    public static Rectangle withShortSideAndSurfaceArea(double shortSideLength, double surfaceArea) {
        if (shortSideLength <= 0 || surfaceArea <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new Rectangle(shortSideLength, surfaceArea / shortSideLength);
    }

    public static Rectangle withLongSideAndDiagonal(double longSideLength, double diagonalLength) {
        if (longSideLength <= 0 || diagonalLength <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new Rectangle(sqrt(pow(diagonalLength, 2) - pow(longSideLength, 2)), longSideLength);
    }

    public static Rectangle withLongSideAndSurfaceArea(double longSideLength, double surfaceArea) {
        if (longSideLength <= 0 || surfaceArea <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new Rectangle(surfaceArea / longSideLength, longSideLength);
    }

    public static Rectangle withDiagonalAndSurfaceArea(double diagonalLength, double surfaceArea) {
        if (diagonalLength <= 0 || surfaceArea <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        double val = sqrt(sqrt(pow(diagonalLength, 4) - 4 * pow(surfaceArea, 2)) + pow(diagonalLength, 2));
        return new Rectangle(abs(sqrt(2) * surfaceArea / val), abs(val / sqrt(2)));
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "shortSideLength=" + shortSideLength +
                ", longSideLength=" + longSideLength +
                ", diagonalLength=" + getDiagonalLength() +
                ", surfaceArea=" + getSurfaceArea() +
                '}';
    }
}
