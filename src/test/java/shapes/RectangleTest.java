package shapes;

import org.junit.jupiter.api.Test;

import exceptions.argument.NegativeArgumentValueException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Rectangle.
 */
public class RectangleTest {
    private final double DELTA = 1e-2;

    private final double LONG_SIDE_VALUE = 4;
    private final double SHORT_SIDE_VALUE = 3;
    private final double DIAGONAL_VALUE = 5;
    private final double AREA_VALUE = 12;
    private final double CIRCUIT_VALUE = 14;
    private final double NEGATIVE_VALUE = -13.5;
    private static final double CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE = 2.5;
    private final double DOUBLED_AREA_VALUE = 2 * AREA_VALUE;

    /**
     * Short Side And Long Side
     */
    @Test
    public void shouldCreateRectangleWithShortSideAndLongSideAndCalculateOtherParameters() {
        Rectangle r = Rectangle.withShortSideAndLongSide(SHORT_SIDE_VALUE, LONG_SIDE_VALUE);

        assertEquals(r.getShortSideLength(), SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getLongSideLength(), LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Short Side And Length
     */
    @Test
    public void shouldCreateRectangleWithShortSideAndDiagonalAndCalculateOtherParameters() {
        Rectangle r = Rectangle.withShortSideAndDiagonal(SHORT_SIDE_VALUE, DIAGONAL_VALUE);

        assertEquals(r.getShortSideLength(), SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getLongSideLength(), LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Short Side And SurfaceArea
     */
    @Test
    public void shouldCreateRectangleWithShortSideAndSurfaceAreaAndCalculateOtherParameters() {
        Rectangle r = Rectangle.withShortSideAndSurfaceArea(SHORT_SIDE_VALUE, AREA_VALUE);

        assertEquals(r.getShortSideLength(), SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getLongSideLength(), LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Long Side And Diagonal Length
     */
    @Test
    public void shouldCreateRectangleWithLongSideAndDiagonalAndCalculateOtherParameters() {
        Rectangle r = Rectangle.withLongSideAndDiagonal(LONG_SIDE_VALUE, DIAGONAL_VALUE);

        assertEquals(r.getShortSideLength(), SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getLongSideLength(), LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Long Side And SurfaceArea
     */
    @Test
    public void shouldCreateRectangleWithLongSideAndSurfaceAreaAndCalculateOtherParameters() {
        Rectangle r = Rectangle.withLongSideAndSurfaceArea(LONG_SIDE_VALUE, AREA_VALUE);

        assertEquals(r.getShortSideLength(), SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getLongSideLength(), LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Diagonal Length And SurfaceArea
     */
    @Test
    public void shouldCreateRectangleWithDiagonalLengthAndSurfaceAreaAndCalculateOtherParameters() {
        Rectangle r = Rectangle.withDiagonalAndSurfaceArea(DIAGONAL_VALUE, AREA_VALUE);

        assertEquals(r.getShortSideLength(), SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getLongSideLength(), LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of short side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeShortSideLength() {
        assertThrows(NegativeArgumentValueException.class,
                () -> Rectangle.withShortSideAndLongSide(NEGATIVE_VALUE, LONG_SIDE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of short side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeShortSideLengthAndDiagonal() {
        assertThrows(NegativeArgumentValueException.class,
                () -> Rectangle.withShortSideAndDiagonal(NEGATIVE_VALUE, DIAGONAL_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of short side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeShortSideLengthAndSurfaceArea() {
        assertThrows(NegativeArgumentValueException.class,
                () -> Rectangle.withShortSideAndSurfaceArea(NEGATIVE_VALUE, AREA_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of long side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeLongSideLength() {
        assertThrows(NegativeArgumentValueException.class,
                () -> Rectangle.withShortSideAndLongSide(SHORT_SIDE_VALUE, NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of long side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeLongSideLengthAndDiagonal() {
        assertThrows(NegativeArgumentValueException.class,
                () -> Rectangle.withLongSideAndDiagonal(NEGATIVE_VALUE, DIAGONAL_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of long side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeLongSideLengthAndSurfaceArea() {
        assertThrows(NegativeArgumentValueException.class,
                () -> Rectangle.withLongSideAndSurfaceArea(NEGATIVE_VALUE, AREA_VALUE));
    }

    /**
     * Short Side shorter than long side
     */
    @Test
    public void shouldCreateRectangleWithShorterShortSideThanLongSide() {
        Rectangle r = Rectangle.withShortSideAndLongSide(LONG_SIDE_VALUE, SHORT_SIDE_VALUE);

        assertEquals(r.getShortSideLength(), SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getLongSideLength(), LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    @Test
    void shouldReturnCircleWithCorrectRadiusWhenProvidingCircumscribedCircle() {
        Rectangle r = Rectangle.withShortSideAndLongSide(SHORT_SIDE_VALUE, LONG_SIDE_VALUE);
        var c = assertDoesNotThrow(r.getCircumscribedCircle()::get);
        assertEquals(CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE, c.getRadius(), DELTA);
    }

    /**
     * Doubled sized method
     */
    @Test
    public void shouldReturnRectangleWithDoubledSurfaceArea() {
        Rectangle r = Rectangle.withShortSideAndSurfaceArea(SHORT_SIDE_VALUE, AREA_VALUE);
        Rectangle r2 = r.getDoubledSized();

        assertEquals(r2.getSurfaceArea(), DOUBLED_AREA_VALUE, DELTA);
    }
}
