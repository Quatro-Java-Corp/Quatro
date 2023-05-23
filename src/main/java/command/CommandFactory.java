package command;

import repository.ShapeRepository;
import exceptions.argument.NotEnoughArgumentException;
import exceptions.argument.RedundantArgumentException;
import exceptions.command.IllegallPrecisionNumberException;
import input.InputHandler;

import java.util.Queue;

public class CommandFactory {
    public enum CommandName {
        exit, add, showfigures, sort, circumscribed, doubled, remove, save, precision
    }

    private final ShapeRepository shapeRepository;
    private final InputHandler inputHandler;

    public CommandFactory(InputHandler inputHandler, ShapeRepository shapeRepository) {
        this.inputHandler = inputHandler;
        this.shapeRepository = shapeRepository;
    }

    public Command createCommand(CommandName command, Queue<String> args) {
        return switch (command) {
            case exit -> new Exit();
            case add -> new Add(args, shapeRepository, inputHandler);
            case showfigures -> createShow(args);
            case sort -> createSort(args);
            case circumscribed -> createCircumscribed(args);
            case doubled -> createDoubleSized(args);
            case remove -> createRemove(args);
            case precision -> createPrecision(args);
            case save -> createSave(args);
        };
    }

    private ShowFigures createShow(Queue<String> args) {
        if (!args.isEmpty()) {
            throw new RedundantArgumentException();
        } else {
            return new ShowFigures(shapeRepository);
        }
    }

    private Circumscribed createCircumscribed(Queue<String> args) {
        if (args.size() == 0) {
            throw new NotEnoughArgumentException();
        } else if (args.size() > 1) {
            throw new RedundantArgumentException();
        } else {
            return new Circumscribed(Integer.parseInt(args.poll()), shapeRepository);
        }
    }

    private DoubleSized createDoubleSized(Queue<String> args) {
        if (args.size() == 0) {
            throw new NotEnoughArgumentException();
        } else if (args.size() > 1) {
            throw new RedundantArgumentException();
        } else {
            return new DoubleSized(Integer.parseInt(args.poll()), shapeRepository);
        }
    }

    private Sort createSort(Queue<String> args) {
        if (args.size() < 1) {
            throw new NotEnoughArgumentException();
        } else if (args.size() > 2) {
            throw new RedundantArgumentException();
        } else {
            return new Sort(args, shapeRepository);
        }
    }

    private Remove createRemove(Queue<String> args) {
        if (args.size() == 0) {
            throw new NotEnoughArgumentException();
        } else if (args.size() > 1) {
            throw new RedundantArgumentException();
        } else {
            return new Remove(Integer.parseInt(args.poll()), shapeRepository);
        }
    }

    private Precision createPrecision(Queue<String> args) {
        if (args.size() < 1) {
            throw new NotEnoughArgumentException();
        } else if (args.size() > 2) {
            throw new RedundantArgumentException();
        } else {
            return new Precision(Integer.parseInt(args.poll()));
        }
    }

    public Save createSave(Queue<String> args) {
        if (args.size() == 0) {
            throw new NotEnoughArgumentException();
        } else if (args.size() > 1) {
            throw new RedundantArgumentException();
        } else {
            return new Save(args.poll(), shapeRepository);
        }
    }
}
