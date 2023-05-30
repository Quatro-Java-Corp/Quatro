package command;

import shapes.Shape;
import repository.ShapeRepository;
import input.InputHandler;

import java.util.Queue;

class Add implements Command {
    private final ShapeRepository shapeRepository;
    private final Queue<String> args;
    private final InputHandler inputHandler;

    public Add(Queue<String> args, ShapeRepository shapeRepository, InputHandler inputHandler) {
        this.shapeRepository = shapeRepository;
        this.args = args;
        this.inputHandler = inputHandler;
    }

    @Override
    public void run() {
        try {
            Shape shape = inputHandler.createFigureWithArguments(args);
            shapeRepository.addShape(shape);
            System.out.println(shape.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
