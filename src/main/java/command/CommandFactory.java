package command;

import repository.ShapeRepository;
import exceptions.argument.NotEnoughArgumentException;
import exceptions.argument.RedundantArgumentException;
import input.InputHandler;

import java.util.Queue;

public class CommandFactory {
    public enum CommandName {
        exit, add, showfigures, sort, circumscribed, doubled
    }

    private final ShapeRepository shapeRepository = new ShapeRepository();
    private final InputHandler inputHandler;

    public CommandFactory(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public Command createCommand(CommandName command, Queue<String> args) throws Exception {

        return switch (command) {
            case exit -> new Exit();
            case add -> new Add(args, shapeRepository, inputHandler);
            case showfigures -> createShow(args);
            case sort -> createSort(args);
            case circumscribed -> createCircumscribed(args);
            case doubled -> createDoubleSized(args);
        };

    }

    private ShowFigures createShow(Queue<String> args) throws Exception {
        if (!args.isEmpty()) {
            throw new RedundantArgumentException();
        } else {
            return new ShowFigures(shapeRepository);
        }
    }

    private Circumscribed createCircumscribed(Queue<String> args) throws Exception {
        if (args.size() == 0) {
            throw new NotEnoughArgumentException();
        } else if (args.size() > 1) {
            throw new RedundantArgumentException();
        } else {
            return new Circumscribed(Integer.parseInt(args.poll()), shapeRepository);
        }
    }

    private DoubleSized createDoubleSized(Queue<String> args) throws Exception {
        if (args.size() == 0) {
            throw new NotEnoughArgumentException();
        } else if (args.size() > 1) {
            throw new RedundantArgumentException();
        } else {
            return new DoubleSized(Integer.parseInt(args.poll()), shapeRepository);
        }
    }

    private Sort createSort(Queue<String> args) throws Exception {
        if (args.size() < 2) {
            throw new NotEnoughArgumentException();
        } else if (args.size() > 2) {
            throw new RedundantArgumentException();
        } else {
            return new Sort(args, shapeRepository);
        }
    }
}
