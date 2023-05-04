package command;

import repository.ShapeRepository;
import exceptions.argument.RedundantArgumentException;
import input.InputHandler;

public class CommandFactory {
    public enum CommandName {
        exit, add, showfigures, sort, circumscribed, doubled
    }

    private InputHandler inputHandler;

    public CommandFactory(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public Command createCommand(CommandName command, String[] args, ShapeRepository shapeRepo) throws Exception {
        return switch (command) {
            case exit -> new Exit();
            case add -> new Add(args, shapeRepo, inputHandler);
            case showfigures -> createShow(args, shapeRepo);
            case sort -> new Sort(args, shapeRepo);
            case circumscribed -> new Circumscribed(args, shapeRepo);
            case doubled -> new DoubledSized(args, shapeRepo);
        };

    }

    private Command createShow(String[] args, ShapeRepository shapeRep) throws Exception {
        if (args.length == 1) {
            return new ShowFigures(shapeRep);
        } else {
            throw new RedundantArgumentException();
        }
    }
}
