import shapes.Shape;

import java.util.ArrayList;
import java.util.List;

import factory.ShapeFactory;

public class InputHandler {

    private final ShapeFactory shapeFactory = new ShapeFactory();
    private final ShapeRepository figureList = new ShapeRepository();

    private static final String INVALID_SHAPE_NAME = "Unknown figure name";
    private static final String INVALID_ARGUMENT_VALUE = "Value must be a positive number.";
    private static final String INVALID_ARGUMENT_TYPE = "Unknown argument name";
    private static final String INVALID_NUMBER_OF_ARGUMENTS = "Each argument type must have a value";
    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";
    private static final String UNKNOWN_FUNCTION = "Unknown function";

    public void parseInput(String input) {
        String[] args = input.split(" ");
        if (args.length > 0) {
            if (args.length == 1 && args[0].equals("exit")) {
                System.exit(0);
            } else if (args.length >= 1 && args[0].toLowerCase().equals("showfigures")) {
                if (args.length != 1)
                    System.out.println(NO_NEED_ARGUMENTS);
                figureList.getShapes().forEach(System.out::println);
            } else if (args.length == 1) {
                System.out.println(UNKNOWN_FUNCTION);
            } else {
                try {
                    Shape shape = createFigureWithArguments(args);
                    figureList.addShape(shape);
                    System.out.println(shape.toString());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Shape createFigureWithArguments(String[] args) throws Exception {
        ShapeFactory.ShapeName shapeName = formatShapeName(args[0]);
        List<ShapeFactory.ArgumentType> argsTypes = getTypesFromArguments(args);
        List<Double> argsValues = getValuesFromArguments(args);
        if (argsTypes.size() != argsValues.size()) {
            throw new Exception(INVALID_NUMBER_OF_ARGUMENTS);
        }
        return shapeFactory.createShape(shapeName, argsTypes, argsValues);
    }

    private static ShapeFactory.ShapeName formatShapeName(String shapeName) throws Exception {
        try {
            return ShapeFactory.ShapeName.valueOf(shapeName.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new Exception(INVALID_SHAPE_NAME);
        }
    }

    private static List<ShapeFactory.ArgumentType> getTypesFromArguments(String[] args) throws Exception {
        List<ShapeFactory.ArgumentType> types = new ArrayList<>();
        try {
            for (int i = 1; i < args.length; i += 2) {
                types.add(ShapeFactory.ArgumentType.valueOf(args[i].toLowerCase()));
            }
        } catch (IllegalArgumentException e) {
            throw new Exception(INVALID_ARGUMENT_TYPE);
        }
        return types;
    }

    private static List<Double> getValuesFromArguments(String[] args) throws Exception {
        List<Double> values = new ArrayList<>();
        try {
            for (int i = 2; i < args.length; i += 2) {
                double val = Double.parseDouble(args[i]);
                if (val <= 0) {
                    throw new NumberFormatException();
                }
                values.add(val);
            }
        } catch (NumberFormatException e) {
            throw new Exception(INVALID_ARGUMENT_VALUE);
        }
        return values;
    }
}
