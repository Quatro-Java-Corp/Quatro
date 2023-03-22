public class Circle extends Figure{
    protected double circuit;
    protected double diameter;
    protected double radius;

    @Override
    public String toString() {
        return "Circle{" +
                "circuit=" + circuit +
                ", diameter=" + diameter +
                ", radius=" + radius +
                ", surfaceArea=" + surfaceArea +
                '}';
    }

    public Circle(double value, int which) throws Exception {
        super();
        if(value < 0) throw new Exception("Value cannot be negative.");
        switch(which) {
            case 0:

                this.surfaceArea = value;
                this.radius =  Math.pow(surfaceArea / Math.PI,0.5 );
                this.diameter = radius * 2;
                this.circuit = diameter * Math.PI;
                break;
            case 1:
                this.circuit = value;
                this.diameter = circuit / Math.PI;
                this.radius = diameter / 2;
                this.surfaceArea = radius * radius * Math.PI;
                break;
            case 2:
                this.diameter = value;
                this.radius = diameter /2;
                this.circuit = diameter * Math.PI;
                this.surfaceArea = radius * radius * Math.PI;
                break;
            default:
                this.radius = value;
                this.diameter = radius * 2;
                this.circuit = diameter * Math.PI;
                this.surfaceArea = radius * radius * Math.PI;
        }
    }
}
