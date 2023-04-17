import shapes.Shape;

import java.util.Arrays;
import java.util.List;

public class CommandFactory {
    public enum CommandName {
        exit, add, showfigures
    }

    private InputHandler inputHandler;

    public CommandFactory(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public String[] args;
    private final ShapeRepository figureList = new ShapeRepository();
    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";

    public void runCommand(CommandName command,String[] args) throws Exception {
        switch (command) {
            case exit -> System.exit(0);
            case add -> addShape( Arrays.copyOfRange(args, 1, args.length) );
            case showfigures -> showFigures( Arrays.copyOfRange(args, 1, args.length));
        }

    }

    private void showFigures(String[] args) {
        if (args.length != 0)
            System.out.println(NO_NEED_ARGUMENTS);
        figureList.getShapes().forEach(System.out::println);
    }

    private void addShape(String[] args) {
        try {
            Shape shape = inputHandler.createFigureWithArguments(args);
            System.out.println(shape.toString());
            figureList.addShape(shape);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
