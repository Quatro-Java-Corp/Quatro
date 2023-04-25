package repository;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.TimeUnit;

import shapes.Circle;
import shapes.Square;

import static org.junit.jupiter.api.Assertions.*;
import static repository.ComparatorFactory.CompareBy.*;
import static repository.ComparatorFactory.OrderBy.*;

class ComparatorFactoryTest {

    @Test
    void getComparatorAreaAscendingTest() {
        Comparator<ShapeRecord> comparator = new ComparatorFactory().getComparator(area, ascending);
        ShapeRecord first = new ShapeRecord(Circle.withSurfaceArea(100));
        ShapeRecord second = new ShapeRecord(Square.withSurfaceArea(50));
        assertEquals(1, comparator.compare(first, second));
    }

    @Test
    void getComparatorAreaDescendingTest() {
        Comparator<ShapeRecord> comparator = new ComparatorFactory().getComparator(area, descending);
        ShapeRecord first = new ShapeRecord(Circle.withSurfaceArea(100));
        ShapeRecord second = new ShapeRecord(Square.withSurfaceArea(50));
        assertEquals(-1, comparator.compare(first, second));
    }

    @Test
    void getComparatorCircuitAscendingTest() {
        Comparator<ShapeRecord> comparator = new ComparatorFactory().getComparator(circuit, ascending);
        ShapeRecord first = new ShapeRecord(Circle.withCircuit(100));
        ShapeRecord second = new ShapeRecord(Square.withSideLength(20));
        assertEquals(1, comparator.compare(first, second));
    }

    @Test
    void getComparatorCircuitDescendingTest() {
        Comparator<ShapeRecord> comparator = new ComparatorFactory().getComparator(circuit, descending);
        ShapeRecord first = new ShapeRecord(Circle.withCircuit(100));
        ShapeRecord second = new ShapeRecord(Square.withSideLength(20));
        assertEquals(-1, comparator.compare(first, second));
    }

    @Test
    void getComparatorDateAscendingTest() {
        Comparator<ShapeRecord> comparator = new ComparatorFactory().getComparator(date, ascending);
        ShapeRecord first = new ShapeRecord(Circle.withSurfaceArea(100));
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ShapeRecord second = new ShapeRecord(Square.withSurfaceArea(50));
        assertEquals(-1, comparator.compare(first, second));
    }

    @Test
    void getComparatorDateDescendingTest() {
        Comparator<ShapeRecord> comparator = new ComparatorFactory().getComparator(date, descending);
        ShapeRecord first = new ShapeRecord(Circle.withSurfaceArea(100));
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ShapeRecord second = new ShapeRecord(Square.withSurfaceArea(50));
        assertEquals(1, comparator.compare(first, second));
    }
}