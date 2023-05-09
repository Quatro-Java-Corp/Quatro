package factory;

import java.util.List;
import java.util.Map.Entry;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import factory.ShapeFactory.ArgumentType;
import shapes.Ellipse;

public class EllipseFactoryWorker implements ShapeFactoryWorker {

    public static final String shapeName = "ellipse";
    public static final double numberOfArguments = 2;

    public Ellipse create(List<Entry<ArgumentType, Double>> args) throws Exception {
        if (args.size() != EllipseFactoryWorker.numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);

        return switch (arg1.getKey().toString() + "|" + arg2.getKey().toString()) {
            case "semiMinorAxis|semiMajorAxis" -> Ellipse.withAxes(arg1.getValue(), arg2.getValue());
            case "semiMajorAxis|semiMinorAxis" -> Ellipse.withAxes(arg2.getValue(), arg1.getValue());
            case "semiMinorAxis|area" -> Ellipse.withSemiMinorAxisAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "area|semiMinorAxis" -> Ellipse.withSemiMinorAxisAndSurfaceArea(arg2.getValue(), arg1.getValue());
            case "semiMajorAxis|area" -> Ellipse.withSemiMajorAxisAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "area|semiMajorAxis" -> Ellipse.withSemiMajorAxisAndSurfaceArea(arg2.getValue(), arg1.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        };
    }
}
