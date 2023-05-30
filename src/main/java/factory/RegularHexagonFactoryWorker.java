package factory;

import java.util.List;
import java.util.Map.Entry;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import factory.ShapeFactory.ArgumentType;
import shapes.RegularHexagon;

public class RegularHexagonFactoryWorker implements ShapeFactoryWorker {

    public static final String shapeName = "regularhexagon";
    public static final double numberOfArguments = 1;

    public RegularHexagon create(List<Entry<ArgumentType, Double>> args) {
        if (args.size() != numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg = args.get(0);

        return switch (arg.getKey()) {
            case area -> RegularHexagon.withSurfaceArea(arg.getValue());
            case side -> RegularHexagon.withSide(arg.getValue());
            case circuit -> RegularHexagon.withCircuit(arg.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        };
    }
}
