package factory;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import shapes.Shape;
import shapes.Triangle;

import java.util.List;
import java.util.Map;

public class TriangleFactoryWorker implements ShapeFactoryWorker{
    public static final String shapeName = "triangle";
    public static final double numberOfArguments = 3;
    public Shape create(List<Map.Entry<ShapeFactory.ArgumentType, Double>> args) {
        if (args.size() != numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);
        var arg3 = args.get(2);
        return switch (arg1.getKey().toString() + "|" + arg2.getKey().toString()+ "|" + arg3.getKey().toString()) {
            case "side|side|side" -> new Triangle(arg1.getValue(), arg2.getValue(),arg3.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        };
    }
}
