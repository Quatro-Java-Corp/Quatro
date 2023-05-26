package factory;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import shapes.*;

import java.util.List;
import java.util.Map;

import static java.lang.Math.pow;
import static utils.CompareDouble.doubleEquals;

public class TriangleFactoryWorker implements ShapeFactoryWorker {
    public static final String shapeName = "triangle";
    public static final double numberOfArguments = 3;


    public Shape create(List<Map.Entry<ShapeFactory.ArgumentType, Double>> args) {
        if (args.size() != numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);
        var arg3 = args.get(2);

        if (arg1.getKey().toString().equals("side") && arg2.getKey().toString().equals("side") && arg3.getKey().toString().equals("side")) {
            return convertIfPossible(new Triangle(arg1.getValue(), arg2.getValue(), arg3.getValue()));
        } else {
            throw new InvalidArgumentsCombinationException(shapeName);
        }
    }

    private Shape convertIfPossible(Triangle triangle) {
        if (doubleEquals(triangle.getShortSide(), triangle.getMediumSide()) && doubleEquals(triangle.getShortSide(), triangle.getLongSide())) {
            return RegularTriangle.withSide(triangle.getLongSide());
        }
        if (doubleEquals(pow(triangle.getLongSide(), 2), pow(triangle.getMediumSide(), 2) + pow(triangle.getShortSide(), 2))) {
            return RightTriangle.withCatheti(triangle.getShortSide(), triangle.getMediumSide());
        }
        if (doubleEquals(triangle.getLongSide(), triangle.getMediumSide())) {
            return IsoscelesTriangle.withSideAndBase(triangle.getLongSide(), triangle.getShortSide());
        }
        if (doubleEquals(triangle.getShortSide(), triangle.getMediumSide())) {
            return IsoscelesTriangle.withSideAndBase(triangle.getShortSide(), triangle.getLongSide());
        }
        return triangle;
    }

}
