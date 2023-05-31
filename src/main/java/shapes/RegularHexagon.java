package shapes;

import java.util.Objects;
import java.util.Optional;

import exceptions.argument.NegativeArgumentValueException;
import utils.Dictionary;
import utils.Format;
import utils.CompareDouble;

import static java.lang.Math.sqrt;

public class RegularHexagon implements Shape {

    private final double sideLength;

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public double getSurfaceArea() {
        return 3 * sideLength * sideLength * sqrt(3.0) / 2.0;
    }

    @Override
    public double getCircuit() {
        return 6 * sideLength;
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        return Optional.of(Circle.withRadius(sideLength));
    }

    @Override
    public RegularHexagon getDoubledSized() {
        return withSurfaceArea(2 * getSurfaceArea());
    }

    @Override
    public int getVertexCount() {
        return 6;
    }

    private RegularHexagon(double sideLength) {
        this.sideLength = sideLength;
    }

    public static RegularHexagon withSide(double side) {
        if (side <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new RegularHexagon(side);
    }

    public static RegularHexagon withSurfaceArea(double surfaceArea) {
        if (surfaceArea <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new RegularHexagon(sqrt(surfaceArea * 2 / (3 * sqrt(3.0))));
    }

    public static RegularHexagon withCircuit(double circuit) {
        if (circuit <= 0) {
            throw new NegativeArgumentValueException();
        }
        return new RegularHexagon(circuit / 6);
    }

    @Override
    public String toString() {
        return Dictionary.fromENG("regulaxhexagon") +
                "{" +
                Format.parameterToString("side", sideLength) + ", " +
                Format.parameterToString("area", getSurfaceArea()) + ", " +
                Format.parameterToString("circut", getCircuit()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegularHexagon that = (RegularHexagon) o;
        return CompareDouble.doubleEquals(that.sideLength, sideLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength);
    }
}
