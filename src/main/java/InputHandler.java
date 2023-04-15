import shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

import factory.ShapeFactory;
import factory.ShapeFactory.ArgumentType;

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
        return shapeFactory.createShape(args[0], getArgumentsList(args));
    }

    private static List<Entry<ArgumentType, Double>> getArgumentsList(String[] args) throws Exception {
        List<Entry<ArgumentType, Double>> argsList = new ArrayList<>();
        for (int i = 1; i < args.length; i += 2) {
            argsList.add(new SimpleImmutableEntry<ArgumentType, Double>(
                    convertStringToArgumentType(args[i]),
                    convertStringToArgumentValue(args[i + 1])));
        }
        return argsList;
    }

    private static ShapeFactory.ArgumentType convertStringToArgumentType(String s) throws Exception {
        try {
            return ShapeFactory.ArgumentType.valueOf(s.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new Exception(INVALID_ARGUMENT_TYPE);
        }
    }

    private static Double convertStringToArgumentValue(String s) throws Exception {
        try {
            double val = Double.parseDouble(s);
            if (val <= 0) {
                throw new NumberFormatException();
            }
            return val;
        } catch (NumberFormatException e) {
            throw new Exception(INVALID_ARGUMENT_VALUE);
        }
    }
}
