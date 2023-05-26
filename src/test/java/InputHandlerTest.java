import input.InputHandler;
import org.junit.jupiter.api.Test;
import repository.ShapeRepository;
import shapes.*;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {
    private final double DELTA = 1e-2;

    // Square data
    private final double SQUARE_SIDE_VALUE = 17.3;
    private final double SQUARE_DIAGONAL_VALUE = 24.465894629;
    private final double SQUARE_AREA_VALUE = 299.29;
    private final double SQUARE_CIRCUIT_VALUE = 69.2;
    private final double SQUARE_CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE = 12.23;
    private final double SQUARE_DOUBLED_AREA_VALUE = 2 * SQUARE_AREA_VALUE;

    // Circle data
    private final double CIRCLE_RADIUS_VALUE = 17.3;
    private final double CIRCLE_DIAMETER_VALUE = 34.6;
    private final double CIRCLE_CIRCUIT_VALUE = 108.699105814;
    private final double CIRCLE_AREA_VALUE = 940.247265293;

    // Ellipse data
    private final double ELLIPSE_SEMI_MINOR_AXIS_VALUE = 8.2;
    private final double ELLIPSE_SEMI_MAJOR_AXIS_VALUE = 12.6;
    private final double ELLIPSE_AREA_VALUE = 324.589352968;
    private final double ELLIPSE_CIRCUIT_VALUE = 66.089;

    // IsoscelesTriangle data
    private final double ISOSCELES_TRIANGLE_SIDE_VALUE = 10;
    private final double ISOSCELES_TRIANGLE_BASE_VALUE = 4;
    private final double ISOSCELES_TRIANGLE_HEIGHT_VALUE = 9.7979589711327;
    private final double ISOSCELES_TRIANGLE_AREA_VALUE = 19.595917942265;
    private final double ISOSCELES_TRIANGLE_CIRCUIT_VALUE = 24;

    // Rectangle data
    private final double RECTANGLE_LONG_SIDE_VALUE = 4;
    private final double RECTANGLE_SHORT_SIDE_VALUE = 3;
    private final double RECTANGLE_DIAGONAL_VALUE = 5;
    private final double RECTANGLE_AREA_VALUE = 12;
    private final double RECTANGLE_CIRCUIT_VALUE = 14;

    // Regular Triangle data
    private final double REGULAR_TRIANGLE_SIDE_VALUE = 19.2;
    private final double REGULAR_TRIANGLE_HEIGHT_VALUE = 16.6276877;
    private final double REGULAR_TRIANGLE_AREA_VALUE = 159.625802;
    private final double REGULAR_TRIANGLE_CIRCUIT_VALUE = 57.6;

    // Rhombus data
    private final double RHOMBUS_SIDE_VALUE = 5;
    private final double RHOMBUS_LONG_DIAGONAL_VALUE = 8;
    private final double RHOMBUS_SHORT_DIAGONAL_VALUE = 6;
    private final double RHOMBUS_AREA_VALUE = 24;
    private final double RHOMBUS_CIRCUIT_VALUE = 20;

    // Right Triangle data
    private final double RIGHT_TRIANGLE_SHORT_CATHETUS_LENGTH = 3;
    private final double RIGHT_TRIANGLE_LONG_CATHETUS_LENGTH = 4;
    private final double RIGHT_TRIANGLE_HYPOTENUSE_LENGTH = 5;
    private final double RIGHT_TRIANGLE_AREA_VALUE = 6;
    private final double RIGHT_TRIANGLE_CIRCUIT_VALUE = 12;

    /**
     * Square with side length
     */
    @Test
    public void shouldCreateSquareWithSide() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput(String.format(Locale.US, "add square side %f", SQUARE_SIDE_VALUE));

        Square s = (Square) shapeRepository.get(0).get();
        assertEquals(s.getSideLength(), SQUARE_SIDE_VALUE, DELTA);
        assertEquals(s.getDiagonalLength(), SQUARE_DIAGONAL_VALUE, DELTA);
        assertEquals(s.getSurfaceArea(), SQUARE_AREA_VALUE, DELTA);
        assertEquals(s.getCircuit(), SQUARE_CIRCUIT_VALUE, DELTA);
    }

    /**
     * Circle with radius
     */
    @Test
    public void shouldCreateCircleWithRadius() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput(String.format(Locale.US, "add circle radius %f", CIRCLE_RADIUS_VALUE));

        Circle c = (Circle) shapeRepository.get(0).get();
        assertEquals(c.getRadius(), CIRCLE_RADIUS_VALUE, DELTA);
        assertEquals(c.getDiameter(), CIRCLE_DIAMETER_VALUE, DELTA);
        assertEquals(c.getCircuit(), CIRCLE_CIRCUIT_VALUE, DELTA);
        assertEquals(c.getSurfaceArea(), CIRCLE_AREA_VALUE, DELTA);
    }

    /**
     * Ellipse with semi-major and semi-minor axes
     */
    @Test
    public void shouldCreateEllipseWithAxes() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput(String.format(Locale.US, "add ellipse semimajoraxis %f semiminoraxis %f",
                ELLIPSE_SEMI_MAJOR_AXIS_VALUE, ELLIPSE_SEMI_MINOR_AXIS_VALUE));

        Ellipse e = (Ellipse) shapeRepository.get(0).get();
        assertEquals(e.getSemiMajorAxis(), ELLIPSE_SEMI_MAJOR_AXIS_VALUE, DELTA);
        assertEquals(e.getSemiMinorAxis(), ELLIPSE_SEMI_MINOR_AXIS_VALUE, DELTA);
        assertEquals(e.getCircuit(), ELLIPSE_CIRCUIT_VALUE, DELTA);
        assertEquals(e.getSurfaceArea(), ELLIPSE_AREA_VALUE, DELTA);
    }

    /**
     * IsoscelesTriangle with side and base
     */
    @Test
    public void shouldCreateIsoscelesTriangleWithSideAndBase() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput(String.format(Locale.US, "add isoscelestriangle side %f base %f",
                ISOSCELES_TRIANGLE_SIDE_VALUE, ISOSCELES_TRIANGLE_BASE_VALUE));

        IsoscelesTriangle t = (IsoscelesTriangle) shapeRepository.get(0).get();
        assertEquals(t.getSideLength(), ISOSCELES_TRIANGLE_SIDE_VALUE, DELTA);
        assertEquals(t.getBaseLength(), ISOSCELES_TRIANGLE_BASE_VALUE, DELTA);
        assertEquals(t.getHeight(), ISOSCELES_TRIANGLE_HEIGHT_VALUE, DELTA);
        assertEquals(t.getCircuit(), ISOSCELES_TRIANGLE_CIRCUIT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), ISOSCELES_TRIANGLE_AREA_VALUE, DELTA);
    }

    /**
     * Rectangle with long side, short side
     */
    @Test
    public void shouldCreateRectangleWithSides() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput(String.format(Locale.US, "add rectangle side %f side %f", RECTANGLE_LONG_SIDE_VALUE,
                RECTANGLE_SHORT_SIDE_VALUE));

        Rectangle r = (Rectangle) shapeRepository.get(0).get();
        assertEquals(r.getLongSideLength(), RECTANGLE_LONG_SIDE_VALUE, DELTA);
        assertEquals(r.getShortSideLength(), RECTANGLE_SHORT_SIDE_VALUE, DELTA);
        assertEquals(r.getDiagonalLength(), RECTANGLE_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), RECTANGLE_AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), RECTANGLE_CIRCUIT_VALUE, DELTA);
    }

    /**
     * RegularTriangle with side
     */
    @Test
    public void shouldCreateRegularTriangleWithSide() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput(String.format(Locale.US, "add regulartriangle side %f", REGULAR_TRIANGLE_SIDE_VALUE));

        RegularTriangle t = (RegularTriangle) shapeRepository.get(0).get();
        assertEquals(t.getSideLength(), REGULAR_TRIANGLE_SIDE_VALUE, DELTA);
        assertEquals(t.getHeight(), REGULAR_TRIANGLE_HEIGHT_VALUE, DELTA);
        assertEquals(t.getSurfaceArea(), REGULAR_TRIANGLE_AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), REGULAR_TRIANGLE_CIRCUIT_VALUE, DELTA);
    }

    /**
     * Rhombus with long diagonal and short diagonal
     */
    @Test
    public void shouldCreateRhombusWithDiagonals() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput(String.format(Locale.US, "add rhombus diagonal %f diagonal %f",
                RHOMBUS_LONG_DIAGONAL_VALUE, RHOMBUS_SHORT_DIAGONAL_VALUE));

        Rhombus r = (Rhombus) shapeRepository.get(0).get();
        assertEquals(r.getSideLength(), RHOMBUS_SIDE_VALUE, DELTA);
        assertEquals(r.getLongDiagonalLength(), RHOMBUS_LONG_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getShortDiagonalLength(), RHOMBUS_SHORT_DIAGONAL_VALUE, DELTA);
        assertEquals(r.getSurfaceArea(), RHOMBUS_AREA_VALUE, DELTA);
        assertEquals(r.getCircuit(), RHOMBUS_CIRCUIT_VALUE, DELTA);
    }

    /**
     * RightTriangle with short cathetus, long cathetus
     */
    @Test
    public void shouldCreateRightTriangleWithValues() {
        ShapeRepository shapeRepository = new ShapeRepository();
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput(String.format(Locale.US, "add righttriangle cathetus %f cathetus %f",
                RIGHT_TRIANGLE_SHORT_CATHETUS_LENGTH, RIGHT_TRIANGLE_LONG_CATHETUS_LENGTH));

        RightTriangle t = (RightTriangle) shapeRepository.get(0).get();
        assertEquals(t.getShortCathetusLength(), RIGHT_TRIANGLE_SHORT_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getLongCathetusLength(), RIGHT_TRIANGLE_LONG_CATHETUS_LENGTH, DELTA);
        assertEquals(t.getHypotenuse(), RIGHT_TRIANGLE_HYPOTENUSE_LENGTH, DELTA);
        assertEquals(t.getSurfaceArea(), RIGHT_TRIANGLE_AREA_VALUE, DELTA);
        assertEquals(t.getCircuit(), RIGHT_TRIANGLE_CIRCUIT_VALUE, DELTA);
    }

    /**
     * Remove shape
     */
    @Test
    public void shouldRemoveShape() {
        Square s = Square.withSideLength(SQUARE_SIDE_VALUE);
        Circle c = Circle.withCircuit(CIRCLE_CIRCUIT_VALUE);
        Rectangle r = Rectangle.withDiagonalAndSurfaceArea(RECTANGLE_DIAGONAL_VALUE, RECTANGLE_AREA_VALUE);
        ShapeRepository shapeRepository = new ShapeRepository();
        shapeRepository.addShape(s);
        shapeRepository.addShape(c);
        shapeRepository.addShape(r);
        InputHandler inputHandler = new InputHandler(shapeRepository);

        Square s2 = (Square) shapeRepository.get(0).get();
        Circle c2 = (Circle) shapeRepository.get(1).get();
        Rectangle r2 = (Rectangle) shapeRepository.get(2).get();
        assertEquals(s, s2);
        assertEquals(c, c2);
        assertEquals(r, r2);

        inputHandler.parseInput("remove 1");

        Square s3 = (Square) shapeRepository.get(0).get();
        Rectangle r3 = (Rectangle) shapeRepository.get(1).get();
        assertEquals(s, s3);
        assertEquals(r, r3);
    }

    /**
     * Remove shape with wrong index
     */
    @Test
    public void shouldNotRemoveShape() {
        Square s = Square.withSideLength(SQUARE_SIDE_VALUE);
        Circle c = Circle.withCircuit(CIRCLE_CIRCUIT_VALUE);
        ShapeRepository shapeRepository = new ShapeRepository();
        shapeRepository.addShape(s);
        shapeRepository.addShape(c);
        InputHandler inputHandler = new InputHandler(shapeRepository);

        Square s2 = (Square) shapeRepository.get(0).get();
        Circle c2 = (Circle) shapeRepository.get(1).get();
        assertEquals(s, s2);
        assertEquals(c, c2);

        inputHandler.parseInput("remove 10");

        Square s3 = (Square) shapeRepository.get(0).get();
        Circle c3 = (Circle) shapeRepository.get(1).get();
        assertEquals(s, s3);
        assertEquals(c, c3);
    }

    /**
     * Double sized shape
     */
    @Test
    public void shouldAddDoubledSizedShape() {
        Square s = Square.withSideLength(SQUARE_SIDE_VALUE);
        ShapeRepository shapeRepository = new ShapeRepository();
        shapeRepository.addShape(s);
        InputHandler inputHandler = new InputHandler(shapeRepository);

        Square s2 = (Square) shapeRepository.get(0).get();
        assertEquals(s, s2);

        inputHandler.parseInput("doubled 0");

        Square s3 = (Square) shapeRepository.get(0).get();
        Square sDoubled = (Square) shapeRepository.get(1).get();
        assertEquals(s, s3);
        assertEquals(sDoubled.getSurfaceArea(), SQUARE_DOUBLED_AREA_VALUE, DELTA);
    }

    /**
     * Circumscribed circle for shape
     */
    @Test
    public void shouldAddCircumscribedCircleForShape() {
        Square s = Square.withSideLength(SQUARE_SIDE_VALUE);
        ShapeRepository shapeRepository = new ShapeRepository();
        shapeRepository.addShape(s);
        InputHandler inputHandler = new InputHandler(shapeRepository);

        Square s2 = (Square) shapeRepository.get(0).get();
        assertEquals(s, s2);

        inputHandler.parseInput("circumscribed 0");

        Square s3 = (Square) shapeRepository.get(0).get();
        Circle c = (Circle) shapeRepository.get(1).get();
        assertEquals(s, s3);
        assertEquals(c.getRadius(), SQUARE_CIRCUMSCRIBED_CIRCLE_RADIUS_VALUE, DELTA);
    }

    /**
     * Sort shapes
     */
    @Test
    public void shouldSortShapes() {
        Circle c = Circle.withCircuit(CIRCLE_CIRCUIT_VALUE);
        Square s = Square.withSideLength(SQUARE_SIDE_VALUE);
        Rectangle r = Rectangle.withDiagonalAndSurfaceArea(RECTANGLE_DIAGONAL_VALUE, RECTANGLE_AREA_VALUE);
        ShapeRepository shapeRepository = new ShapeRepository();
        shapeRepository.addShape(c);
        shapeRepository.addShape(s);
        shapeRepository.addShape(r);
        InputHandler inputHandler = new InputHandler(shapeRepository);

        Circle c2 = (Circle) shapeRepository.get(0).get();
        Square s2 = (Square) shapeRepository.get(1).get();
        Rectangle r2 = (Rectangle) shapeRepository.get(2).get();
        assertEquals(c, c2);
        assertEquals(s, s2);
        assertEquals(r, r2);

        inputHandler.parseInput("sort area ascending");

        Rectangle r3 = (Rectangle) shapeRepository.get(0).get();
        Square s3 = (Square) shapeRepository.get(1).get();
        Circle c3 = (Circle) shapeRepository.get(2).get();
        assertEquals(r, r3);
        assertEquals(s, s3);
        assertEquals(c, c3);
    }

    @Test
    void shouldSaveShapeRepository() {
        String filename = "shapes";

        Circle c = Circle.withCircuit(CIRCLE_CIRCUIT_VALUE);
        Square s = Square.withSideLength(SQUARE_SIDE_VALUE);
        Rectangle r = Rectangle.withDiagonalAndSurfaceArea(RECTANGLE_DIAGONAL_VALUE, RECTANGLE_AREA_VALUE);
        ShapeRepository shapeRepository = new ShapeRepository();
        shapeRepository.addShape(c);
        shapeRepository.addShape(s);
        shapeRepository.addShape(r);
        InputHandler inputHandler = new InputHandler(shapeRepository);

        inputHandler.parseInput("save " + filename);

        assertDoesNotThrow(() -> TimeUnit.SECONDS.sleep(10));

        String json = assertDoesNotThrow(() -> new Scanner(new File(filename + ".json")).nextLine());
        String expected = "{\"shapes\":[{\"shape\":{\"shape\":\"Circle\",\"radius\":17.29999999996708}},{\"shape\":{\"shape\":\"Square\",\"sideLength\":17.3}},{\"shape\":{\"shape\":\"Rectangle\",\"shortSideLength\":3.0,\"longSideLength\":4.0}}]}";

        assertEquals(json, expected);
    }
}
