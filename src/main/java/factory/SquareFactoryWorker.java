package factory;

import java.util.List;
import java.util.Map.Entry;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import factory.ShapeFactory.ArgumentType;
import shapes.Square;

public class SquareFactoryWorker implements ShapeFactoryWorker {

    public static final String shapeName = "square";
    public static final double numberOfArguments = 1;

    public Square create(List<Entry<ArgumentType, Double>> args){
        if (args.size() != numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg = args.get(0);

        return switch (arg.getKey()) {
            case area -> Square.withSurfaceArea(arg.getValue());
            case diagonal -> Square.withDiagonalLength(arg.getValue());
            case side -> Square.withSideLength(arg.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        };
    }
}
