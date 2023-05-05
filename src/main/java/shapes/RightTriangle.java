package shapes;

import java.util.Optional;

import static java.lang.Math.*;

public class RightTriangle implements Shape {

    private final double shortCathetusLength;
    private final double longCathetusLength;

    public double getShortCathetusLength() {
        return shortCathetusLength;
    }

    public double getLongCathetusLength() {
        return longCathetusLength;
    }

    public double getHeight() {
        return getSurfaceArea() / getHypotenuse() * 2.0;
    }

    public double getHypotenuse() {
        return sqrt(pow(shortCathetusLength, 2) + pow(longCathetusLength, 2));
    }

    @Override
    public double getSurfaceArea() {
        return shortCathetusLength * longCathetusLength / 2.0;
    }

    @Override
    public double getCircuit() {
        return shortCathetusLength + longCathetusLength + getHypotenuse();
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withRadius(getHypotenuse() / 2));
    }

    @Override
    public RightTriangle getDoubledSized() {
        return withCathetusAndSurfaceArea(sqrt(2.0) * shortCathetusLength, 2 * getSurfaceArea());
    }

    private RightTriangle(double shortCathetusLength, double longCathetusLength) {
        if ((2 * shortCathetusLength) <= longCathetusLength) {
            throw new IllegalArgumentException("Cathetus length should be bigger 2 times than base length");
        }
        if (shortCathetusLength > longCathetusLength) {
            this.shortCathetusLength = longCathetusLength;
            this.longCathetusLength = shortCathetusLength;
        } else {
            this.shortCathetusLength = shortCathetusLength;
            this.longCathetusLength = longCathetusLength;
        }
    }

    public static RightTriangle withCatheti(double firstCathetusLength, double secondCathetusLength) {
        if (firstCathetusLength <= 0 || secondCathetusLength <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new RightTriangle(firstCathetusLength, secondCathetusLength);
    }

    public static RightTriangle withCathetusAndHypotenuse(double cathetusLength, double hypotenuseLength) {
        if (cathetusLength <= 0 || hypotenuseLength <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new RightTriangle(cathetusLength, sqrt(pow(hypotenuseLength, 2) - pow(cathetusLength, 2)));
    }

    public static RightTriangle withHypotenuseAndSurfaceArea(double hypotenuseLength, double surfaceArea) {
        if (hypotenuseLength <= 0 || surfaceArea <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        double val = sqrt(sqrt(pow(hypotenuseLength, 4) - 4 * pow(surfaceArea * 2, 2)) + pow(hypotenuseLength, 2));
        return new RightTriangle(abs(sqrt(2) * surfaceArea * 2 / val), abs(val / sqrt(2)));
    }

    public static RightTriangle withCathetusAndSurfaceArea(double cathetusLength, double surfaceArea) {
        if (cathetusLength <= 0 || surfaceArea <= 0) {
            throw new IllegalArgumentException("Values must be non-negative");
        }
        return new RightTriangle(cathetusLength, surfaceArea / cathetusLength * 2);
    }

    @Override
    public String toString() {
        return "RightTriangle{" +
                "shortCathetusLength=" + shortCathetusLength +
                ", longCathetusLength=" + longCathetusLength +
                ", hypotenuseLength=" + getHypotenuse() +
                ", surfaceArea=" + getSurfaceArea() +
                ", height=" + getHeight() +
                '}';
    }
}
