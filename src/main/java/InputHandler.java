import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private final ShapeService shapeService = new ShapeService();

    private static final String INVALID_SHAPE_NAME = "Unknown figure name";
    private static final String INVALID_ARGUMENT_VALUE = "Value must be a positive number.";
    private static final String INVALID_ARGUMENT_TYPE = "Unknown argument name";
    private static final String INVALID_NUMBER_OF_ARGUMENTS = "Each argument type must have a value";

    public Figure createFigureWithArguments(String[] args) throws Exception {
        ShapeService.ShapeName shapeName = formatShapeName(args[0]);
        List<ShapeService.ArgumentType> argsTypes = getTypesFromArguments(args);
        List<Double> argsValues = getValuesFromArguments(args);
        ;
        if (argsTypes.size() != argsValues.size()) {
            throw new Exception(INVALID_NUMBER_OF_ARGUMENTS);
        }
        return shapeService.createShape(shapeName, argsTypes, argsValues);
    }

    private static ShapeService.ShapeName formatShapeName(String shapeName) throws Exception {
        try {
            return ShapeService.ShapeName.valueOf(shapeName.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new Exception(INVALID_SHAPE_NAME);
        }
    }

    private static List<ShapeService.ArgumentType> getTypesFromArguments(String[] args) throws Exception {
        List<ShapeService.ArgumentType> types = new ArrayList<>();
        try {
            for (int i = 1; i < args.length; i += 2) {
                types.add(ShapeService.ArgumentType.valueOf(args[i].toLowerCase()));
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
