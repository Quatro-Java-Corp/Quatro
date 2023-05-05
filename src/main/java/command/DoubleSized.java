package command;

import repository.ShapeRepository;
import shapes.Shape;

public class DoubleSized implements Command {
    private final ShapeRepository shapeRepository;
    private final int index;


    public DoubleSized(int index, ShapeRepository shapeRepository) {
        this.index = index;
        this.shapeRepository = shapeRepository;
    }

    @Override
    public void run() {
        try {
            Shape shape = shapeRepository.get(index).orElseThrow(Exception::new);
            Shape doubledSizedShape = shape.getDoubledSized();

            System.out.println(doubledSizedShape);
            shapeRepository.addShape(doubledSizedShape);
        } catch (Exception e) {
            System.out.println("Illegal Index");
        }
    }
}
