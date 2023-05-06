package factory;

import java.util.List;
import java.util.Map.Entry;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import factory.ShapeFactory.ArgumentType;
import shapes.RegularTriangle;

public class RegularTriangleFactoryWorker implements ShapeFactoryWorker {

    public static final String shapeName = "regularTriangle";
    public static final double numberOfArguments = 1;

    public RegularTriangle create(List<Entry<ArgumentType, Double>> args) throws Exception {
        if (args.size() != RegularTriangleFactoryWorker.numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg = args.get(0);

        return switch (arg.getKey()) {
            case area -> RegularTriangle.withSurfaceArea(arg.getValue());
            case height -> RegularTriangle.withHeight(arg.getValue());
            case side -> RegularTriangle.withSide(arg.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        };
    }
}
