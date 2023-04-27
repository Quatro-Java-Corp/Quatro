package command;

import shapes.Circle;
import shapes.Shape;
import repository.ShapeRepository;

import java.util.Optional;

class Circumscribed implements Command {
    private final ShapeRepository shapeRepository;
    private final int index;

    public Circumscribed(int index, ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
        this.index = index;
    }

    @Override
    public void run() {

        try {
            Shape shape = shapeRepository.get(index).orElseThrow(Exception::new);
            Optional<Circle> optionalCircle = shape.getCircumscribedCircle();
            if (optionalCircle.isPresent()) {
                System.out.println(optionalCircle.get());
                shapeRepository.addShape(optionalCircle.get());
            } else {
                System.out.println("No circle for this shape");
            }
        } catch (Exception e) {
            System.out.println("Illegal Index");
        }


    }
}
