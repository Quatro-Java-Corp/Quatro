package commands;

import input.InputHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import repository.ShapeRepository;
import shapes.Square;
import shapes.RegularHexagon;
import utils.Dictionary;

public class LanguageTest {
    private final double DELTA = 1e-2;

    // Square data
    private final double SQUARE_SIDE_VALUE = 17.3;
    private final double SQUARE_DIAGONAL_VALUE = 24.465894629;
    private final double SQUARE_AREA_VALUE = 299.29;
    private final double SQUARE_CIRCUIT_VALUE = 69.2;

    // Regular Hexagon data
    private final double REGULAR_HEXAGON_SIDE_VALUE = 3.0;
    private final double REGULAR_HEXAGON_AREA_VALUE = 23.3826859;
    private final double REGULAR_HEXAGON_CIRCUIT_VALUE = 18.0;
    private final double REGULAR_HEXAGON_NEGATIVE_VALUE = -13.592;
    private final double REGULAR_HEXAGON_CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE = REGULAR_HEXAGON_SIDE_VALUE;
    private final double REGULAR_HEXAGON_DOUBLED_AREA_VALUE = 2 * REGULAR_HEXAGON_AREA_VALUE;

    /**
     * Change language
     */
    @Test
    public void shouldChangeLanguage() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);
        Dictionary.activeLanguage = Dictionary.Language.ENG;

        assertEquals(Dictionary.activeLanguage, Dictionary.Language.ENG);

        inputHandler.parseInput("language PL");
        assertEquals(Dictionary.activeLanguage, Dictionary.Language.PL);

        inputHandler.parseInput("jezyk ENG");
        assertEquals(Dictionary.activeLanguage, Dictionary.Language.ENG);
    }

    /**
     * Square with PL command
     */
    @Test
    public void shouldCreateSquareWithSideWithPLCommand() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput("language PL");
        assertEquals(Dictionary.activeLanguage, Dictionary.Language.PL);

        inputHandler.parseInput(String.format(Locale.US, "dodaj kwadrat bok %f", SQUARE_SIDE_VALUE));

        Square s = (Square) shapeRepository.get(0).get();
        assertEquals(s.getSideLength(), SQUARE_SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), SQUARE_DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), SQUARE_AREA_VALUE, DELTA);
        assertEquals(s.getCircuit(), SQUARE_CIRCUIT_VALUE, DELTA);

        inputHandler.parseInput("jezyk ENG");
        assertEquals(Dictionary.activeLanguage, Dictionary.Language.ENG);
    }

    /**
     * Regular Hexagon with PL command
     */
    @Test
    public void shouldCreateRegularHexagonWithSideWithPLCommand() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput("language PL");
        assertEquals(Dictionary.activeLanguage, Dictionary.Language.PL);

        inputHandler.parseInput(String.format(Locale.US, "dodaj sześciokątforemny bok %f", REGULAR_HEXAGON_SIDE_VALUE));

        RegularHexagon h = (RegularHexagon) shapeRepository.get(0).get();
        assertEquals(h.getSideLength(), REGULAR_HEXAGON_SIDE_VALUE, DELTA);
        assertEquals(h.getSurfaceArea(), REGULAR_HEXAGON_AREA_VALUE, DELTA);
        assertEquals(h.getCircuit(), REGULAR_HEXAGON_CIRCUIT_VALUE, DELTA);

        inputHandler.parseInput("jezyk ENG");
        assertEquals(Dictionary.activeLanguage, Dictionary.Language.ENG);
    }
}
