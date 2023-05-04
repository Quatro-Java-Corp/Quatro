package input;

import repository.ShapeRepository;
import shapes.Shape;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import factory.ShapeFactory;
import factory.ShapeFactory.ArgumentType;
import command.Command;
import command.CommandFactory;
import exceptions.argument.InvalidArgumentTypeException;
import exceptions.argument.InvalidArgumentValueException;
import exceptions.command.InvalidFunctionNameException;

public class InputHandler {

    private static final ShapeFactory shapeFactory = new ShapeFactory();
    private final CommandFactory commandFactory = new CommandFactory(this);
    private final ShapeRepository figureList = new ShapeRepository();

    public void parseInput(String input) {
        String[] args = input.split(" ");
        if (args.length > 0) {

            try {
                CommandFactory.CommandName commandName = readCommandName(args);
                Command command = commandFactory.createCommand(commandName, args, figureList);
                command.run();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public CommandFactory.CommandName readCommandName(String[] args) throws Exception {
        return formatCommandName(args[0]);
    }

    public Shape createFigureWithArguments(String[] args) throws Exception {
        return shapeFactory.createShape(args[1], getArgumentsList(args));
    }

    private CommandFactory.CommandName formatCommandName(String commandName) throws Exception {
        try {
            return CommandFactory.CommandName.valueOf(commandName.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidFunctionNameException();
        }
    }

    private List<Entry<ArgumentType, Double>> getArgumentsList(String[] args) throws Exception {
        List<Entry<ArgumentType, Double>> argsList = new ArrayList<>();
        for (int i = 2; i < args.length; i += 2) {
            argsList.add(new SimpleImmutableEntry<>(
                    convertStringToArgumentType(args[i]),
                    convertStringToArgumentValue(args[i + 1])));
        }
        return argsList;
    }

    private ShapeFactory.ArgumentType convertStringToArgumentType(String s) throws Exception {
        try {
            return ShapeFactory.ArgumentType.valueOf(s.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidArgumentTypeException();
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
            throw new InvalidArgumentValueException();
        }
    }
}