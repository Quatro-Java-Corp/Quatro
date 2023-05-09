package shapes;

import java.util.Optional;

import exceptions.argument.NegativeArgumentValueException;
import utils.Format;

public class Circle implements Shape {
    private final double radius;

    @Override
    public double getSurfaceArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getCircuit() {
        return radius * 2 * Math.PI;
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withRadius(radius));
    }

    @Override
    public Circle getDoubledSized() {
        return withSurfaceArea(2 * getSurfaceArea());
    }

    @Override
    public int getVertexCount() {
        return Shape.INFINITY_VERTEX_COUNT;
    }

    public double getDiameter() {
        return radius * 2;
    }

    public double getRadius() {
        return radius;
    }

    private Circle(double radius) {
        this.radius = radius;
    }

    public static Circle withSurfaceArea(double surfaceArea) {
        if (surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Circle(Math.pow(surfaceArea / Math.PI, 0.5));
    }

    public static Circle withRadius(double radius) {
        if (radius <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Circle(radius);
    }

    public static Circle withDiameter(double diameter) {
        if (diameter <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Circle(diameter / 2);
    }

    public static Circle withCircuit(double circuit) {
        if (circuit <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new Circle(circuit / Math.PI / 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "circuit=" + Format.format(getCircuit()) +
                ", diameter=" + Format.format(getDiameter()) +
                ", radius=" + Format.format(radius) +
                ", surfaceArea=" + Format.format(getSurfaceArea()) +
                '}';
    }
}
