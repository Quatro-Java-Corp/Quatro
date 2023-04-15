package factory;

import java.util.List;
import java.util.Map.Entry;

import factory.ShapeFactory.ArgumentType;
import shapes.Square;

public class SquareFactoryWorker implements ShapeFactoryWorker {
    public Square create(String shapeName, List<Entry<ArgumentType, Double>> args) throws Exception {
        if (!shapeName.equalsIgnoreCase(Square.name)) {
            return null;
        }

        if (args.size() != Square.numberOfArguments) {
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
