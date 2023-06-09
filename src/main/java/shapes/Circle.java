package shapes;

import java.util.Objects;
import java.util.Optional;

import exceptions.argument.NegativeArgumentValueException;
import utils.CompareDouble;
import utils.Dictionary;
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
        return Dictionary.fromENG("circle") +
                "{" +
                Format.parameterToString("circuit", getCircuit()) + ", " +
                Format.parameterToString("diameter", getDiameter()) + ", " +
                Format.parameterToString("radius", radius) + ", " +
                Format.parameterToString("area", getSurfaceArea()) + ", " +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return CompareDouble.doubleEquals(circle.radius, radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
