import java.util.LinkedList;
import java.util.List;

public class ShapeRepository {
    private final List<Shape> shapes = new LinkedList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public List<Shape> getShapes() {
        shapes.sort((Shape a, Shape b) -> a.getSurfaceArea() < b.getSurfaceArea() ? -1 : 1);
        return shapes;
    }
}
