package repository;

import exceptions.shape.DuplicatedShapeException;
import org.junit.jupiter.api.Test;
import shapes.Circle;
import shapes.Shape;
import shapes.Square;

import static org.junit.jupiter.api.Assertions.*;

class ShapeRepositoryTest {
    private final double CIRCLE_RADIUS_VALUE = 17.3;
    private final double SQUARE_SIDE_VALUE = 17.3;

    @Test
    void shouldNotAddSameShapeTwice() {
        Circle c = Circle.withCircuit(CIRCLE_RADIUS_VALUE);
        ShapeRepository shapeRepository = new ShapeRepository();
        shapeRepository.addShape(c);

        assertThrows(DuplicatedShapeException.class, () -> shapeRepository.addShape(c));
    }

    @Test
    void shouldAddDifferentShapes() {
        Circle c = Circle.withCircuit(CIRCLE_RADIUS_VALUE);
        Square s = Square.withSideLength(SQUARE_SIDE_VALUE);
        ShapeRepository shapeRepository = new ShapeRepository();
        shapeRepository.addShape(c);

        assertDoesNotThrow(() -> shapeRepository.addShape(s));

        Shape s1 = assertDoesNotThrow(() -> shapeRepository.get(0).orElseThrow());
        Shape s2 = assertDoesNotThrow(() -> shapeRepository.get(1).orElseThrow());

        assertEquals(c, s1);
        assertEquals(s, s2);
    }
}
