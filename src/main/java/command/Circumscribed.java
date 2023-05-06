package command;

import shapes.Circle;
import shapes.Shape;
import repository.ShapeRepository;

import java.util.Optional;

import exceptions.command.IllegalIndexException;
import exceptions.shape.InvalidShapeForCircumscribedCircleException;

class Circumscribed implements Command {
    private final ShapeRepository shapeRepository;
    private final int index;

    public Circumscribed(int index, ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
        this.index = index;
    }

    @Override
    public void run() throws InvalidShapeForCircumscribedCircleException {
        Shape shape = shapeRepository.get(index).orElseThrow(IllegalIndexException::new);
        Optional<Circle> optionalCircle = shape.getCircumscribedCircle();

        if (optionalCircle.isEmpty()) {
            throw new InvalidShapeForCircumscribedCircleException();
        }

        System.out.println(optionalCircle.get());
        shapeRepository.addShape(optionalCircle.get());
    }
}
