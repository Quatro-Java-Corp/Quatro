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
import exceptions.argument.InvalidArgumentTypeException;
import exceptions.argument.InvalidArgumentValueException;
import exceptions.argument.OddArgumentsException;
import exceptions.command.InvalidFunctionNameException;

public class InputHandler {

    private static final ShapeFactory shapeFactory = new ShapeFactory();
    private final CommandFactory commandFactory = new CommandFactory(this);

    public void parseInput(String input) {
        Queue<String> args = new LinkedList<>(List.of(input.split(" ")));
        if (args.size() > 0) {
            try {
                Command command = commandFactory.createCommand(
                        parseCommand(args.poll()),
                        args);
                command.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public CommandFactory.CommandName parseCommand(String command) {
        try {
            return CommandFactory.CommandName.valueOf(command);
        } catch (IllegalArgumentException e) {
            throw new InvalidFunctionNameException();
        }
    }

    public Shape createFigureWithArguments(Queue<String> args) {
        return shapeFactory.createShape(args.poll(), getArgumentsList(args));
    }

    private List<Entry<ArgumentType, Double>> getArgumentsList(Queue<String> args) {
        if (args.size() % 2 != 0) {
            throw new OddArgumentsException();
        }
        List<Entry<ArgumentType, Double>> argsList = new ArrayList<>();
        while (args.size() > 1) {
            argsList.add(new SimpleImmutableEntry<>(
                    convertStringToArgumentType(args.poll()),
                    convertStringToArgumentValue(args.poll())));
        }
        return argsList;
    }

    private ShapeFactory.ArgumentType convertStringToArgumentType(String s) {
        try {
            return ShapeFactory.ArgumentType.valueOf(s.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidArgumentTypeException();
        }
    }

    private Double convertStringToArgumentValue(String s) {
        try {
            double val = Double.parseDouble(s);
            if (val <= 0) {
                throw new NumberFormatException();
            }
            return val;
        } catch (NumberFormatException e) {
            throw new InvalidArgumentValueException();
        }
    }
}