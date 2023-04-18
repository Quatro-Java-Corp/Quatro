import shapes.Shape;

import java.util.Arrays;

public class CommandFactory {
    public enum CommandName {
        exit, add, showfigures
    }

    private InputHandler inputHandler;

    public CommandFactory(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public String[] args;



    public Command createCommand(CommandName command,String[] args ,ShapeRepository shapeRepo)  {
        return switch (command) {
            case exit ->  new CommandExit();
            case add ->  new CommandAdd(args,shapeRepo);  //addShape( Arrays.copyOfRange(args, 1, args.length),ih );
            case showfigures ->  new CommandShow(shapeRepo, args.length == 0);   //showFigures( Arrays.copyOfRange(args, 1, args.length),ih);
        };

    }



}
