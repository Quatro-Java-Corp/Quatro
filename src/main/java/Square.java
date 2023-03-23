public final class Square implements Figure {
    private double sideLength;

    public enum ConstructorType {
        surfaceArea, diagonalLength, sideLength;
    }

    @Override
    public String toString() {
        return "Square{" + "sideLength=" + String.valueOf(sideLength) + ", diagonalLength=" + String.valueOf(getDiagonalLength()) + ", surfaceArea=" + String.valueOf(getSurfaceArea()) + '}';
    }

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

    public Square(double value, ConstructorType which) throws Exception {

        if (value < 0) throw new Exception("Value cannot be negative.");
        switch (which) {
            case surfaceArea:
                this.sideLength = Math.pow(value, 0.5);
                break;
            case diagonalLength:
                this.sideLength = Math.pow(value * value / 2, 0.5);
                break;
            case sideLength:
                this.sideLength = value;
        }

    }
}
