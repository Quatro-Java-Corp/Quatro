import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import shapes.Rectangle;

/**
 * Unit test for shapes.Rectangle.
 */
public class InputHandlerTest {
    private final double DELTA = 1e-2;

    private final double LONG_SIDE_VALUE = 4;
    private final double SHORT_SIDE_VALUE = 3;
    private final double DIAGONAL_VALUE = 5;
    private final double AREA_VALUE = 12;

    private InputHandler inputHandler = new InputHandler();

    /**
     * Short Side And Long Side
     */
    @Test
    public void shouldCreateRectangleWithShortSideAndLongSideAndCalculateOtherParameters() throws Exception {
        String[] args = String.format("rectangle side %4f side %4f", SHORT_SIDE_VALUE, LONG_SIDE_VALUE).split(" ");

        Rectangle r = assertDoesNotThrow(() -> (Rectangle) inputHandler.createFigureWithArguments(args));
        assertEquals(r.getShortSideLength(), SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getLongSideLength(), LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
    }
}
