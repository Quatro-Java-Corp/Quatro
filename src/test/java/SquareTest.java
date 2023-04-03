import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for Square.
 */
public class SquareTest {
    private final double DELTA = 1e-2;

    private final double SIDE_VALUE = 17.3;
    private final double DIAGONAL_VALUE = 24.465894629;
    private final double AREA_VALUE = 299.29;
    private final double NEGATIVE_VALUE = -13.5;

    /**
     * Side length constructor
     */
    @Test
    public void shouldCreateSquareWithSideLengthAndCalculateOtherParameters() {
        Square s = Square.withSideLength(SIDE_VALUE);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
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
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeSideLength() {
        Square.withSideLength(NEGATIVE_VALUE);
    }

    /**
     * Checking exceptions caused by negative value of diagonal length
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeDiagonaLength() {
        Square.withDiagonalLength(NEGATIVE_VALUE);
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() {
        Square.withSurfaceArea(NEGATIVE_VALUE);
    }
}