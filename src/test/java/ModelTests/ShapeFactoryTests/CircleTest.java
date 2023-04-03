package ModelTests.ShapeFactoryTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Model.ShapeFactory;
import Model.Shapes.Circle;

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

    private ShapeFactory shapeFactory;

    @Before
    public void initialize() {
        shapeFactory = new ShapeFactory();
    }

    /**
     * Radius constructor
     */
    @Test
    public void shouldCreateCircleWithRadiusAndCalculateOtherParameters() throws Exception {
        String[] types = { "radius" };
        Double[] values = { RADIUS_VALUE };

        Circle c = (Circle) shapeFactory.createShape("circle", types, values);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Diameter constructor
     */
    @Test
    public void shouldCreateCircleWithDiameterAndCalculateOtherParameters() throws Exception {
        String[] types = { "diameter" };
        Double[] values = { DIAMETER_VALUE };

        Circle c = (Circle) shapeFactory.createShape("circle", types, values);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Circut constructor
     */
    @Test
    public void shouldCreateCircleWithCircutAndCalculateOtherParameters() throws Exception {
        String[] types = { "circuit" };
        Double[] values = { CIRCUT_VALUE };

        Circle c = (Circle) shapeFactory.createShape("circle", types, values);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Surface area constructor
     */
    @Test
    public void shouldCreateCircleWithSurfaceAreaAndCalculateOtherParameters() throws Exception {
        String[] types = { "surfaceArea" };
        Double[] values = { AREA_VALUE };

        Circle c = (Circle) shapeFactory.createShape("circle", types, values);

        assertEquals(c.getRadius(), RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCUT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of radius
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeRadius() throws Exception {
        String[] types = { "radius" };
        Double[] values = { NEGATIVE_VALUE };

        shapeFactory.createShape("circle", types, values);
    }

    /**
     * Checking exceptions caused by negative value of diameter
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeDiameter() throws Exception {
        String[] types = { "radius" };
        Double[] values = { NEGATIVE_VALUE };

        shapeFactory.createShape("circle", types, values);

        new Circle(NEGATIVE_VALUE, Circle.ConstructorType.diameter);
    }

    /**
     * Checking exceptions caused by negative value of circut
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeCircut() throws Exception {
        String[] types = { "circuit" };
        Double[] values = { NEGATIVE_VALUE };

        shapeFactory.createShape("circle", types, values);
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() throws Exception {
        String[] types = { "surfaceArea" };
        Double[] values = { NEGATIVE_VALUE };

        shapeFactory.createShape("circle", types, values);
    }
}
