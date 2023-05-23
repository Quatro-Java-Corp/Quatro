package shapes;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Optional;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "shape")
public interface Shape {
    int INFINITY_VERTEX_COUNT = 9999;

    double getSurfaceArea();

    double getCircuit();

    Optional<Circle> getCircumscribedCircle();

    Shape getDoubledSized();

    int getVertexCount();
}
