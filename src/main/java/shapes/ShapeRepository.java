import shapes.Shape;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ShapeRepository {
    private final List<Shape> shapes = new LinkedList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void sort(Comparator<Shape> comparator) {
        shapes.sort(comparator);
    }

    public Optional<Shape> get(int index) {
        if (index < 0 || index >= shapes.size()) {
            return Optional.empty();
        }
        return Optional.of(shapes.get(index));
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void print() {
        for (int i = 0; i < shapes.size(); i++) {
            System.out.println(i + ". " + shapes.get(i));
        }
    }
}
