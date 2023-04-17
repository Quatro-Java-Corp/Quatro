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

    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";

    public void runCommand(CommandName command,String[] args,InputHandler ih)  {
        switch (command) {
            case exit -> System.exit(0);
            case add -> addShape( Arrays.copyOfRange(args, 1, args.length),ih );
            case showfigures -> showFigures( Arrays.copyOfRange(args, 1, args.length),ih);
        }

    }

    private void showFigures(String[] args,InputHandler ih) {
        if (args.length != 0)
            System.out.println(NO_NEED_ARGUMENTS);
        ih.figureList.getShapes().forEach(System.out::println);
    }

    private void addShape(String[] args,InputHandler ih) {
        try {
            Shape shape = inputHandler.createFigureWithArguments(args);
            System.out.println(shape.toString());
            ih.figureList.addShape(shape);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
