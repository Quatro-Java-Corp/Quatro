package shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import exceptions.argument.NegativeArgumentValueException;
import exceptions.shape.IllegalTriangleSidesException;

/**
 * Unit test for IsoscelesTrapezoid.
 */
public class IsoscelesTrapezoidTest {
    private final double DELTA = 1e-2;

    private final double SIDE_VALUE = 5;
    private final double SHORT_BASE_VALUE = 7;
    private final double LONG_BASE_VALUE = 13;
    private final double HEIGHT_VALUE = 4;
    private final double AREA_VALUE = 40;
    private final double CIRCUIT_VALUE = 2 * SIDE_VALUE + SHORT_BASE_VALUE + LONG_BASE_VALUE;
    private final double NEGATIVE_VALUE = -13.5;
    private final double DOUBLED_AREA_VALUE = 2 * AREA_VALUE;

    /**
     * 2 Bases and Side
     */
    @Test
    public void shouldCreateIsoscelesTrapezoidWithTwoBasesAndSideAndCalculateOtherParameters() {
        IsoscelesTrapezoid t = IsoscelesTrapezoid.withTwoBaseAndSide(SHORT_BASE_VALUE, LONG_BASE_VALUE,
                SIDE_VALUE);
        assertEquals(t.getShortBaseLength(), SHORT_BASE_VALUE, DELTA);
        assertEquals(t.getLongBaseLength(), LONG_BASE_VALUE, DELTA);
        assertEquals(t.getSide(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * 2 Bases and Height
     */
    @Test
    public void shouldCreateIsoscelesTrapezoidWithTwoBasesAndHeightAndCalculateOtherParameters() {
        IsoscelesTrapezoid t = IsoscelesTrapezoid.withTwoBaseAndHeight(SHORT_BASE_VALUE, LONG_BASE_VALUE,
                HEIGHT_VALUE);
        assertEquals(t.getShortBaseLength(), SHORT_BASE_VALUE, DELTA);
        assertEquals(t.getLongBaseLength(), LONG_BASE_VALUE, DELTA);
        assertEquals(t.getSide(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * 2 Bases and Height
     */
    @Test
    public void shouldCreateIsoscelesTrapezoidWithTwoBasesAndHeightLongAdShortAndCalculateOtherParameters() {
        IsoscelesTrapezoid t = IsoscelesTrapezoid.withTwoBaseAndHeight(LONG_BASE_VALUE, SHORT_BASE_VALUE,
                HEIGHT_VALUE);
        assertEquals(t.getShortBaseLength(), SHORT_BASE_VALUE, DELTA);
        assertEquals(t.getLongBaseLength(), LONG_BASE_VALUE, DELTA);
        assertEquals(t.getSide(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * 2 Bases and Area
     */
    @Test
    public void shouldCreateIsoscelesTrapezoidWithTwoBasesAndAreaLongAdShortAndCalculateOtherParameters() {
        IsoscelesTrapezoid t = IsoscelesTrapezoid.withTwoBaseAndArea(SHORT_BASE_VALUE, LONG_BASE_VALUE,
                AREA_VALUE);
        assertEquals(t.getShortBaseLength(), SHORT_BASE_VALUE, DELTA);
        assertEquals(t.getLongBaseLength(), LONG_BASE_VALUE, DELTA);
        assertEquals(t.getSide(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * LongBase, Side and Height
     */
    @Test
    public void shouldCreateIsoscelesTrapezoidWithLongBaseSideAndHeightAndCalculateOtherParameters() {
        IsoscelesTrapezoid t = IsoscelesTrapezoid.withLongBaseAndSideAndHeight(LONG_BASE_VALUE, SIDE_VALUE,
                HEIGHT_VALUE);
        assertEquals(t.getShortBaseLength(), SHORT_BASE_VALUE, DELTA);
        assertEquals(t.getLongBaseLength(), LONG_BASE_VALUE, DELTA);
        assertEquals(t.getSide(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * ShortBase, Side and Height
     */
    @Test
    public void shouldCreateIsoscelesTrapezoidWithShortBaseSideAndHeightAndCalculateOtherParameters() {
        IsoscelesTrapezoid t = IsoscelesTrapezoid.withShortBaseAndSideAndHeight(SHORT_BASE_VALUE, SIDE_VALUE,
                HEIGHT_VALUE);
        assertEquals(t.getShortBaseLength(), SHORT_BASE_VALUE, DELTA);
        assertEquals(t.getLongBaseLength(), LONG_BASE_VALUE, DELTA);
        assertEquals(t.getSide(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Base, Height and Area
     */
    @Test
    public void shouldCreateIsoscelesTrapezoidWithBaseHeightAndAreaAndCalculateOtherParameters() {
        IsoscelesTrapezoid t = IsoscelesTrapezoid.withBaseAndHeightAndArea(LONG_BASE_VALUE, HEIGHT_VALUE, AREA_VALUE);
        assertEquals(t.getShortBaseLength(), SHORT_BASE_VALUE, DELTA);
        assertEquals(t.getLongBaseLength(), LONG_BASE_VALUE, DELTA);
        assertEquals(t.getSide(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Side, Height and Area
     */
    @Test
    public void shouldCreateIsoscelesTrapezoidWithSideHeightAndAreaAndCalculateOtherParameters() {
        IsoscelesTrapezoid t = IsoscelesTrapezoid.withSideAndHeightAndArea(SIDE_VALUE, HEIGHT_VALUE, AREA_VALUE);
        assertEquals(t.getShortBaseLength(), SHORT_BASE_VALUE, DELTA);
        assertEquals(t.getLongBaseLength(), LONG_BASE_VALUE, DELTA);
        assertEquals(t.getSide(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by too long height for side
     */
    @Test
    public void shouldThrowExceptionAfterReceivingLongerHeightThanSide() {
        assertThrows(Exception.class,
                () -> IsoscelesTrapezoid.withLongBaseAndSideAndHeight(LONG_BASE_VALUE,
                        SIDE_VALUE, 2 * SIDE_VALUE));
    }

    /**
     * Checking exceptions caused by too long side for base
     */
    @Test
    public void shouldThrowExceptionAfterReceivingLongerSideThanDoubledBase() {
        assertThrows(Exception.class,
                () -> IsoscelesTrapezoid.withLongBaseAndSideAndHeight(LONG_BASE_VALUE,
                        2 * LONG_BASE_VALUE, 2 * HEIGHT_VALUE));
    }
}
