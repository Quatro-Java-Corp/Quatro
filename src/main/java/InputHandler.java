import shapes.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

import factory.ShapeFactory;
import factory.ShapeFactory.ArgumentType;

public class InputHandler {

    private static final ShapeFactory shapeFactory = new ShapeFactory();

    private final CommandFactory commandFactory = new CommandFactory(this);

    private static final String INVALID_ARGUMENT_VALUE = "Value must be a positive number.";
    private static final String INVALID_ARGUMENT_TYPE = "Unknown argument name";
    private static final String INVALID_NUMBER_OF_ARGUMENTS = "Each argument type must have a value";
    private static final String UNKNOWN_FUNCTION = "Unknown function";
    public final ShapeRepository figureList = new ShapeRepository();
    public void parseInput(String input) {
        String[] args = input.split(" ");
        if (args.length > 0) {


            try {
                CommandFactory.CommandName commandName = readCommandName(args);
                Command command = commandFactory.createCommand(commandName, Arrays.copyOfRange(args, 1, args.length),figureList);
                command.run();

            } catch (Exception e) {
                System.out.println(e.getMessage());

            }

        }
    }


    public  CommandFactory.CommandName readCommandName(String[] args) throws Exception {
        CommandFactory.CommandName commandName = formatCommandName(args[0]);
        return commandName;
    }


    private static CommandFactory.CommandName formatCommandName(String commandName) throws Exception {
        try {
            return CommandFactory.CommandName.valueOf(commandName.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new Exception(UNKNOWN_FUNCTION);
        }

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


    public static Shape createFigureWithArguments(String[] args) throws Exception {
        ShapeFactory.ShapeName shapeName = formatShapeName(args[0]);
        List<ShapeFactory.ArgumentType> argsTypes = getTypesFromArguments(args);
        List<Double> argsValues = getValuesFromArguments(args);
        if (argsTypes.size() != argsValues.size()) {
            throw new Exception(INVALID_NUMBER_OF_ARGUMENTS);
        }
        return shapeFactory.createShape(shapeName, argsTypes, argsValues);
    }

    private static List<ShapeFactory.ArgumentType> getTypesFromArguments(String[] args) throws Exception {
        List<ShapeFactory.ArgumentType> types = new ArrayList<>();

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
