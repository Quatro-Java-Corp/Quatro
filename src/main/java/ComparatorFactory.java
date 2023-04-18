import shapes.Shape;

import java.util.Comparator;

public class ComparatorFactory {

    enum CompareBy {
        surfaceArea, circuit
    }

    enum OrderBy {
        ascending, descending
    }

    public Comparator<Shape> getComparator(CompareBy compare, OrderBy order) {
        Comparator<Shape> comparator = switch (compare) {
            case surfaceArea -> Comparator.comparingDouble(Shape::getSurfaceArea);
            case circuit -> Comparator.comparingDouble(Shape::getCircuit);
        };
        if (order == OrderBy.descending) {
            return comparator.reversed();
        } else {
            return comparator;
        }
    }

}
