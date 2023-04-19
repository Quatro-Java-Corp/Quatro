package factory;

import java.util.List;
import java.util.Map.Entry;

import factory.ShapeFactory.ArgumentType;
import shapes.Square;

public class SquareFactoryWorker implements ShapeFactoryWorker {

    public static final String shapeName = "square";
    public static final double numberOfArguments = 1;

    public Square create(List<Entry<ArgumentType, Double>> args) throws Exception {
        if (args.size() != SquareFactoryWorker.numberOfArguments) {
            throw new Exception("Invalid number of arguments for square");
        }

        var arg = args.get(0);

        return switch (arg.getKey()) {
            case area -> Square.withSurfaceArea(arg.getValue());
            case diagonal -> Square.withDiagonalLength(arg.getValue());
            case side -> Square.withSideLength(arg.getValue());
            default -> throw new Exception("Unknown combination of arguments for square");
        };
    }
}
