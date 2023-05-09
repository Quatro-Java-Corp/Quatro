package shapes;

import java.util.Optional;

public interface Shape {
    double getSurfaceArea();

    double getCircuit();

    Optional<Circle> getCircumscribedCircle();

    Shape getDoubledSized();

    int getVertexCount();
}
