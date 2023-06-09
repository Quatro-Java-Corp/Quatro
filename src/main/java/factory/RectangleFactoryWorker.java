package factory;

import java.util.List;
import java.util.Map.Entry;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import factory.ShapeFactory.ArgumentType;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;

import static utils.CompareDouble.*;

public class RectangleFactoryWorker implements ShapeFactoryWorker {

    public static final String shapeName = "rectangle";
    public static final double numberOfArguments = 2;

    public Shape create(List<Entry<ArgumentType, Double>> args) {
        if (args.size() != numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);

        return convertIfPossible(switch (arg1.getKey().toString() + "|" + arg2.getKey().toString()) {
            case "side|side" -> Rectangle.withShortSideAndLongSide(arg1.getValue(), arg2.getValue());
            case "side|diagonal" -> Rectangle.withShortSideAndDiagonal(arg1.getValue(), arg2.getValue());
            case "side|area" -> Rectangle.withShortSideAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "diagonal|side" -> Rectangle.withShortSideAndDiagonal(arg2.getValue(), arg1.getValue());
            case "diagonal|area" -> Rectangle.withDiagonalAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "area|side" -> Rectangle.withLongSideAndSurfaceArea(arg2.getValue(), arg1.getValue());
            case "area|diagonal" -> Rectangle.withDiagonalAndSurfaceArea(arg2.getValue(), arg1.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        });
    }

    public Shape convertIfPossible(Rectangle rectangle){
        if(doubleEquals(rectangle.getShortSideLength(), rectangle.getLongSideLength())){
            return Square.withSideLength(rectangle.getShortSideLength());
        }
        return rectangle;
    }
}
