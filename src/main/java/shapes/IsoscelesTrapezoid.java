package shapes;

import java.util.Optional;
import static java.lang.Math.*;

public class IsoscelesTrapezoid implements Shape{
    private final double shortBaseLength;
    private final double longBaseLength;
    private final double heightLength;

    public IsoscelesTrapezoid(double shortBaseLength, double longBaseLength, double heightLength) {
        this.shortBaseLength = shortBaseLength;
        this.longBaseLength = longBaseLength;
        this.heightLength = heightLength;
    }
    private with....
    @Override
    public double getSurfaceArea() {
        return (shortBaseLength+longBaseLength)/2 * heightLength;
    }

    public double getSide() {
        return sqrt( pow((longBaseLength-shortBaseLength)/2,2) + pow(heightLength,2) );
    }
    @Override
    public double getCircuit() {
        return shortBaseLength + longBaseLength + 2 * getSide();
    }

    public double getShortBaseLength() {return shortBaseLength;}
    public double getLongBaseLength() {return longBaseLength;}
    public double getHeightLength() {return heightLength;}

    @Override
    public Optional<Circle> getCircumscribedCircle() {
        if (shortBaseLength+longBaseLength != 2* getSide())
            return Optional.empty();
        else
            return Optional.of(Circle.withRadius(heightLength/2));
    }

    @Override
    public Shape getDoubledSized() {
        return null;
    }

    @Override
    public int getVertexCount() {
        return 4;
    }
}
