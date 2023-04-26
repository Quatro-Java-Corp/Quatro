package shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Right Triangle.
 */
public class RightTriangleTest {
    private final double DELTA = 1e-2;

    private final double SHORT_CATHETUS_LENGTH = 3;
    private final double LONG_CATHETUS_LENGTH = 4;
    private final double HYPOTENUSE_LENGTH = 5;
    private final double AREA_VALUE = 6;
    private final double CIRCUIT_VALUE = 12;
    private final double NEGATIVE_VALUE = -13.592;
    private final double CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE = 2.5;

    /**
     * Catheti  constructor
     */
    @Test
    public void shouldCreateRightTriangleWithCathetiAndCalculateOtherParameters() {
        RightTriangle t = RightTriangle.withCatheti(LONG_CATHETUS_LENGTH, SHORT_CATHETUS_LENGTH);

        assertEquals(t.getShortCathetusLength(), SHORT_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getLongCathetusLength(), LONG_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getHypotenuse(), HYPOTENUSE_LENGTH, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Cathetus and Hypotenuse constructor
     */
    @Test
    public void shouldCreateRightTriangleWithCathetusAndHypotenuseAndCalculateOtherParameters() {
        RightTriangle t = RightTriangle.withCathetusAndHypotenuse(SHORT_CATHETUS_LENGTH, HYPOTENUSE_LENGTH);

        assertEquals(t.getShortCathetusLength(), SHORT_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getLongCathetusLength(), LONG_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getHypotenuse(), HYPOTENUSE_LENGTH, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    /**
     * Surface area constructor
     */
    @Test
    public void shouldCreateRightTriangleWithCathetusAndSurfaceAreaAndCalculateOtherParameters() {
        RightTriangle t = RightTriangle.withCathetusAndSurfaceArea(SHORT_CATHETUS_LENGTH, AREA_VALUE);

        assertEquals(t.getShortCathetusLength(), SHORT_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getLongCathetusLength(), LONG_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getHypotenuse(), HYPOTENUSE_LENGTH, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }

    @Test
    public void shouldCreateRightTriangleWithHypotenuseAndSurfaceAreaAndCalculateOtherParameters() {
        RightTriangle t = RightTriangle.withHypotenuseAndSurfaceArea(HYPOTENUSE_LENGTH, AREA_VALUE);

        assertEquals(t.getShortCathetusLength(), SHORT_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getLongCathetusLength(), LONG_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getHypotenuse(), HYPOTENUSE_LENGTH, DELTA);
        assertEquals(t.getSurfaceArea(), AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), CIRCUIT_VALUE, DELTA);
    }


    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeCathetiLength() {
        assertThrows(Exception.class, () -> RightTriangle.withCatheti(NEGATIVE_VALUE, SHORT_CATHETUS_LENGTH));
    }

    /**
     * Checking exceptions caused by negative value of height length
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeHypotenuseLength() {
        assertThrows(Exception.class, () -> RightTriangle.withHypotenuseAndSurfaceArea(NEGATIVE_VALUE, AREA_VALUE));
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() {
        assertThrows(Exception.class, () -> RightTriangle.withCathetusAndSurfaceArea(SHORT_CATHETUS_LENGTH, NEGATIVE_VALUE));
    }

    @Test
    void shouldReturnCircleWithCorrectRadiusWhenProvidingCircumscribedCircle() {
        RightTriangle t = RightTriangle.withCatheti(SHORT_CATHETUS_LENGTH, LONG_CATHETUS_LENGTH);
        var c = assertDoesNotThrow(t.getCircumscribedCircle()::get);
        assertEquals(CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE, c.getRadius(), DELTA);
    }
}
