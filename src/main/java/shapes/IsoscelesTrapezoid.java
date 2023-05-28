package shapes;

import exceptions.argument.NegativeArgumentValueException;
import exceptions.shape.IsoscelesTrapezoidHeightShorterThenSideException;
import exceptions.shape.IsoscelesTrapezoidTooShortBaseException;
import utils.Format;

import java.util.Optional;

import static java.lang.Math.*;

public class IsoscelesTrapezoid implements Shape {
    private final double shortBaseLength;
    private final double longBaseLength;
    private final double height;

    public IsoscelesTrapezoid(double shortBaseLength, double longBaseLength, double height) {
        if (shortBaseLength <= 0 || longBaseLength <= 0 || height <= 0) {
            throw new NegativeArgumentValueException();
        }
        if (shortBaseLength > longBaseLength) {
            this.shortBaseLength = longBaseLength;
            this.longBaseLength = shortBaseLength;
        } else {
            this.shortBaseLength = shortBaseLength;
            this.longBaseLength = longBaseLength;
        }
        this.height = height;
    }

    public static IsoscelesTrapezoid withTwoBaseAndSide(double shortBaseLength, double longBaseLength,
            double sideLength) {
        if (shortBaseLength <= 0 || longBaseLength <= 0 || sideLength <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new IsoscelesTrapezoid(shortBaseLength, longBaseLength,
                sqrt(pow(sideLength, 2) - pow((longBaseLength - shortBaseLength) / 2, 2)));
    }

    public static IsoscelesTrapezoid withTwoBaseAndHeight(double shortBaseLength, double longBaseLength,
            double height) {
        if (shortBaseLength <= 0 || longBaseLength <= 0 || height <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new IsoscelesTrapezoid(shortBaseLength, longBaseLength, height);
    }

    public static IsoscelesTrapezoid withTwoBaseAndArea(double shortBaseLength, double longBaseLength,
            double surfaceArea) {
        if (shortBaseLength <= 0 || longBaseLength <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new IsoscelesTrapezoid(shortBaseLength, longBaseLength,
                surfaceArea / ((longBaseLength + shortBaseLength) / 2));
    }

    public static IsoscelesTrapezoid withShortBaseAndSideAndHeight(double shortBaseLength, double sideLength,
            double height) {
        if (shortBaseLength <= 0 || sideLength <= 0 || height <= 0) {
            throw new NegativeArgumentValueException();
        }
        if (sideLength <= height) {
            throw new IsoscelesTrapezoidHeightShorterThenSideException();
        }
        return new IsoscelesTrapezoid(shortBaseLength, shortBaseLength + 2 * sqrt(pow(sideLength, 2) - pow(height, 2)),
                height);
    }

    public static IsoscelesTrapezoid withLongBaseAndSideAndHeight(double longBaseLength, double sideLength,
            double height) {
        if (longBaseLength <= 0 || sideLength <= 0 || height <= 0) {
            throw new NegativeArgumentValueException();
        }
        if (sideLength <= height) {
            throw new IsoscelesTrapezoidHeightShorterThenSideException();
        }
        if (longBaseLength <= 2 * sqrt(pow(sideLength, 2) - pow(height, 2))) {
            throw new IsoscelesTrapezoidTooShortBaseException();
        }
        return new IsoscelesTrapezoid(longBaseLength - 2 * sqrt(pow(sideLength, 2) - pow(height, 2)), longBaseLength,
                height);
    }

    public static IsoscelesTrapezoid withBaseAndHeightAndArea(double BaseLength, double height, double surfaceArea) {
        if (BaseLength <= 0 || height <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new IsoscelesTrapezoid(BaseLength, (surfaceArea / height * 2) - BaseLength, height);
    }

    public static IsoscelesTrapezoid withSideAndHeightAndArea(double sideLength, double height, double surfaceArea) {
        if (sideLength <= 0 || height <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        if (sideLength <= height) {
            throw new IsoscelesTrapezoidHeightShorterThenSideException();
        }
        double x = sqrt(pow(sideLength, 2) - pow(height, 2));
        return new IsoscelesTrapezoid(surfaceArea / height - x, surfaceArea / height + x, height);
    }

    @Override
    public double getSurfaceArea() {
        return (shortBaseLength + longBaseLength) / 2 * height;
    }

    public double getSide() {
        return sqrt(pow((longBaseLength - shortBaseLength) / 2, 2) + pow(height, 2));
    }

    @Override
    public double getCircuit() {
        return shortBaseLength + longBaseLength + 2 * getSide();
    }

    public double getShortBaseLength() {
        return shortBaseLength;
    }

    public double getLongBaseLength() {
        return longBaseLength;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withRadius(
                getSide() * sqrt((shortBaseLength * longBaseLength + pow(getSide(), 2))
                        / (4 * pow(getSide(), 2) - pow(longBaseLength - shortBaseLength, 2)))));
    }

    @Override
    public Shape getDoubledSized() {
        return new IsoscelesTrapezoid(shortBaseLength * sqrt(2), longBaseLength * sqrt(2), height * sqrt(2));
    }

    @Override
    public int getVertexCount() {
        return 4;
    }

    @Override
    public String toString() {
        return "IsoscelesTrapezoid{" +
                Format.parameterToString("shortbase", shortBaseLength) + ", " +
                Format.parameterToString("longbase", longBaseLength) + ", " +
                Format.parameterToString("height", getHeight()) + ", " +
                Format.parameterToString("side", getSide()) + ", " +
                Format.parameterToString("area", getSurfaceArea()) +
                '}';
    }
}
