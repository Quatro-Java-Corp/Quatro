package factory;

import java.util.List;
import java.util.Map.Entry;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import factory.ShapeFactory.ArgumentType;
import shapes.Rhombus;
import shapes.Shape;
import shapes.Square;

public class RhombusFactoryWorker implements ShapeFactoryWorker {
    public static final String shapeName = "rhombus";
    public static final double numberOfArguments = 2;

    private static final double DELTA = 0.0001;

    public Shape create(List<Entry<ArgumentType, Double>> args) {
        if (args.size() != numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);

        return convertIfPossible(switch (arg1.getKey().toString() + "|" + arg2.getKey().toString()) {
            case "diagonal|diagonal" -> Rhombus.withShortDiagonalAndLongDiagonal(arg1.getValue(), arg2.getValue());
            case "diagonal|side" -> Rhombus.withShortDiagonalAndSide(arg1.getValue(), arg2.getValue());
            case "diagonal|area" -> Rhombus.withShortDiagonalAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "side|diagonal" -> Rhombus.withShortDiagonalAndSide(arg2.getValue(), arg1.getValue());
            case "side|area" -> Rhombus.withSideLengthAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "area|diagonal" -> Rhombus.withShortDiagonalAndSurfaceArea(arg2.getValue(), arg1.getValue());
            case "area|side" -> Rhombus.withSideLengthAndSurfaceArea(arg2.getValue(), arg1.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        });
    }

    private Shape convertIfPossible(Rhombus rhombus) {
        if (rhombus.getLongDiagonalLength() - rhombus.getShortDiagonalLength() < DELTA) {
            return Square.withDiagonalLength(rhombus.getShortDiagonalLength());
        }
        return rhombus;
    }
}
