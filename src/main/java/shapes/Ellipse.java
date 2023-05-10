package shapes;

import java.util.Optional;

import exceptions.argument.NegativeArgumentValueException;
import utils.Format;

import static java.lang.Math.*;

public class Ellipse implements Shape {

    private final double semiMinorAxis;
    private final double semiMajorAxis;

    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    @Override
    public double getSurfaceArea() {
        return PI * semiMinorAxis * semiMajorAxis;
    }

    @Override
    public double getCircuit() {
        return PI * ((3 * (semiMajorAxis + semiMinorAxis) / 2) - sqrt(semiMajorAxis * semiMinorAxis));
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withRadius(semiMajorAxis));
    }

    @Override
    public Ellipse getDoubledSized() {
        double doubledSemiMinorAxis = semiMinorAxis * sqrt(2);
        double doubledSemiMajorAxis = semiMajorAxis * sqrt(2);
        return new Ellipse(doubledSemiMinorAxis, doubledSemiMajorAxis);
    }

    private Ellipse(double semiMinorAxis, double semiMajorAxis) {
        if (semiMinorAxis > semiMajorAxis) {
            this.semiMinorAxis = semiMajorAxis;
            this.semiMajorAxis = semiMinorAxis;
        } else {
            this.semiMinorAxis = semiMinorAxis;
            this.semiMajorAxis = semiMajorAxis;
        }
    }

    public static Ellipse withAxes(double semiMinorAxis, double semiMajorAxis) {
        if (semiMinorAxis <= 0 || semiMajorAxis <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Ellipse(semiMinorAxis, semiMajorAxis);
    }

    public static Ellipse withSemiMinorAxisAndSurfaceArea(double semiMinorAxis, double surfaceArea) {
        if (semiMinorAxis <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        double semiMajorAxis = surfaceArea / (PI * semiMinorAxis);
        return new Ellipse(semiMinorAxis, semiMajorAxis);
    }

    public static Ellipse withSemiMajorAxisAndSurfaceArea(double semiMajorAxis, double surfaceArea) {
        if (semiMajorAxis <= 0 || surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        double semiMinorAxis = surfaceArea / (PI * semiMajorAxis);
        return new Ellipse(semiMinorAxis, semiMajorAxis);
    }

    @Override
    public String toString() {
        return "Ellipse{" +
                "semiMinorAxis=" + Format.format(semiMinorAxis) +
                ", semiMajorAxis=" + Format.format(semiMajorAxis) +
                ", surfaceArea=" + Format.format(getSurfaceArea()) +
                '}';
    }
}
