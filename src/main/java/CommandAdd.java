import shapes.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandAdd implements Command{
    private ShapeRepository shapeRepo;
    private String[] args;
    public CommandAdd(String[] args,ShapeRepository shapeRepo) {
        this.shapeRepo = shapeRepo;
        this.args = args;
    }

    @Override
    public void run() {
        try {
            Shape shape = InputHandler.createFigureWithArguments( Arrays.copyOfRange(args, 1, args.length));
            System.out.println(shape.toString());
            shapeRepo.addShape(shape);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
