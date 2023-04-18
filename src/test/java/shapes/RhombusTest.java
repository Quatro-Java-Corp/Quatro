package shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Rhombus.
 */
public class RhombusTest {
    private final double DELTA = 1e-2;

    private final double SIDE_VALUE = 5;
    private final double LONG_DIAGONAL_VALUE = 8;
    private final double SHORT_DIAGONAL_VALUE = 6;
    private final double AREA_VALUE = 24;
    private final double CIRCUIT_VALUE = 20;
    private final double NON_POSITIVE_VALUE = 0;

    /**
     * Short Diagonal And Long Diagonal
     */
    @Test
    public void shouldCreateRhombusWithShortDiagonalAndLongDiagonalAndCalculateOtherParameters() {
        Rhombus r = Rhombus.withShortDiagonalAndLongDiagonal(SHORT_DIAGONAL_VALUE, LONG_DIAGONAL_VALUE);

        assertEquals(r.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(r.getShortDiagonalLength(), SHORT_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getLongDiagonalLength(), LONG_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Short Diagonal And Side Length
     */
    @Test
    public void shouldCreateRhombusWithShortDiagonalAndSideAndCalculateOtherParameters() {
        Rhombus r = Rhombus.withShortDiagonalAndSide(SHORT_DIAGONAL_VALUE, SIDE_VALUE);

        assertEquals(r.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(r.getShortDiagonalLength(), SHORT_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getLongDiagonalLength(), LONG_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Short Diagonal And SurfaceArea
     */
    @Test
    public void shouldCreateRhombusWithShortDiagonalAndSurfaceAreaAndCalculateOtherParameters() {
        Rhombus r = Rhombus.withShortDiagonalAndSurfaceArea(SHORT_DIAGONAL_VALUE, AREA_VALUE);

        assertEquals(r.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(r.getShortDiagonalLength(), SHORT_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getLongDiagonalLength(), LONG_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Long Diagonal And Side Length
     */
    @Test
    public void shouldCreateRhombusWithLongDiagonalAndSideAndCalculateOtherParameters() {
        Rhombus r = Rhombus.withLongDiagonalAndSide(LONG_DIAGONAL_VALUE, SIDE_VALUE);

        assertEquals(r.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(r.getShortDiagonalLength(), SHORT_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getLongDiagonalLength(), LONG_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Long Diagonal And SurfaceArea
     */
    @Test
    public void shouldCreateRhombusWithLongDiagonalAndSurfaceAreaAndCalculateOtherParameters() {
        Rhombus r = Rhombus.withLongDiagonalAndSurfaceArea(LONG_DIAGONAL_VALUE, AREA_VALUE);

        assertEquals(r.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(r.getShortDiagonalLength(), SHORT_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getLongDiagonalLength(), LONG_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Side Length And SurfaceArea
     */
    @Test
    public void shouldCreateRhombusWithSideLengthAndSurfaceAreaAndCalculateOtherParameters() {
        Rhombus r = Rhombus.withSideLengthAndSurfaceArea(SIDE_VALUE, AREA_VALUE);

        assertEquals(r.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(r.getShortDiagonalLength(), SHORT_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getLongDiagonalLength(), LONG_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of short diagonal length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeShortDiagonalLength() {
        assertThrows(Exception.class,
                () -> Rhombus.withShortDiagonalAndLongDiagonal(NON_POSITIVE_VALUE, LONG_DIAGONAL_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of long diagonal length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeLongDiagonalLength() {
        assertThrows(Exception.class,
                () -> Rhombus.withShortDiagonalAndLongDiagonal(SHORT_DIAGONAL_VALUE, NON_POSITIVE_VALUE));
    }

    /**
     * Short Diagonal shorter than long Diagonal
     */
    @Test
    public void shouldCreateRhombusWithShorterShortDiagonalThanLongDiagonal() {
        Rhombus r = Rhombus.withShortDiagonalAndLongDiagonal(LONG_DIAGONAL_VALUE, SHORT_DIAGONAL_VALUE);

        assertEquals(r.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(r.getShortDiagonalLength(), SHORT_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getLongDiagonalLength(), LONG_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    @Test
    public void shouldReturnEmptyOptionalWhenAskedForCircumscribedCircle() {
        Rhombus r = Rhombus.withShortDiagonalAndLongDiagonal(LONG_DIAGONAL_VALUE, SHORT_DIAGONAL_VALUE);
        assertTrue(r.getCircumscribedCircle().isEmpty());
    }
}
