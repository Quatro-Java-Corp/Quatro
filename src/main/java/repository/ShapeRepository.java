package repository;

import exceptions.command.IllegalIndexException;
import shapes.Shape;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ShapeRepository {
    private final List<ShapeRecord> shapes = new LinkedList<>();

    public void addShape(Shape shape) {
        shapes.add(new ShapeRecord(shape));
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
