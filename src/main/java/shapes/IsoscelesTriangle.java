package shapes;

import java.util.Optional;

import exceptions.IllegalSurfaceException;
import exceptions.IllegalTriangleSidesException;
import exceptions.NegativeArgumentValueException;
import utils.Format;

import static java.lang.Math.*;

public class IsoscelesTriangle implements Shape {

    private final double sideLength;
    private final double baseLength;

    public double getSideLength() {
        return sideLength;
    }

    public double getBaseLength() {
        return baseLength;
    }

    public double getHeight() {
        return sqrt(pow(sideLength, 2) - (pow(baseLength, 2) / 4.0));
    }

    @Override
    public double getSurfaceArea() {
        return baseLength * getHeight() / 2.0;
    }

    @Override
    public double getCircuit() {
        return 2 * sideLength + baseLength;
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withRadius(sideLength * sideLength * baseLength / (4 * getSurfaceArea())));
    }

    @Override
    public IsoscelesTriangle getDoubledSized() {
        return withBaseAndSurfaceArea(sqrt(2.0) * baseLength, 2 * getSurfaceArea());
    }

    private IsoscelesTriangle(double sideLength, double baseLength) {
        if ((2 * sideLength) <= baseLength) {
            throw new IllegalTriangleSidesException();
        }
        this.sideLength = sideLength;
        this.baseLength = baseLength;
    }

    public static IsoscelesTriangle withSideAndBase(double sideLength, double baseLength) {
        if (sideLength <= 0 || baseLength <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new IsoscelesTriangle(sideLength, baseLength);
    }

    public static IsoscelesTriangle withSideAndSurfaceArea(double sideLength, double surfaceArea) {
        if (sideLength <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        double delta = pow(sideLength, 4) - 4 * pow(surfaceArea, 2);
        if (delta <= 0) {
            throw new IllegalSurfaceException();
        }
        return new IsoscelesTriangle(sideLength, sqrt(2.0 * pow(sideLength, 2) - 2.0 * sqrt(delta)));
    }

    public static IsoscelesTriangle withSideAndHeight(double sideLength, double height) {
        if (sideLength <= 0 || height <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new IsoscelesTriangle(sideLength, 2 * sqrt(pow(sideLength, 2) - pow(height, 2)));
    }

    public static IsoscelesTriangle withBaseAndSurfaceArea(double baseLength, double surfaceArea) {
        if (baseLength <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new IsoscelesTriangle(sqrt((4 * pow(surfaceArea, 2) / pow(baseLength, 2)) + (pow(baseLength, 2) / 4)), baseLength);
    }

    public static IsoscelesTriangle withBaseAndHeight(double baseLength, double height) {
        if (baseLength <= 0 || height <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new IsoscelesTriangle(sqrt((pow(baseLength, 2) / 4) + pow(height, 2)), baseLength);
    }

    public static IsoscelesTriangle withSurfaceAreaAndHeight(double surfaceArea, double height) {
        if (surfaceArea <= 0 || height <= 0) {
            throw new NegativeArgumentValueException();
        }
        double base = 2 * surfaceArea / height;
        return new IsoscelesTriangle(sqrt((pow(base, 2) / 4) + pow(height, 2)), base);
    }

    @Override
    public String toString() {
        return "IsoscelesTriangle{" +
                "sideLength=" + Format.format(sideLength) +
                ", baseLength=" + Format.format(baseLength) +
                ", surfaceArea=" + Format.format(getSurfaceArea()) +
                ", height=" + Format.format(getHeight()) +
                '}';
    }
}
