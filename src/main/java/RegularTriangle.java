import static java.lang.Math.*;
import static java.lang.Math.sqrt;

public class RegularTriangle implements Figure{

    private final double sideLength;

    public double getSideLength() {
        return sideLength;
    }


    public double getHeight () {
        return sideLength * pow(3, 0.5) / 2.0;
    }

    @Override
    public double getSurfaceArea() {
        return sideLength * sideLength * pow(3, 0.5) / 4.0;
    }

    public RegularTriangle(double sideLength) {
        this.sideLength = sideLength;
    }

    public static RegularTriangle withSide(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side length must be positive");
        }
        return new RegularTriangle(side);
    }
    public static RegularTriangle withHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        return new RegularTriangle(height * 2 / pow(3,0.5) );
    }

    public static RegularTriangle withSurfaceArea(double surfaceArea) {
        if (surfaceArea <= 0 ) {
            throw new IllegalArgumentException("Value must be positive");
        }
        return new RegularTriangle( pow( surfaceArea * 4 / pow(3,0.5)  ,0.5) );
    }


    @Override
    public String toString() {
        return "RegularTriangle{" +
                "sideLength=" + sideLength +
                ", height=" + getHeight() +
                ", surfaceArea=" + getSurfaceArea() +
                '}';
    }
}
