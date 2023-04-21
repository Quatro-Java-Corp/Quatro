package command;

import other.InputHandler;
import shapes.ShapeRepository;

public class CommandFactory {
    public enum CommandName {
        exit, add, showfigures, sort, circumscribed
    }
    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";

    private InputHandler inputHandler;

    public CommandFactory(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public Command createCommand(CommandName command, String[] args , ShapeRepository shapeRepo)  {
        try {
            return switch (command) {
                case exit -> new Exit();
                case add -> new Add(args, shapeRepo);
                case showfigures -> createShow(args, shapeRepo);
                case sort -> new Sort(args,shapeRepo);
                case circumscribed -> new Circumscribed(args,shapeRepo);
            };
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return  null;
        }
    }
    private Command createShow(String[] args , ShapeRepository shapeRep) throws Exception{
        if (args.length != 1)
             throw new Exception(NO_NEED_ARGUMENTS);
        else
        return new Showfigures(shapeRep);
    }


}
