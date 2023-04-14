package factory;

import java.util.List;

import factory.ShapeFactory.ArgumentType;
import factory.ShapeFactory.ShapeName;
import shapes.Circle;

public class CircleFactoryWorker implements IShapeFactoryWorker {
    private static ShapeName shapeName = ShapeName.circle;
    private static int numberOfArguments = 1;

    public Circle create(ShapeName shapeName, List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (shapeName != CircleFactoryWorker.shapeName) {
            return null;
        }

        if (paramsTypes.size() != CircleFactoryWorker.numberOfArguments) {
            throw new Exception("Invalid number of arguments for Circle");
        }

        double value = paramsValues.get(0);

        return switch (paramsTypes.get(0)) {
            case area -> Circle.withSurfaceArea(value);
            case circuit -> Circle.withCircuit(value);
            case diameter -> Circle.withDiameter(value);
            case radius -> Circle.withRadius(value);
            default -> throw new Exception("Unknown combination of arguments for circle");
        };
    }
}
