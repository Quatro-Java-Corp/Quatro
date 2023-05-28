package shapes;

import java.util.Optional;

import exceptions.argument.NegativeArgumentValueException;
import utils.Format;

import static java.lang.Math.pow;

public class RegularTriangle implements Shape {

    private final double sideLength;

    public double getSideLength() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength * pow(3, 0.5) / 2.0;
    }

    @Override
    public double getSurfaceArea() {
        return sideLength * sideLength * pow(3, 0.5) / 4.0;
    }

    @Override
    public double getCircuit() {
        return 3 * sideLength;
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withRadius(getHeight() * 2 / 3));
    }

    @Override
    public RegularTriangle getDoubledSized() {
        return withSurfaceArea(2 * getSurfaceArea());
    }

    @Override
    public int getVertexCount() {
        return 3;
    }

    private RegularTriangle(double sideLength) {
        this.sideLength = sideLength;
    }

    public static RegularTriangle withSide(double side) {
        if (side <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new RegularTriangle(side);
    }

    public static RegularTriangle withHeight(double height) {
        if (height <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new RegularTriangle(height * 2 / pow(3, 0.5));
    }

    public static RegularTriangle withSurfaceArea(double surfaceArea) {
        if (surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new RegularTriangle(pow(surfaceArea * 4 / pow(3, 0.5), 0.5));
    }

    @Override
    public String toString() {
        return "RegularTriangle{" +
                Format.parameterToString("side", sideLength) + ", " +
                Format.parameterToString("height", getHeight()) + ", " +
                Format.parameterToString("area", getSurfaceArea()) +
                '}';
    }
}
