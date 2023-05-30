package shapes;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.Objects;
import java.util.Optional;

import exceptions.argument.NegativeArgumentValueException;
import utils.CompareDouble;
import utils.Format;

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

    @Override
    public Rectangle getDoubledSized() {
        return withShortSideAndSurfaceArea(sqrt(2.0) * shortSideLength, 2 * getSurfaceArea());
    }

    @Override
    public int getVertexCount() {
        return 4;
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
            throw new NegativeArgumentValueException();
        }
        return new Rectangle(shortSideLength, longSideLength);
    }

    public static Rectangle withShortSideAndDiagonal(double shortSideLength, double diagonalLength) {
        if (shortSideLength <= 0 || diagonalLength <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Rectangle(shortSideLength, sqrt(pow(diagonalLength, 2) - pow(shortSideLength, 2)));
    }

    public static Rectangle withShortSideAndSurfaceArea(double shortSideLength, double surfaceArea) {
        if (shortSideLength <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Rectangle(shortSideLength, surfaceArea / shortSideLength);
    }

    public static Rectangle withLongSideAndDiagonal(double longSideLength, double diagonalLength) {
        if (longSideLength <= 0 || diagonalLength <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Rectangle(sqrt(pow(diagonalLength, 2) - pow(longSideLength, 2)), longSideLength);
    }

    public static Rectangle withLongSideAndSurfaceArea(double longSideLength, double surfaceArea) {
        if (longSideLength <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Rectangle(surfaceArea / longSideLength, longSideLength);
    }

    public static Rectangle withDiagonalAndSurfaceArea(double diagonalLength, double surfaceArea) {
        if (diagonalLength <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        double val = sqrt(sqrt(pow(diagonalLength, 4) - 4 * pow(surfaceArea, 2)) + pow(diagonalLength, 2));
        return new Rectangle(abs(sqrt(2) * surfaceArea / val), abs(val / sqrt(2)));
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                Format.parameterToString("shortside", shortSideLength) + ", " +
                Format.parameterToString("longside", longSideLength) + ", " +
                Format.parameterToString("diagonal", getDiagonalLength()) + ", " +
                Format.parameterToString("area", getSurfaceArea()) + ", " +
                Format.parameterToString("circut", getCircuit()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return CompareDouble.doubleEquals(rectangle.shortSideLength, shortSideLength) && CompareDouble.doubleEquals(rectangle.longSideLength, longSideLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortSideLength, longSideLength);
    }
}
