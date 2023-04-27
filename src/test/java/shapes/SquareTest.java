package shapes;

import org.junit.jupiter.api.Test;

import exceptions.NegativeArgumentValueException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Square.
 */
public class SquareTest {
    private final double DELTA = 1e-2;

    private final double SIDE_VALUE = 17.3;
    private final double DIAGONAL_VALUE = 24.465894629;
    private final double AREA_VALUE = 299.29;
    private final double CIRCUIT_VALUE = 69.2;
    private final double NEGATIVE_VALUE = -13.5;
    private final double CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE = 12.23;
    private final double DOUBLED_AREA_VALUE = 2 * AREA_VALUE;

    /**
     * Side length constructor
     */
    @Test
    public void shouldCreateSquareWithSideLengthAndCalculateOtherParameters() {
        Square s = Square.withSideLength(SIDE_VALUE);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(s.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Diagonal length constructor
     */
    @Test
    public void shouldCreateSquareWithDiagonalLengthAndCalculateOtherParameters() {
        Square s = Square.withDiagonalLength(DIAGONAL_VALUE);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(s.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Surface area constructor
     */
    @Test
    public void shouldCreateSquareWithSurfaceAreaAndCalculateOtherParameters() {
        Square s = Square.withSurfaceArea(AREA_VALUE);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(s.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSideLength() {
        assertThrows(NegativeArgumentValueException.class, () -> Square.withSideLength(NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of diagonal length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeDiagonaLength() {
        assertThrows(NegativeArgumentValueException.class, () -> Square.withDiagonalLength(NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() {
        assertThrows(NegativeArgumentValueException.class, () -> Square.withSurfaceArea(NEGATIVE_VALUE));
    }

    @Test
    void shouldReturnCircleWithCorrectRadiusWhenProvidingCircumscribedCircle() {
        Square s = Square.withSideLength(SIDE_VALUE);
        var c = assertDoesNotThrow(s.getCircumscribedCircle()::get);
        assertEquals(CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE, c.getRadius(),DELTA);
    }

    /**
     * Doubled sized method
     */
    @Test
    public void shouldReturnSquareWithDoubledSurfaceArea() {
        Square s = Square.withSurfaceArea(AREA_VALUE);
        Square s2 = s.getDoubledSized();

        assertEquals(s2.getSurfaceArea(), DOUBLED_AREA_VALUE, DELTA);
    }
}
