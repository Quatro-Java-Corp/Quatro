package factory;

import java.util.List;

import factory.ShapeFactory.ArgumentType;
import factory.ShapeFactory.ShapeName;
import shapes.Rhombus;

public class RhombusFactoryWorker implements IShapeFactoryWorker {
    private static ShapeName shapeName = ShapeName.rhombus;
    private static int numberOfArguments = 2;

    public Rhombus create(ShapeName shapeName, List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception {
        if (shapeName != RhombusFactoryWorker.shapeName) {
            return null;
        }

        if (paramsTypes.size() != RhombusFactoryWorker.numberOfArguments) {
            throw new Exception("Invalid number of arguments for Rhombus");
        }

        double value1 = paramsValues.get(0);
        double value2 = paramsValues.get(1);

        return switch (paramsTypes.get(0).toString() + "|" + paramsTypes.get(1).toString()) {
            case "diagonal|diagonal" -> Rhombus.withShortDiagonalAndLongDiagonal(value1, value2);
            case "diagonal|side" -> Rhombus.withShortDiagonalAndSide(value1, value2);
            case "diagonal|area" -> Rhombus.withShortDiagonalAndSurfaceArea(value1, value2);
            case "side|diagonal" -> Rhombus.withShortDiagonalAndSide(value2, value1);
            case "side|area" -> Rhombus.withSideLengthAndSurfaceArea(value1, value2);
            case "area|diagonal" -> Rhombus.withShortDiagonalAndSurfaceArea(value2, value1);
            case "area|side" -> Rhombus.withSideLengthAndSurfaceArea(value2, value1);
            default -> throw new Exception("Unknown combination of arguments for rhombus");
        };
    }
}
