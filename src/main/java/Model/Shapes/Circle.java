package Model.Shapes;

public final class Circle implements Figure {
    private final double radius;

    @Override
    public double getSurfaceArea() {
        return radius * radius * Math.PI;
    }

    public double getCircuit() {
        return radius * 2 * Math.PI;
    }

    public double getDiameter() {
        return radius * 2;
    }

    public double getRadius() {
        return radius;
    }

    public enum ConstructorType {
        surfaceArea, circuit, diameter, radius
    }

    @Override
    public String toString() {
        return "Circle{" +
                "circuit=" + getCircuit() +
                ", diameter=" + getDiameter() +
                ", radius=" + radius +
                ", surfaceArea=" + getSurfaceArea() +
                '}';
    }

    public Circle(double value, ConstructorType which) throws Exception {
        if (value < 0) throw new Exception("Value cannot be negative.");
        radius = switch (which) {
            case surfaceArea -> Math.pow(value / Math.PI, 0.5);
            case circuit -> value / Math.PI / 2;
            case diameter -> value / 2;
            case radius -> value;
        };
    }
}
