import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for Circle.
 */
public class CircleTest {
    private final double DELTA = 1e-2;

    private final double RADIUS_VALUE = 17.3;
    private final double DIAMETER_VALUE = 34.6;
    private final double CIRCUT_VALUE = 108.699105814;
    private final double AREA_VALUE = 940.247265293;
    private final double NEGATIVE_VALUE = -13.5;

    /**
     * Radius constructor
     */
    @Test
    public void shouldCreateCircleWithRadiusAndCalculateOtherParameters() throws Exception
    {
        Circle c = new Circle(RADIUS_VALUE, Circle.ConstructorType.radius);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Diameter constructor
     */
    @Test
    public void shouldCreateCircleWithDiameterAndCalculateOtherParameters() throws Exception
    {
        Circle c = new Circle(DIAMETER_VALUE, Circle.ConstructorType.diameter);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Circut constructor
     */
    @Test
    public void shouldCreateCircleWithCircutAndCalculateOtherParameters() throws Exception
    {
        Circle c = new Circle(CIRCUT_VALUE, Circle.ConstructorType.circuit);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Surface area constructor
     */
    @Test
    public void shouldCreateCircleWithSurfaceAreaAndCalculateOtherParameters() throws Exception
    {
        Circle c = new Circle(AREA_VALUE, Circle.ConstructorType.surfaceArea);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of radius
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeRadius() throws Exception
    {
        new Circle(NEGATIVE_VALUE, Circle.ConstructorType.radius);
    }

    /**
     * Checking exceptions caused by negative value of diameter
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeDiameter() throws Exception
    {
        new Circle(NEGATIVE_VALUE, Circle.ConstructorType.diameter);
    }

    /**
     * Checking exceptions caused by negative value of circut
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeCircut() throws Exception
    {
        new Circle(NEGATIVE_VALUE, Circle.ConstructorType.circuit);
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() throws Exception
    {
        new Circle(NEGATIVE_VALUE, Circle.ConstructorType.surfaceArea);
    }
}
