import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import command.CommandFactory;
import org.junit.jupiter.api.Test;
import shapes.Rectangle;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

import input.InputHandler;

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
    public void shouldCreateRectangleWithShortSideAndLongSideAndCalculateOtherParameters() {
        Queue<String> args = new LinkedList<>(List.of("rectangle", "side", String.valueOf(SHORT_SIDE_VALUE), "side", String.valueOf(LONG_SIDE_VALUE)));

        Rectangle r = assertDoesNotThrow(() -> (Rectangle) inputHandler.createFigureWithArguments(args));
        assertEquals(r.getShortSideLength(), SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getLongSideLength(), LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), AREA_VALUE, DELTA);
    }
}
