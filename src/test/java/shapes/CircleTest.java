package shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit test for Circle.
 */
public class CircleTest {
    private final double DELTA = 1e-2;

    private final double RADIUS_VALUE = 17.3;
    private final double DIAMETER_VALUE = 34.6;
    private final double CIRCUIT_VALUE = 108.699105814;
    private final double AREA_VALUE = 940.247265293;
    private final double NEGATIVE_VALUE = -13.5;

    /**
     * Radius constructor
     */
    @Test
    public void shouldCreateCircleWithRadiusAndCalculateOtherParameters() {
        Circle c = Circle.withRadius(RADIUS_VALUE);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUIT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Diameter constructor
     */
    @Test
    public void shouldCreateCircleWithDiameterAndCalculateOtherParameters() {
        Circle c = Circle.withDiameter(DIAMETER_VALUE);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUIT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Circuit constructor
     */
    @Test
    public void shouldCreateCircleWithCircuitAndCalculateOtherParameters() {
        Circle c = Circle.withCircuit(CIRCUIT_VALUE);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUIT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Surface area constructor
     */
    @Test
    public void shouldCreateCircleWithSurfaceAreaAndCalculateOtherParameters() {
        Circle c = Circle.withSurfaceArea(AREA_VALUE);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUIT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of radius
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeRadius() {
        assertThrows(Exception.class, () -> Circle.withRadius(NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of diameter
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeDiameter() {
        assertThrows(Exception.class, () -> Circle.withDiameter(NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of circut
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeCircuit() {
        assertThrows(Exception.class, () -> Circle.withCircuit(NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() {
        assertThrows(Exception.class, () -> Circle.withSurfaceArea(NEGATIVE_VALUE));
    }
}
