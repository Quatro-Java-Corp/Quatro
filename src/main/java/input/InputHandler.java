package input;

import shapes.Shape;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.Queue;

import factory.ShapeFactory;
import factory.ShapeFactory.ArgumentType;
import command.Command;
import command.CommandFactory;


public class InputHandler {

    private static final ShapeFactory shapeFactory = new ShapeFactory();
    private final CommandFactory commandFactory = new CommandFactory(this);

    private static final String INVALID_ARGUMENT_VALUE = "Value must be a positive number.";
    private static final String INVALID_ARGUMENT_TYPE = "Unknown argument name";
    private static final String UNKNOWN_FUNCTION = "Unknown function";
    private static final String ODD_NUMBER_OF_ARGUMENTS = "Odd number of arguments";


    public void parseInput(String input) {
        Queue<String> args = new LinkedList<>(List.of(input.split(" ")));
        if (args.size() > 0) {
            try {
                Command command = commandFactory.createCommand(
                        parseCommand(args.poll()),
                        args
                );
                command.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public CommandFactory.CommandName parseCommand(String command) throws Exception {
        try {
            return CommandFactory.CommandName.valueOf(command);
        } catch (IllegalArgumentException e) {
            throw new Exception(UNKNOWN_FUNCTION);
        }
    }

    public Shape createFigureWithArguments(Queue<String> args) throws Exception {
        return shapeFactory.createShape(args.poll(), getArgumentsList(args));
    }

    private List<Entry<ArgumentType, Double>> getArgumentsList(Queue<String> args) throws Exception {
        if (args.size() % 2 != 0) {
            throw new Exception(ODD_NUMBER_OF_ARGUMENTS);
        }
        List<Entry<ArgumentType, Double>> argsList = new ArrayList<>();
        while (args.size() > 1) {
            argsList.add(new SimpleImmutableEntry<>(
                    convertStringToArgumentType(args.poll()),
                    convertStringToArgumentValue(args.poll())));
        }
        return argsList;
    }

    private ShapeFactory.ArgumentType convertStringToArgumentType(String s) throws Exception {
        try {
            return ShapeFactory.ArgumentType.valueOf(s.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new Exception(INVALID_ARGUMENT_TYPE);
        }
    }

    private Double convertStringToArgumentValue(String s) throws Exception {
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