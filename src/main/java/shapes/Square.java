package shapes;

import java.util.Optional;

import exceptions.argument.NegativeArgumentValueException;
import utils.Format;

public final class Square implements Shape {

    private final double sideLength;

    @Override
    public double getSurfaceArea() {
        return sideLength * sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getDiagonalLength() {
        return sideLength * Math.pow(2, 0.5);
    }

    private Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getCircuit() {
        return 4 * sideLength;
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withDiameter(getDiagonalLength()));
    }

    @Override
    public Square getDoubledSized() {
        return withSurfaceArea(2 * getSurfaceArea());
    }

    @Override
    public int getVertexCount() {
        return 4;
    }

    public static Square withSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Square(sideLength);
    }

    public static Square withDiagonalLength(double diagonalLength) {
        if (diagonalLength <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Square(Math.pow(diagonalLength * diagonalLength / 2, 0.5));
    }

    public static Square withSurfaceArea(double surfaceArea) {
        if (surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Square(Math.pow(surfaceArea, 0.5));
    }

    @Override
    public String toString() {
        return "Square{" +
                Format.parameterToString("side", sideLength) + ", " +
                Format.parameterToString("diagonal", getDiagonalLength()) + ", " +
                Format.parameterToString("area", getSurfaceArea()) + ", " +
                Format.parameterToString("circut", getCircuit()) +
                '}';
    }
}
