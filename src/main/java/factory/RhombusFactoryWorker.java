package factory;

import java.util.List;
import java.util.Map.Entry;

import factory.ShapeFactory.ArgumentType;
import shapes.Rhombus;

public class RhombusFactoryWorker implements ShapeFactoryWorker {
    public Rhombus create(String shapeName, List<Entry<ArgumentType, Double>> args) throws Exception {
        if (!shapeName.equalsIgnoreCase(Rhombus.name)) {
            return null;
        }

        if (args.size() != Rhombus.numberOfArguments) {
            throw new Exception("Invalid number of arguments for rhombus");
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);

        return switch (arg1.getKey().toString() + "|" + arg2.getKey().toString()) {
            case "diagonal|diagonal" -> Rhombus.withShortDiagonalAndLongDiagonal(arg1.getValue(), arg2.getValue());
            case "diagonal|side" -> Rhombus.withShortDiagonalAndSide(arg1.getValue(), arg2.getValue());
            case "diagonal|area" -> Rhombus.withShortDiagonalAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "side|diagonal" -> Rhombus.withShortDiagonalAndSide(arg2.getValue(), arg1.getValue());
            case "side|area" -> Rhombus.withSideLengthAndSurfaceArea(arg1.getValue(), arg2.getValue());
            case "area|diagonal" -> Rhombus.withShortDiagonalAndSurfaceArea(arg2.getValue(), arg1.getValue());
            case "area|side" -> Rhombus.withSideLengthAndSurfaceArea(arg2.getValue(), arg1.getValue());
            default -> throw new Exception("Unknown combination of arguments for rhombus");
        };
    }
}
