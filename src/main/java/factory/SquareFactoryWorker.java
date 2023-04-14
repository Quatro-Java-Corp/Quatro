package factory;

import java.util.List;

import factory.ShapeFactory.ArgumentType;
import factory.ShapeFactory.ShapeName;
import shapes.Square;

public class SquareFactoryWorker implements ShapeFactoryWorker {
    private static ShapeName shapeName = ShapeName.square;
    private static int numberOfArguments = 1;

    public Square create(ShapeName shapeName, List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (shapeName != SquareFactoryWorker.shapeName) {
            return null;
        }

        if (paramsTypes.size() != SquareFactoryWorker.numberOfArguments) {
            throw new Exception("Invalid number of arguments for square");
        }

        double value = paramsValues.get(0);

        return switch (paramsTypes.get(0)) {
            case area -> Square.withSurfaceArea(value);
            case diagonal -> Square.withDiagonalLength(value);
            case side -> Square.withSideLength(value);
            default -> throw new Exception("Unknown combination of arguments for square");
        };
    }
}
