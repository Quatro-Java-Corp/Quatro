package shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Regular Triangle.
 */
public class RegularTriangleTest {
    private final double DELTA = 1e-2;

    private final double SIDE_VALUE = 19.2;
    private final double HEIGHT_VALUE = 16.6276877;
    private final double AREA_VALUE = 159.625802;
    private final double CIRCUIT_VALUE = 57.6;
    private final double NEGATIVE_VALUE = -13.592;
    private final double CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE = 11.08515;

    /**
     * Side length constructor
     */
    @Test
    public void shouldCreateRegularTriangleWithSideLengthAndCalculateOtherParameters() {
        RegularTriangle t = RegularTriangle.withSide(SIDE_VALUE);

        assertEquals(t.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Height constructor
     */
    @Test
    public void shouldCreateRegularTriangleWithHeightAndCalculateOtherParameters() {
        RegularTriangle t = RegularTriangle.withHeight(HEIGHT_VALUE);

        assertEquals(t.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Surface area constructor
     */
    @Test
    public void shouldCreateRegularTriangleWithSurfaceAreaAndCalculateOtherParameters() {
        RegularTriangle t = RegularTriangle.withSurfaceArea(AREA_VALUE);

        assertEquals(t.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSideLength() {
        assertThrows(Exception.class, () -> RegularTriangle.withSide(NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of height length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeDiagonaLength() {
        assertThrows(Exception.class, () -> RegularTriangle.withHeight(NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() {
        assertThrows(Exception.class, () -> RegularTriangle.withSurfaceArea(NEGATIVE_VALUE));
    }

    @Test
    void shouldReturnCircleWithCorrectRadiusWhenProvidingCircumscribedCircle() {
        RegularTriangle t = RegularTriangle.withSide(SIDE_VALUE);
        var c = assertDoesNotThrow(t.getCircumscribedCircle()::get);
        assertEquals(CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE, c.getRadius(),DELTA);
    }
}
