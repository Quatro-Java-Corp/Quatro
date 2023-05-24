package shapes;

import exceptions.argument.NegativeArgumentValueException;
import exceptions.shape.IllegalTriangleSidesException;
import utils.Format;

import java.util.Optional;
import static java.lang.Math.*;

public class Triangle implements Shape {
    private final double sideA,sideB,sideC;

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public Triangle(double sideA, double sideB, double sideC) {
        if ((sideA <= 0) || (sideB <= 0) || (sideC <= 0))
            throw new NegativeArgumentValueException();
        if ((sideA > sideC + sideB)||(sideB > sideC + sideA)||(sideC > sideA + sideB) )
            throw new IllegalTriangleSidesException();
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }

    @Override
    public double getSurfaceArea() {
        double p = (sideA + sideB + sideC )/2;
        return sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
    }

    @Override
    public double getCircuit() {
        return sideA + sideB + sideC;
    }

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        double p = (sideA + sideB + sideC )/2;
        return Optional.of(Circle.withRadius(sideA * sideB * sideC / (4*getSurfaceArea())));
    }

    @Override
    public Triangle getDoubledSized() {
        return new Triangle(sqrt(2)*sideA,sqrt(2)*sideB,sqrt(2)*sideC);
    }

    @Override
    public int getVertexCount() {
        return 3;
    }
}
