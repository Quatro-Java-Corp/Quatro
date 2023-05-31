package shapes;

import exceptions.argument.NegativeArgumentValueException;
import exceptions.shape.IllegalTriangleSidesException;
import utils.CompareDouble;
import utils.Dictionary;
import utils.Format;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.Math.*;

public class Triangle implements Shape {
    private final double shortSide, mediumSide, longSide;

    public double getShortSide() {
        return shortSide;
    }

    public double getMediumSide() {
        return mediumSide;
    }

    public double getLongSide() {
        return longSide;
    }

    public Triangle(double shortSide, double mediumSide, double longSide) {
        if ((shortSide <= 0) || (mediumSide <= 0) || (longSide <= 0))
            throw new NegativeArgumentValueException();
        if ((shortSide > longSide + mediumSide) || (mediumSide > longSide + shortSide) || (longSide > shortSide + mediumSide)) {
            throw new IllegalTriangleSidesException();
        }
        List<Double> sorted = Stream.of(shortSide, mediumSide, longSide).sorted().toList();
        this.shortSide = sorted.get(0);
        this.mediumSide = sorted.get(1);
        this.longSide = sorted.get(2);
    }

    @Override
    public double getSurfaceArea() {
        double p = (shortSide + mediumSide + longSide) / 2;
        return sqrt(p * (p - shortSide) * (p - mediumSide) * (p - longSide));
    }

    @Override
    public double getCircuit() {
        return shortSide + mediumSide + longSide;
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withRadius(shortSide * mediumSide * longSide / (4 * getSurfaceArea())));
    }

    @Override
    public Triangle getDoubledSized() {
        return new Triangle(sqrt(2) * shortSide, sqrt(2) * mediumSide, sqrt(2) * longSide);
    }

    @Override
    public int getVertexCount() {
        return 3;
    }

    @Override
    public String toString() {
        return Dictionary.fromENG("triangle") +
                "{" +
                "sideA=" + Format.format(shortSide) +
                ", sideB=" + Format.format(mediumSide) +
                ", sideC=" + Format.format(longSide) +
                ", circuit=" + Format.format(getCircuit()) +
                ", area=" + Format.format(getSurfaceArea()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return CompareDouble.doubleEquals(triangle.shortSide, shortSide) &&
                CompareDouble.doubleEquals(triangle.mediumSide, mediumSide) &&
                CompareDouble.doubleEquals(triangle.longSide, longSide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortSide, mediumSide, longSide);
    }
}
