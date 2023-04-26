package command;

import repository.ShapeRepository;
import shapes.Shape;

public class DoubledSized implements Command {
    private final String[] args;
    private final ShapeRepository shapeRepo;

    public DoubledSized(String[] args,ShapeRepository shapeRepo) {
        this.args = args;
        this.shapeRepo = shapeRepo;
    }

    @Override
    public void run() {
        try {
            int index = Integer.parseInt(args[1]);
            Shape shape = shapeRepo.get(index).orElseThrow(Exception::new);
            Shape doubledSizedShape = shape.getDoubledSized();

            System.out.println(doubledSizedShape);
            shapeRepo.addShape(doubledSizedShape);
        }
        catch (Exception e){
            System.out.println("Illegal Index");
        }
    }
}
