package shapes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import exceptions.argument.NegativeArgumentValueException;
import exceptions.shape.IllegalTriangleSidesException;

/**
 * Unit test for Triangle.
 */
public class TriangleTest {
    private final double DELTA = 1e-2;

    private final double SIDE_A_VALUE = 10;
    private final double SIDE_B_VALUE = 12;
    private final double SIDE_C_VALUE = 13;
    private final double AREA_VALUE = 56.99506557589;
    private final double CIRCUIT_VALUE = 35;
    private final double CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE = 6.842697;
    private final double NEGATIVE_VALUE = -13.5;
    private final double LONG_SIDE_VALUE = 200;
    private final double DOUBLED_AREA_VALUE = 2 * AREA_VALUE;

    /**
     * Valid triangle
     */
    @Test
    public void shouldCreateValidTriangleAndCalculateOtherParameters() {
        Triangle t = new Triangle(SIDE_A_VALUE, SIDE_B_VALUE, SIDE_C_VALUE);

        assertEquals(t.getShortSide(), SIDE_A_VALUE, DELTA);
        assertEquals(t.getMediumSide(), SIDE_B_VALUE, DELTA);
        assertEquals(t.getLongSide(), SIDE_C_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSideLength() {
        assertThrows(NegativeArgumentValueException.class,
                () -> new Triangle(NEGATIVE_VALUE, SIDE_B_VALUE, SIDE_C_VALUE));
    }

    /**
     * Checking exceptions caused by too long side
     */
    @Test
    public void shouldThrowExceptionAfterReceivingSideTooLongForGivenSidesLenght() {
        assertThrows(IllegalTriangleSidesException.class,
                () -> new Triangle(LONG_SIDE_VALUE, SIDE_B_VALUE, SIDE_C_VALUE));
    }

    /**
     * Doubled sized method
     */
    @Test
    public void shouldReturnTriangleWithDoubledSurfaceArea() {
        Triangle t = new Triangle(SIDE_A_VALUE, SIDE_B_VALUE, SIDE_C_VALUE);
        Triangle doubledT = t.getDoubledSized();

        assertEquals(doubledT.getSurfaceArea(), DOUBLED_AREA_VALUE, DELTA);
    }

    /**
     * Circumscribed circle calculation
     */
    @Test
    public void shouldCalculateCircumscribedCircle() {
        Triangle t = new Triangle(SIDE_A_VALUE, SIDE_B_VALUE, SIDE_C_VALUE);
        var c = t.getCircumscribedCircle().get();

        assertEquals(c.getRadius(), CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE, DELTA);
    }
}
