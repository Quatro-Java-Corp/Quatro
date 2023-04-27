package command;

import shapes.Shape;
import repository.ShapeRepository;
import input.InputHandler;

class Add implements Command {
    private final ShapeRepository shapeRepo;
    private final String[] args;

    private final InputHandler inputHandler;

    public Add(String[] args, ShapeRepository shapeRepo, InputHandler inputHandler) {
        this.shapeRepo = shapeRepo;
        this.args = args;
        this.inputHandler = inputHandler;
    }

    @Override
    public void run() throws Exception {
        Shape shape = inputHandler.createFigureWithArguments(args);
        System.out.println(shape.toString());
        shapeRepo.addShape(shape);
    }
}
