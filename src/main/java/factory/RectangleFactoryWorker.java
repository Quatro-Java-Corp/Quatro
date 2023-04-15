package factory;

import java.util.List;
import java.util.Map.Entry;

import factory.ShapeFactory.ArgumentType;
import shapes.Rectangle;

public class RectangleFactoryWorker implements ShapeFactoryWorker {
    public Rectangle create(String shapeName, List<Entry<ArgumentType, Double>> args) throws Exception {
        if (!shapeName.equalsIgnoreCase(Rectangle.name)) {
            return null;
        }

        if (args.size() != Rectangle.numberOfArguments) {
            throw new Exception("Invalid number of arguments for Rectangle");
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);

        return switch (arg1.getKey().toString() + "|" + arg2.getKey().toString()) {
            case "side|side" -> Rectangle.withShortSideAndLongSide(arg1.getValue(), arg2.getValue());
            case "side|diagonal" -> Rectangle.withShortSideAndDiagonal(arg1.getValue(), arg2.getValue());
            case "side|area" -> Rectangle.withShortSideAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "diagonal|side" -> Rectangle.withShortSideAndDiagonal(arg2.getValue(), arg1.getValue());
            case "diagonal|area" -> Rectangle.withDiagonalAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "area|side" -> Rectangle.withLongSideAndSurfaceArea(arg2.getValue(), arg1.getValue());
            case "area|diagonal" -> Rectangle.withDiagonalAndSurfaceArea(arg2.getValue(), arg1.getValue());
            default -> throw new Exception("Unknown combination of arguments for rectangle");
        };
    }
}
