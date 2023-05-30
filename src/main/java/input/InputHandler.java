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
import repository.ShapeRepository;
import command.Command;
import command.CommandFactory;
import exceptions.argument.OddArgumentsException;

public class InputHandler {

    private static final ShapeFactory shapeFactory = new ShapeFactory();
    private final Parser parser = new Parser();
    private final CommandFactory commandFactory;

    public InputHandler(ShapeRepository shapeRepository) {
        this.commandFactory = new CommandFactory(this, shapeRepository);
    }

    public void parseInput(String input) {
        Queue<String> args = new LinkedList<>(List.of(input.split(" ")));
        if (args.size() > 0) {
            try {
                Command command = commandFactory.createCommand(
                        parser.parseCommand(args.poll()),
                        args);
                command.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Shape createFigureWithArguments(Queue<String> args) {
        return shapeFactory.createShape(parser.parseShapeName(args.poll()), getArgumentsList(args));
    }

    private List<Entry<ArgumentType, Double>> getArgumentsList(Queue<String> args) {
        if (args.size() % 2 != 0) {
            throw new OddArgumentsException();
        }
        List<Entry<ArgumentType, Double>> argsList = new ArrayList<>();
        while (args.size() > 1) {
            argsList.add(new SimpleImmutableEntry<>(
                    parser.parseArgumentType(args.poll()),
                    parser.parseArgumentValue(args.poll())));
        }
        return argsList;
    }
}