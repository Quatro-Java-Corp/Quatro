package repository;

import java.util.Comparator;

public class ComparatorFactory {

    public enum CompareBy {
        area, circuit, date, vertex
    }

    public enum OrderBy {
        ascending, descending
    }

    public Comparator<ShapeRecord> getComparator(CompareBy compare, OrderBy order) {
        Comparator<ShapeRecord> comparator = switch (compare) {
            case area -> Comparator.comparingDouble(record -> record.getShape().getSurfaceArea());
            case circuit -> Comparator.comparingDouble(record -> record.getShape().getCircuit());
            case date -> Comparator.comparing(ShapeRecord::getCreationDate);
            case vertex -> Comparator.comparingInt(record -> record.getShape().getVertexCount());
        };
        if (order == OrderBy.descending) {
            return comparator.reversed();
        } else {
            return comparator;
        }
    }

}
