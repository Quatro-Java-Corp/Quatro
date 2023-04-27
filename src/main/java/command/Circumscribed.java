package command;

import shapes.Circle;
import shapes.Shape;
import repository.ShapeRepository;

import java.util.Optional;

import exceptions.IllegalIndexException;
import exceptions.InvalidShapeForCircumscribedCircleException;

class Circumscribed implements Command {
    private final ShapeRepository figureList;
    private final String[] args;

    public Circumscribed(String[] args, ShapeRepository figureList) {
        this.figureList = figureList;
        this.args = args;
    }

    @Override
    public void run() throws InvalidShapeForCircumscribedCircleException {
        int index = Integer.parseInt(args[1]);
        Shape shape = figureList.get(index).orElseThrow(IllegalIndexException::new);
        Optional<Circle> optionalCircle = shape.getCircumscribedCircle();

        if (optionalCircle.isEmpty()) {
            throw new InvalidShapeForCircumscribedCircleException();
        }

        System.out.println(optionalCircle.get());
        figureList.addShape(optionalCircle.get());

    }
}
