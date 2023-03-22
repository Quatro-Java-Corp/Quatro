public final class Circle implements Figure {
    private double radius;


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
        surfaceArea, circuit, diameter, radius;

    }

    @Override
    public String toString() {
        return "Circle{" + "circuit=" + String.valueOf(getCircuit()) + ", diameter=" + String.valueOf(getDiameter()) + ", radius=" + radius + ", surfaceArea=" + String.valueOf(getSurfaceArea()) + '}';
    }

    public Circle(double value, ConstructorType which) throws Exception {

        if (value < 0) throw new Exception("Value cannot be negative.");
        switch (which) {
            case surfaceArea:
                this.radius = Math.pow(value / Math.PI, 0.5);
                break;
            case circuit:
                this.radius = value / Math.PI / 2;
                break;
            case diameter:
                this.radius = value / 2;
                break;
            case radius:
                this.radius = value;
        }
    }
}
