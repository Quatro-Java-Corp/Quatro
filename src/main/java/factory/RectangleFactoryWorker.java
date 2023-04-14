package factory;

import java.util.List;

import factory.ShapeFactory.ArgumentType;
import factory.ShapeFactory.ShapeName;
import shapes.Rectangle;

public class RectangleFactoryWorker implements ShapeFactoryWorker {
    private static ShapeName shapeName = ShapeName.rectangle;
    private static int numberOfArguments = 2;

    public Rectangle create(ShapeName shapeName, List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (shapeName != RectangleFactoryWorker.shapeName) {
            return null;
        }

        if (paramsTypes.size() != RectangleFactoryWorker.numberOfArguments) {
            throw new Exception("Invalid number of arguments for Rectangle");
        }

        double value1 = paramsValues.get(0);
        double value2 = paramsValues.get(1);

        return switch (paramsTypes.get(0).toString() + "|" + paramsTypes.get(1).toString()) {
            case "side|side" -> Rectangle.withShortSideAndLongSide(value1, value2);
            case "side|diagonal" -> Rectangle.withShortSideAndDiagonal(value1, value2);
            case "side|area" -> Rectangle.withShortSideAndSurfaceArea(value1, value2);
            case "diagonal|side" -> Rectangle.withShortSideAndDiagonal(value2, value1);
            case "diagonal|area" -> Rectangle.withDiagonalAndSurfaceArea(value1, value2);
            case "area|side" -> Rectangle.withLongSideAndSurfaceArea(value2, value1);
            case "area|diagonal" -> Rectangle.withDiagonalAndSurfaceArea(value2, value1);
            default -> throw new Exception("Unknown combination of arguments for rectangle");
        };
    }
}
