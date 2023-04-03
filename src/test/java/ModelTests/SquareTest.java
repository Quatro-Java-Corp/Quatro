package ModelTests;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

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

    /**
     * Side length constructor
     */
    @Test
    public void shouldCreateSquareWithSideLengthAndCalculateOtherParameters() throws Exception
    {
        Square s = new Square(SIDE_VALUE, Square.ConstructorType.sideLength);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Diagonal length constructor
     */
    @Test
    public void shouldCreateSquareWithDiagonalLengthAndCalculateOtherParameters() throws Exception
    {
        Square s = new Square(DIAGONAL_VALUE, Square.ConstructorType.diagonalLength);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Surface area constructor
     */
    @Test
    public void shouldCreateSquareWithSurfaceAreaAndCalculateOtherParameters() throws Exception
    {
        Square s = new Square(AREA_VALUE, Square.ConstructorType.surfaceArea);

        assertEquals(s.getSideLength(), SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), AREA_VALUE, DELTA);
    }

    /**
     * Checking exceptions caused by negative value of side length
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeSideLength() throws Exception
    {
        new Square(NEGATIVE_VALUE, Square.ConstructorType.sideLength);
    }

    /**
     * Checking exceptions caused by negative value of diagonal length
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeDiagonaLength() throws Exception
    {
        new Square(NEGATIVE_VALUE, Square.ConstructorType.diagonalLength);
    }

    /**
     * Checking exceptions caused by negative value of surface area
     */
    @Test(expected = Exception.class)
    public void shouldThrowExceptionAfterReceivingNegativeSurfaceArea() throws Exception
    {
        new Square(NEGATIVE_VALUE, Square.ConstructorType.surfaceArea);
    }
}
