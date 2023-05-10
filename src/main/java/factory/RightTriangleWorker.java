package factory;

import java.util.List;
import java.util.Map.Entry;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import factory.ShapeFactory.ArgumentType;
import shapes.Rectangle;
import shapes.RightTriangle;

public class RightTriangleWorker implements ShapeFactoryWorker {

    public static final String shapeName = "righttriangle";
    public static final double numberOfArguments = 2;

    public RightTriangle create(List<Entry<ArgumentType, Double>> args) {
        if (args.size() != numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);

        return switch (arg1.getKey().toString() + "|" + arg2.getKey().toString()) {
            case "cathetus|cathetus" -> RightTriangle.withCatheti(arg1.getValue(), arg2.getValue());
            case "cathetus|hypotenuse" -> RightTriangle.withCathetusAndHypotenuse(arg1.getValue(), arg2.getValue());
            case "cathetus|area" -> RightTriangle.withCathetusAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "hypotenuse|cathetus" -> RightTriangle.withCathetusAndHypotenuse(arg2.getValue(), arg1.getValue());
            case "hypotenuse|area" -> RightTriangle.withHypotenuseAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "area|cathetus" -> RightTriangle.withCathetusAndSurfaceArea(arg2.getValue(), arg1.getValue());
            case "area|hypotenuse" -> RightTriangle.withHypotenuseAndSurfaceArea(arg2.getValue(), arg1.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        };
    }
}
