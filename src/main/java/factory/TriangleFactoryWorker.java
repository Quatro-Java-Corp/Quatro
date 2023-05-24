package factory;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import shapes.*;

import java.util.List;
import java.util.Map;

import static java.lang.Math.pow;

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
            return convertTriangleIfPossible(new Triangle(arg1.getValue(), arg2.getValue(), arg3.getValue()));
        } else {
            throw new InvalidArgumentsCombinationException(shapeName);
        }
    }

    private Shape convertTriangleIfPossible(Triangle triangle) {
        if (triangle.getSideC() == triangle.getSideA() && triangle.getSideA() == triangle.getSideB()) {
            return RegularTriangle.withSide(triangle.getSideC());
        }
        if (pow(triangle.getSideA(), 2) == pow(triangle.getSideB(), 2) + pow(triangle.getSideC(), 2)) {
            return RightTriangle.withCatheti(triangle.getSideB(), triangle.getSideC());
        }
        if (pow(triangle.getSideB(), 2) == pow(triangle.getSideA(), 2) + pow(triangle.getSideC(), 2)) {
            return RightTriangle.withCatheti(triangle.getSideA(), triangle.getSideC());
        }
        if (pow(triangle.getSideC(), 2) == pow(triangle.getSideB(), 2) + pow(triangle.getSideA(), 2)) {
            return RightTriangle.withCatheti(triangle.getSideA(), triangle.getSideB());
        }
        if (triangle.getSideC() == triangle.getSideB()) {
            return IsoscelesTriangle.withSideAndBase(triangle.getSideC(), triangle.getSideA());
        }
        if (triangle.getSideA() == triangle.getSideB()) {
            return IsoscelesTriangle.withSideAndBase(triangle.getSideA(), triangle.getSideC());
        }
        if (triangle.getSideC() == triangle.getSideA()) {
            return IsoscelesTriangle.withSideAndBase(triangle.getSideC(), triangle.getSideB());
        }
        return triangle;
    }
}
