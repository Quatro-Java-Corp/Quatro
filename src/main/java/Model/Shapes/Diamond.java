package Model.Shapes;

public final class Diamond implements RegularPolygon {
    private final double shortDiagonalLength;
    private final double longDiagonalLength;

    @Override
    public String toString() {
        return "Diamond{" +
                "sideLength=" + getSideLength() +
                ", longDiagonalLength=" + longDiagonalLength +
                ", shortDiagonalLength=" + shortDiagonalLength +
                ", surfaceArea=" + getSurfaceArea() +
                '}';
    }

    @Override
    public double getSurfaceArea() {
        return shortDiagonalLength * longDiagonalLength / 2.0;
    }

    @Override
    public double getSideLength() {
        return Math.sqrt(Math.pow(shortDiagonalLength/2, 2) + Math.pow(longDiagonalLength/2, 2));
    }

    public double getLongDiagonalLength() {
        return longDiagonalLength;
    }

    public double getShortDiagonalLength() {
        return shortDiagonalLength;
    }

    public Diamond(double shortDiagonalLength, double longDiagonalLength) throws Exception {
        if (shortDiagonalLength > longDiagonalLength) {
            this.shortDiagonalLength = longDiagonalLength;
            this.longDiagonalLength = shortDiagonalLength;
        } else {
            this.shortDiagonalLength = shortDiagonalLength;
            this.longDiagonalLength = longDiagonalLength;
        }
    }
}
