package shapes;

public final class Square implements Shape {
    private final double sideLength;

    public static final String name = "square";
    public static final double numberOfArguments = 1;

    @Override
    public double getSurfaceArea() {
        return sideLength * sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public double getDiagonalLength() {
        return sideLength * Math.pow(2, 0.5);
    }

    private Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public static Square withSideLength(double sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Negative side length");
        }
        return new Square(sideLength);
    }

    public static Square withDiagonalLength(double diagonalLength) {
        if (diagonalLength <= 0) {
            throw new IllegalArgumentException("Negative diagonal length");
        }
        return new Square(Math.pow(diagonalLength * diagonalLength / 2, 0.5));
    }

    public static Square withSurfaceArea(double surfaceArea) {
        if (surfaceArea <= 0) {
            throw new IllegalArgumentException("Negative surface area");
        }
        return new Square(Math.pow(surfaceArea, 0.5));
    }

    @Override
    public String toString() {
        return "shapes.Square{" +
                "sideLength=" + sideLength +
                ", diagonalLength=" + getDiagonalLength() +
                ", surfaceArea=" + getSurfaceArea() +
                '}';
    }
}
