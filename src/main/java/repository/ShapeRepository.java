package repository;

import exceptions.command.IllegalIndexException;
import exceptions.shape.DuplicatedShapeException;
import shapes.Shape;

import java.util.*;
import java.util.stream.IntStream;

public class ShapeRepository {
    private final List<ShapeRecord> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        if (!contains(shape)) {
            shapes.add(new ShapeRecord(shape));
        } else {
            throw new DuplicatedShapeException();
        }
    }

    private boolean contains(Shape shape) {
        return shapes.stream()
                .map(ShapeRecord::getShape)
                .anyMatch(shape::equals);
    }

    public void sort(Comparator<ShapeRecord> comparator) {
        shapes.sort(comparator);
    }

    public Optional<Shape> get(int index) {
        if (isIndexCorrect(index)) {
            return Optional.of(shapes.get(index).getShape());
        }
        return Optional.empty();
    }

    public void remove(int index) {
        if (isIndexCorrect(index)) {
            shapes.remove(index);
        } else {
            throw new IllegalIndexException();
        }
    }

    private boolean isIndexCorrect(int index) {
        return index >= 0 && index < shapes.size();
    }

    public void print() {
        IntStream.range(0, shapes.size())
                .mapToObj(i -> i + ". " + shapes.get(i).getShape() + " | " + shapes.get(i).getCreationDate())
                .forEachOrdered(System.out::println);
    }
}
