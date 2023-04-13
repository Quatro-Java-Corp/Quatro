package shapes;

public final class Circle implements Shape {
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

    private Circle(double radius) {
        this.radius = radius;
    }

    public static Circle withSurfaceArea(double surfaceArea) {
        if (surfaceArea <= 0) {
            throw new IllegalArgumentException("Negative surface area");
        }
        return new Circle(Math.pow(surfaceArea / Math.PI, 0.5));
    }

    public static Circle withRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Negative radius");
        }
        return new Circle(radius);
    }

    public static Circle withDiameter(double diameter) {
        if (diameter <= 0) {
            throw new IllegalArgumentException("Negative diameter");
        }
        return new Circle(diameter / 2);
    }

    public static Circle withCircuit(double circuit) {
        if (circuit <= 0) {
            throw new IllegalArgumentException("Negative surface area");
        }
        return new Circle(circuit / Math.PI / 2);
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
}
