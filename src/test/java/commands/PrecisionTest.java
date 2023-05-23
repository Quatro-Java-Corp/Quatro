package commands;

import input.InputHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import repository.ShapeRepository;
import utils.Format;

public class PrecisionTest {
    // Regular Triangle data
    private final double LONG_DOUBLE = 19.8746328748324623874;
    private final String LONG_DOUBLE_PRECISION_STANDARD = "19.87";
    private final String LONG_DOUBLE_PRECISION_ZERO = "20";
    private final String LONG_DOUBLE_PRECISION_ONE = "19.9";
    private final String LONG_DOUBLE_PRECISION_SEVEN = "19.8746329";

    private ShapeRepository shapeRepository = new ShapeRepository();
    private InputHandler inputHandler = new InputHandler(shapeRepository);

    /**
     * Standard 2 digits precision
     */
    @Test
    public void shouldShowStandardPrecisionWithTwoDigits() {
        assertEquals(LONG_DOUBLE_PRECISION_STANDARD, Format.format(LONG_DOUBLE));
    }

    /**
     * Change precision
     */
    @Test
    public void shouldChangePrecision() {
        inputHandler.parseInput("precision 0");
        assertEquals(LONG_DOUBLE_PRECISION_ZERO, Format.format(LONG_DOUBLE));

        inputHandler.parseInput("precision 1");
        assertEquals(LONG_DOUBLE_PRECISION_ONE, Format.format(LONG_DOUBLE));

        inputHandler.parseInput("precision 7");
        assertEquals(LONG_DOUBLE_PRECISION_SEVEN, Format.format(LONG_DOUBLE));

        inputHandler.parseInput("precision 2");
        assertEquals(LONG_DOUBLE_PRECISION_STANDARD, Format.format(LONG_DOUBLE));
    }

    /**
     * Checking not changing precision
     */
    @Test
    public void shouldThrowNotChangePrecisionAfterReceivingNonNumericArgument() {
        inputHandler.parseInput("precision 1");
        assertEquals(LONG_DOUBLE_PRECISION_ONE, Format.format(LONG_DOUBLE));
        inputHandler.parseInput("precision re");
        assertEquals(LONG_DOUBLE_PRECISION_ONE, Format.format(LONG_DOUBLE));

    }
}
