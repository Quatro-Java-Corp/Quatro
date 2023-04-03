package Model.Shapes;

public final class Square implements RegularPolygon {
    private final double sideLength;

    public enum ConstructorType {
        surfaceArea, diagonalLength, sideLength
    }

    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                ", diagonalLength=" + getDiagonalLength() +
                ", surfaceArea=" + getSurfaceArea() +
                '}';
    }

    @Override
    public double getSurfaceArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getSideLength() {
        return sideLength;
    }

    public double getDiagonalLength() {
        return sideLength * Math.pow(2, 0.5);
    }

    public Square(double value, ConstructorType which) throws Exception {
        if (value < 0) throw new Exception("Value cannot be negative.");
        sideLength = switch (which) {
            case surfaceArea -> Math.pow(value, 0.5);
            case diagonalLength -> Math.pow(value * value / 2, 0.5);
            case sideLength -> value;
        };
    }
}
