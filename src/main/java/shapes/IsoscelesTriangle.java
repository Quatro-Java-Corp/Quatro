package shapes;

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

    private IsoscelesTriangle(double sideLength, double baseLength) {
        if ((2 * sideLength) <= baseLength) {
            throw new IllegalArgumentException("side length should be bigger 2 times than base length");
        }
        this.sideLength = sideLength;
        this.baseLength = baseLength;
    }

    public static IsoscelesTriangle withSideAndBase(double sideLength, double baseLength) {
        if (sideLength <= 0 || baseLength <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new IsoscelesTriangle(sideLength, baseLength);
    }

    public static IsoscelesTriangle withSideAndSurfaceArea(double sideLength, double surfaceArea) {
        if (sideLength <= 0 || surfaceArea <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        double delta = pow(sideLength, 4) - 4 * pow(surfaceArea, 2);
        if (delta <= 0) {
            throw new IllegalArgumentException("Surface area is to big for this side lenght");
        }
        return new IsoscelesTriangle(sideLength, sqrt(2.0 * pow(sideLength, 2) - 2.0 * sqrt(delta)));
    }

    public static IsoscelesTriangle withSideAndHeight(double sideLength, double height) {
        if (sideLength <= 0 || height <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new IsoscelesTriangle(sideLength, 2 * sqrt(pow(sideLength, 2) - pow(height, 2)));
    }

    public static IsoscelesTriangle withBaseAndSurfaceArea(double baseLength, double surfaceArea) {
        if (baseLength <= 0 || surfaceArea <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new IsoscelesTriangle(sqrt((4 * pow(surfaceArea, 2) / pow(baseLength, 2)) + (pow(baseLength, 2) / 4)), baseLength);
    }

    public static IsoscelesTriangle withBaseAndHeight(double baseLength, double height) {
        if (baseLength <= 0 || height <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new IsoscelesTriangle(sqrt((pow(baseLength, 2) / 4) + pow(height, 2)), baseLength);
    }

    public static IsoscelesTriangle withSurfaceAreaAndHeight(double surfaceArea, double height) {
        if (surfaceArea <= 0 || height <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        double base = 2 * surfaceArea / height;
        return new IsoscelesTriangle(sqrt((pow(base, 2) / 4) + pow(height, 2)), base);
    }

    @Override
    public String toString() {
        return "IsoscelesTriangle{" +
                "sideLength=" + sideLength +
                ", baseLength=" + baseLength +
                ", surfaceArea=" + getSurfaceArea() +
                ", height=" + getHeight() +
                '}';
    }
}
