package shapes;

import org.junit.jupiter.api.Test;

import exceptions.argument.NegativeArgumentValueException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Regular Hexagon.
 */
public class RegularHexagonTest {
    private final double DELTA = 1e-2;

    private final double SIDE_VALUE = 3.0;
    private final double AREA_VALUE = 23.3826859;
    private final double CIRCUIT_VALUE = 18.0;
    private final double NEGATIVE_VALUE = -13.592;
    private final double CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE = SIDE_VALUE;
    private final double DOUBLED_AREA_VALUE = 2 * AREA_VALUE;

    /**
     * Side length constructor
     */
    @Test
    public void shouldCreateRegularHexagonWithSideLengthAndCalculateOtherParameters() {
        RegularHexagon h = RegularHexagon.withSide(SIDE_VALUE);

        assertEquals(h.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(h.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(h.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Circuit constructor
     */
    @Test
    public void shouldCreateRegularHexagonWithCircuitAndCalculateOtherParameters() {
        RegularHexagon h = RegularHexagon.withCircuit(CIRCUIT_VALUE);

        assertEquals(h.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(h.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(h.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Surface area constructor
     */
    @Test
    public void shouldCreateRegularHexagonWithSurfaceAreaAndCalculateOtherParameters() {
        RegularHexagon h = RegularHexagon.withSurfaceArea(AREA_VALUE);

        assertEquals(h.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(h.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(h.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSideLength() {
        assertThrows(NegativeArgumentValueException.class, () -> RegularHexagon.withSide(NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of circuit length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeDiagonaLength() {
        assertThrows(NegativeArgumentValueException.class, () -> RegularHexagon.withCircuit(NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() {
        assertThrows(NegativeArgumentValueException.class, () -> RegularHexagon.withSurfaceArea(NEGATIVE_VALUE));
    }

    @Test
    void shouldReturnCircleWithCorrectRadiusWhenProvidingCircumscribedCircle() {
        RegularHexagon h = RegularHexagon.withSide(SIDE_VALUE);
        var c = assertDoesNotThrow(h.getCircumscribedCircle()::get);
        assertEquals(CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE, c.getRadius(), DELTA);
    }

    /**
     * Doubled sized method
     */
    @Test
    public void shouldReturnRegularTriangleWithDoubledSurfaceArea() {
        RegularHexagon h = RegularHexagon.withSurfaceArea(AREA_VALUE);
        RegularHexagon h2 = h.getDoubledSized();

        assertEquals(h2.getSurfaceArea(), DOUBLED_AREA_VALUE, DELTA);
    }
}
