package shapes;

import java.util.Optional;

public interface Shape {
    int INFINITY_VERTEX_COUNT = 9999;

    double getSurfaceArea();

    double getCircuit();

    Optional<Circle> getCircumscribedCircle();

    Shape getDoubledSized();

    int getVertexCount();
}
