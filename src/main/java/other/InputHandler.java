package other;

import command.Command;
import command.CommandFactory;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;


import factory.ShapeFactory;
import factory.ShapeFactory.ArgumentType;
import shapes.ShapeRepository;

public class InputHandler {

    private static final ShapeFactory shapeFactory = new ShapeFactory();
    private final CommandFactory commandFactory = new CommandFactory(this);
    private final ShapeRepository figureList = new ShapeRepository();
    private final ComparatorFactory comparatorFactory=new ComparatorFactory();

    private static final String INVALID_ARGUMENT_VALUE = "Value must be a positive number.";
    private static final String INVALID_ARGUMENT_TYPE = "Unknown argument name";
    private static final String INVALID_NUMBER_OF_ARGUMENTS = "Each argument type must have a value";
    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";
    private static final String UNKNOWN_FUNCTION = "Unknown function";

    public void parseInput(String input) {
        String[] args = input.split(" ");
        if (args.length > 0) {

            try {
                CommandFactory.CommandName commandName = readCommandName(args);
                Command command = commandFactory.createCommand(commandName,args,figureList);
                command.run();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public  CommandFactory.CommandName readCommandName(String[] args) throws Exception {
        return formatCommandName(args[0]);
    }
    public static Shape createFigureWithArguments(String[] args) throws Exception {
        return shapeFactory.createShape(args[0], getArgumentsList(args));
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
            argsList.add(new SimpleImmutableEntry<>(
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
