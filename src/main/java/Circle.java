public final class Circle implements Figure{
    private double circuit;
    private double diameter;
    private double radius;
    private double surfaceArea;

    @Override
    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getCircuit() {
        return circuit;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getRadius() {
        return radius;
    }

    public enum ConstructorType {
        surfaceArea(0),
        circuit(1),
        diameter(2),
        radius(3);

        private final int value;

        private ConstructorType(int value) {
            this.value = value;
        }

    }

    @Override
    public String toString() {
        return "Circle{" +
                "circuit=" + circuit +
                ", diameter=" + diameter +
                ", radius=" + radius +
                ", surfaceArea=" + surfaceArea +
                '}';
    }

    public Circle(double value, ConstructorType which) throws Exception {

        if(value < 0) throw new Exception("Value cannot be negative.");
        switch(which) {
            case surfaceArea:

                this.surfaceArea = value;
                this.radius =  Math.pow(surfaceArea / Math.PI,0.5 );
                this.diameter = radius * 2;
                this.circuit = diameter * Math.PI;
                break;
            case circuit:
                this.circuit = value;
                this.diameter = circuit / Math.PI;
                this.radius = diameter / 2;
                this.surfaceArea = radius * radius * Math.PI;
                break;
            case diameter:
                this.diameter = value;
                this.radius = diameter /2;
                this.circuit = diameter * Math.PI;
                this.surfaceArea = radius * radius * Math.PI;
                break;
            case radius :
                this.radius = value;
                this.diameter = radius * 2;
                this.circuit = diameter * Math.PI;
                this.surfaceArea = radius * radius * Math.PI;
        }
    }
}
