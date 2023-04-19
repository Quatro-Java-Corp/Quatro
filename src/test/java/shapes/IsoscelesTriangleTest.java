package shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit test for IsoscelesTriangle.
 */
public class IsoscelesTriangleTest {
    private final double DELTA = 1e-1;

    private final double SIDE_VALUE = 10;
    private final double BASE_VALUE = 4;
    private final double HEIGHT_VALUE = 9.7979589711327;
    private final double AREA_VALUE = 19.595917942265;
    private final double CIRCUIT_VALUE = 24;
    private final double NEGATIVE_VALUE = -13.5;
    private final double LONG_BASE_VALUE = 200;

    /**
     * Side And Base
     */
    @Test
    public void shouldCreateIsoscelesTriangleWithSideAndBaseAndCalculateOtherParameters() {
        IsoscelesTriangle t = IsoscelesTriangle.withSideAndBase(SIDE_VALUE, BASE_VALUE);
        
        assertEquals(t.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(t.getBaseLength(), BASE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Side And Surface Area
     */
    @Test
    public void shouldCreateIsoscelesTriangleWithSideAndSurfaceAreaAndCalculateOtherParameters() {
        IsoscelesTriangle t = IsoscelesTriangle.withSideAndSurfaceArea(SIDE_VALUE, AREA_VALUE);
        
        assertEquals(t.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(t.getBaseLength(), BASE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Side And Height
     */
    @Test
    public void shouldCreateIsoscelesTriangleWithSideAndHeightAndCalculateOtherParameters() {
        IsoscelesTriangle t = IsoscelesTriangle.withSideAndHeight(SIDE_VALUE, HEIGHT_VALUE);
        
        assertEquals(t.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(t.getBaseLength(), BASE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Base And Surface Area
     */
    @Test
    public void shouldCreateIsoscelesTriangleWithBaseAndSurfaceAreaAndCalculateOtherParameters() {
        IsoscelesTriangle t = IsoscelesTriangle.withBaseAndSurfaceArea(BASE_VALUE, AREA_VALUE);
        
        assertEquals(t.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(t.getBaseLength(), BASE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Base And Height
     */
    @Test
    public void shouldCreateIsoscelesTriangleWithBaseAndHeightAndCalculateOtherParameters() {
        IsoscelesTriangle t = IsoscelesTriangle.withBaseAndHeight(BASE_VALUE, HEIGHT_VALUE);
        
        assertEquals(t.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(t.getBaseLength(), BASE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Surface Area And Height
     */
    @Test
    public void shouldCreateIsoscelesTriangleWithSurfaceAreaAndHeightAndCalculateOtherParameters() {
        IsoscelesTriangle t = IsoscelesTriangle.withSurfaceAreaAndHeight(AREA_VALUE, HEIGHT_VALUE);
        
        assertEquals(t.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(t.getBaseLength(), BASE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSideLength() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withSideAndBase(NEGATIVE_VALUE, BASE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSideLengthAndArea() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withSideAndSurfaceArea(NEGATIVE_VALUE, AREA_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSideLengthAndHeight() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withSideAndHeight(NEGATIVE_VALUE, HEIGHT_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of base length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeBaseLength() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withSideAndBase(SIDE_VALUE, NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of base length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeBaseLengthAndArea() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withBaseAndSurfaceArea(NEGATIVE_VALUE, AREA_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of base length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeBaseLengthAndHeight() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withBaseAndHeight(NEGATIVE_VALUE, HEIGHT_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of height
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeHeight() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withSideAndHeight(SIDE_VALUE, NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of height
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeHeightAndBase() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withBaseAndHeight(BASE_VALUE, NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of height
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeHeightAndArea() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withSurfaceAreaAndHeight(AREA_VALUE, NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of area
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeArea() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withSideAndSurfaceArea(SIDE_VALUE, NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of area
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeAreaAndBase() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withBaseAndSurfaceArea(BASE_VALUE, NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of area
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeAreaAndHeight() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withSurfaceAreaAndHeight(NEGATIVE_VALUE, HEIGHT_VALUE));
    }

    /**
     * Checking exceptions caused by too long base
     */
    @Test
    public void shouldThrowExceptionAfterReceivingBaseTooLongForGivenSideLenght() {
        assertThrows(Exception.class, () -> IsoscelesTriangle.withSideAndBase(SIDE_VALUE, LONG_BASE_VALUE));
    }
}
