package shapes;

import org.junit.jupiter.api.Test;

import exceptions.argument.NegativeArgumentValueException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Ellipse.
 */
public class EllipseTest {
    private final double DELTA = 1e-2;

    private final double SEMI_MINOR_AXIS_VALUE = 8.2;
    private final double SEMI_MAJOR_AXIS_VALUE = 12.6;
    private final double AREA_VALUE = 324.589352968;
    private final double CIRCUIT_VALUE = 66.089;
    private final double NEGATIVE_VALUE = -5.4;
    private final double CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE = 12.6;
    private final double DOUBLED_SEMI_MINOR_AXIS_VALUE = SEMI_MINOR_AXIS_VALUE * Math.sqrt(2);
    private final double DOUBLED_SEMI_MAJOR_AXIS_VALUE = SEMI_MAJOR_AXIS_VALUE * Math.sqrt(2);
    private final double DOUBLED_AREA_VALUE = 2 * AREA_VALUE;

    /**
     * Axes constructor
     */
    @Test
    public void shouldCreateEllipseWithAxesAndCalculateOtherParameters() {
        Ellipse ellipse = Ellipse.withAxes(SEMI_MINOR_AXIS_VALUE, SEMI_MAJOR_AXIS_VALUE);

        assertEquals(ellipse.getSemiMinorAxis(), SEMI_MINOR_AXIS_VALUE, DELTA);
        assertEquals(ellipse.getSemiMajorAxis(), SEMI_MAJOR_AXIS_VALUE, DELTA);
        assertEquals(ellipse.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(ellipse.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Semi-minor axis and surface area constructor
     */
    @Test
    public void shouldCreateEllipseWithSemiMinorAxisAndSurfaceAreaAndCalculateOtherParameters() {
        Ellipse ellipse = Ellipse.withSemiMinorAxisAndSurfaceArea(SEMI_MINOR_AXIS_VALUE, AREA_VALUE);

        assertEquals(ellipse.getSemiMinorAxis(), SEMI_MINOR_AXIS_VALUE, DELTA);
        assertEquals(ellipse.getSemiMajorAxis(), SEMI_MAJOR_AXIS_VALUE, DELTA);
        assertEquals(ellipse.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(ellipse.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Semi-major axis and surface area constructor
     */
    @Test
    public void shouldCreateEllipseWithSemiMajorAxisAndSurfaceAreaAndCalculateOtherParameters() {
        Ellipse ellipse = Ellipse.withSemiMajorAxisAndSurfaceArea(SEMI_MAJOR_AXIS_VALUE, AREA_VALUE);

        assertEquals(ellipse.getSemiMinorAxis(), SEMI_MINOR_AXIS_VALUE, DELTA);
        assertEquals(ellipse.getSemiMajorAxis(), SEMI_MAJOR_AXIS_VALUE, DELTA);
        assertEquals(ellipse.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(ellipse.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of semi-minor axis
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSemiMinorAxis() {
        assertThrows(NegativeArgumentValueException.class, () -> Ellipse.withAxes(NEGATIVE_VALUE, SEMI_MAJOR_AXIS_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of semi-major axis
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSemiMajorAxis() {
        assertThrows(NegativeArgumentValueException.class, () -> Ellipse.withAxes(SEMI_MINOR_AXIS_VALUE, NEGATIVE_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() {
        assertThrows(NegativeArgumentValueException.class, () -> Ellipse.withSemiMinorAxisAndSurfaceArea(SEMI_MINOR_AXIS_VALUE, NEGATIVE_VALUE));
    }

    @Test
    void shouldReturnCircleWithCorrectRadiusWhenProvidingCircumscribedCircle() {
        Ellipse ellipse = Ellipse.withAxes(SEMI_MINOR_AXIS_VALUE, SEMI_MAJOR_AXIS_VALUE);
        var circle = assertDoesNotThrow(ellipse.getCircumscribedCircle()::get);
        assertEquals(CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE, circle.getRadius(), DELTA);
    }

    /**
     * Doubled sized method
     */
    @Test
    public void shouldReturnEllipseWithDoubledSurfaceArea() {
        Ellipse ellipse = Ellipse.withAxes(SEMI_MINOR_AXIS_VALUE, SEMI_MAJOR_AXIS_VALUE);
        Ellipse doubledEllipse = ellipse.getDoubledSized();

        assertEquals(doubledEllipse.getSemiMinorAxis(), DOUBLED_SEMI_MINOR_AXIS_VALUE, DELTA);
        assertEquals(doubledEllipse.getSemiMajorAxis(), DOUBLED_SEMI_MAJOR_AXIS_VALUE, DELTA);
        assertEquals(doubledEllipse.getSurfaceArea(), DOUBLED_AREA_VALUE, DELTA);
    }
 }
 
