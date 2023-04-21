package command;

import other.InputHandler;
import shapes.Shape;
import shapes.ShapeRepository;

import java.util.Arrays;

class Add implements Command {
    private final ShapeRepository shapeRepo;
    private final String[] args;

    public Add(String[] args, ShapeRepository shapeRepo) {
        this.shapeRepo = shapeRepo;
        this.args = args;
    }

    @Override
    public void run() {
        try {
            Shape shape = InputHandler.createFigureWithArguments(Arrays.copyOfRange(args, 1, args.length));
            System.out.println(shape.toString());
            shapeRepo.addShape(shape);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
