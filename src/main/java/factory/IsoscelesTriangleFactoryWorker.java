package factory;

import java.util.List;
import java.util.Map.Entry;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import factory.ShapeFactory.ArgumentType;
import shapes.IsoscelesTriangle;
import shapes.RegularTriangle;
import shapes.Shape;
import utils.CompareDouble;

public class IsoscelesTriangleFactoryWorker implements ShapeFactoryWorker {

    public static final String shapeName = "isoscelestriangle";
    public static final double numberOfArguments = 2;

    public Shape create(List<Entry<ArgumentType, Double>> args) {
        if (args.size() != numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);

        return convertIfPossible(switch (arg1.getKey().toString() + "|" + arg2.getKey().toString()) {
            case "side|base" -> IsoscelesTriangle.withSideAndBase(arg1.getValue(), arg2.getValue());
            case "side|area" -> IsoscelesTriangle.withSideAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "side|height" -> IsoscelesTriangle.withSideAndHeight(arg1.getValue(), arg2.getValue());
            case "base|side" -> IsoscelesTriangle.withSideAndBase(arg2.getValue(), arg1.getValue());
            case "base|area" -> IsoscelesTriangle.withBaseAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "base|height" -> IsoscelesTriangle.withBaseAndHeight(arg1.getValue(), arg2.getValue());
            case "area|side" -> IsoscelesTriangle.withSideAndSurfaceArea(arg2.getValue(), arg1.getValue());
            case "area|base" -> IsoscelesTriangle.withBaseAndSurfaceArea(arg2.getValue(), arg1.getValue());
            case "area|height" -> IsoscelesTriangle.withSurfaceAreaAndHeight(arg1.getValue(), arg2.getValue());
            case "height|side" -> IsoscelesTriangle.withSideAndHeight(arg2.getValue(), arg1.getValue());
            case "height|base" -> IsoscelesTriangle.withBaseAndHeight(arg2.getValue(), arg1.getValue());
            case "height|area" -> IsoscelesTriangle.withSurfaceAreaAndHeight(arg2.getValue(), arg1.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        });
    }

    private Shape convertIfPossible(IsoscelesTriangle isoscelesTriangle) {
        if (CompareDouble.doubleEquals(isoscelesTriangle.getBaseLength(), isoscelesTriangle.getSideLength())) {
            return RegularTriangle.withSide(isoscelesTriangle.getSideLength());
        }
        return isoscelesTriangle;
    }
}
