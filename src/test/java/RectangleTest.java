import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for Rectangle.
 */
public class RectangleTest {
    private final double DELTA = 1e-2;

    private final double LONG_SIDE_VALUE = 4;
    private final double SHORT_SIDE_VALUE = 3;
    private final double DIAGONAL_VALUE = 5;
    private final double AREA_VALUE = 12;
    private final double NEGATIVE_VALUE = -13.5;

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
    }

    /**
     * Checking exceptions caused by negative value of short side length
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAfterReceivingNegativeShortSideLength() {
        Rectangle.withShortSideAndLongSide(NEGATIVE_VALUE, LONG_SIDE_VALUE);
    }

    /**
     * Checking exceptions caused by negative value of short side length
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAfterReceivingNegativeShortSideLengthAndDiagonal() {
        Rectangle.withShortSideAndDiagonal(NEGATIVE_VALUE, DIAGONAL_VALUE);
    }

    /**
     * Checking exceptions caused by negative value of short side length
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAfterReceivingNegativeShortSideLengthAndSurfaceArea() {
        Rectangle.withShortSideAndSurfaceArea(NEGATIVE_VALUE, AREA_VALUE);
    }

    /**
     * Checking exceptions caused by negative value of long side length
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAfterReceivingNegativeLongSideLength() {
        Rectangle.withShortSideAndLongSide(SHORT_SIDE_VALUE, NEGATIVE_VALUE);
    }

    /**
     * Checking exceptions caused by negative value of long side length
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAfterReceivingNegativeLongSideLengthAndDiagonal() {
        Rectangle.withLongSideAndDiagonal(NEGATIVE_VALUE, DIAGONAL_VALUE);
    }

    /**
     * Checking exceptions caused by negative value of long side length
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionAfterReceivingNegativeLongSideLengthAndSurfaceArea() {
        Rectangle.withLongSideAndSurfaceArea(NEGATIVE_VALUE, AREA_VALUE);
    }
}
