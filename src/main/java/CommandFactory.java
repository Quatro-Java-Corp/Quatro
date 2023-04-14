import shapes.Shape;

import java.util.List;

public class CommandFactory {
    public enum CommandName {
        exit, add,showfigures
    }
    public CommandName command;
    private InputHandler inputHandler;

    public CommandFactory(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public String[] args;
    private final ShapeRepository figureList = new ShapeRepository();
    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";

     public void runCommand() throws Exception {
              switch (command) {
                 case exit ->    System.exit(0);
                 case add -> addShape();
                 case showfigures -> showFigures();
             };

     }

     private void showFigures(){
         if (args.length != 0)
             System.out.println(NO_NEED_ARGUMENTS);
         figureList.getShapes().forEach(System.out::println);
     }
     private void addShape(){
         try {
             Shape shape = inputHandler.createFigureWithArguments(args);
             figureList.addShape(shape);
             System.out.println(shape.toString());
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }



}
