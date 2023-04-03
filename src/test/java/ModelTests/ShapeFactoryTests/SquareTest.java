package ModelTests.ShapeFactoryTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Model.ShapeFactory;
import Model.Shapes.Square;

/**
 * Unit test for Square.
 */
public class SquareTest {
    private final double DELTA = 1e-2;

    private final double SIDE_VALUE = 17.3;
    private final double DIAGONAL_VALUE = 24.465894629;
    private final double AREA_VALUE = 299.29;
    private final double NEGATIVE_VALUE = -13.5;;

    private ShapeFactory shapeFactory;

    @Before
    public void initialize() {
        shapeFactory = new ShapeFactory();
    }

    /**
     * Side length constructor
     */
    @Test
    public void shouldCreateSquareWithSideLengthAndCalculateOtherParameters() throws Exception {
        String[] types = { "sideLength" };
        Double[] values = { SIDE_VALUE };

        Square s = (Square) shapeFactory.createShape("square", types, values);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Diagonal length constructor
     */
    @Test
    public void shouldCreateSquareWithDiagonalLengthAndCalculateOtherParameters() throws Exception {
        String[] types = { "diagonalLength" };
        Double[] values = { DIAGONAL_VALUE };

        Square s = (Square) shapeFactory.createShape("square", types, values);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Surface area constructor
     */
    @Test
    public void shouldCreateSquareWithSurfaceAreaAndCalculateOtherParameters() throws Exception {
        String[] types = { "surfaceArea" };
        Double[] values = { AREA_VALUE };

        Square s = (Square) shapeFactory.createShape("square", types, values);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeSideLength() throws Exception {
        String[] types = { "sideLength" };
        Double[] values = { NEGATIVE_VALUE };

        shapeFactory.createShape("square", types, values);
    }

    /**
     * Checking exceptions caused by negative value of diagonal length
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeDiagonaLength() throws Exception {
        String[] types = { "diagonalLength" };
        Double[] values = { NEGATIVE_VALUE };

        shapeFactory.createShape("square", types, values);
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() throws Exception {
        String[] types = { "surfaceArea" };
        Double[] values = { NEGATIVE_VALUE };

        shapeFactory.createShape("square", types, values);
    }
}
