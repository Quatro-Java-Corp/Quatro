import shapes.Shape;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ShapeRepository {
    private final List<Shape> shapes = new LinkedList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void sort(Comparator<Shape> comparator) {
        shapes.sort(comparator);
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
