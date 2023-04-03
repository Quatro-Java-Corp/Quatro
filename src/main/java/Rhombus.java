import static java.lang.Math.*;

public class Rhombus implements Figure {
    private final double shortDiagonalLength;
    private final double longDiagonalLength;

    private Rhombus(double shortDiagonalLength, double longDiagonalLength) {
        this.shortDiagonalLength = shortDiagonalLength;
        this.longDiagonalLength = longDiagonalLength;
    }

    public static Rhombus withShortDiagonalAndLongDiagonal(double shortDiagonalLength, double longDiagonalLength) {
        return new Rhombus(shortDiagonalLength, longDiagonalLength);
    }

    public static Rhombus withShortDiagonalAndSide(double shortDiagonalLength, double sideLength) {
        return new Rhombus(shortDiagonalLength, sqrt(4 * pow(sideLength, 2) - pow(shortDiagonalLength, 2)));
    }

    public static Rhombus withShortDiagonalAndSurfaceArea(double shortDiagonalLength, double surfaceArea) {
        return new Rhombus(shortDiagonalLength, 2 * surfaceArea / shortDiagonalLength);
    }

    public static Rhombus withLongDiagonalAndSide(double longDiagonalLength, double sideLength) {
        return new Rhombus(sqrt(4 * pow(sideLength, 2) - pow(longDiagonalLength, 2)), longDiagonalLength);
    }

    public static Rhombus withLongDiagonalAndSurfaceArea(double longDiagonalLength, double surfaceArea) {
        return new Rhombus(2 * surfaceArea / longDiagonalLength, longDiagonalLength);
    }

    public static Rhombus withSideLengthAndSurfaceArea(double sideLength, double surfaceArea) {
        double cos = sqrt(1 - pow(surfaceArea / pow(sideLength, 2), 2));
        return new Rhombus(sideLength * sqrt(2 + 2 * cos), sideLength * 2 * sqrt(2 - 2 * cos));
    }

    public double getShortDiagonalLength() {
        return shortDiagonalLength;
    }

    public double getLongDiagonalLength() {
        return longDiagonalLength;
    }

    public double getSideLength() {
        return sqrt(pow(shortDiagonalLength, 2) + pow(longDiagonalLength, 2)) / 2;
    }

    @Override
    public double getSurfaceArea() {
        return shortDiagonalLength * longDiagonalLength / 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "sideLength=" + getSideLength() +
                ", shortDiagonalLength=" + shortDiagonalLength +
                ", longDiagonalLength=" + longDiagonalLength +
                ", surfaceArea=" + getSurfaceArea() +
                '}';
    }
}
