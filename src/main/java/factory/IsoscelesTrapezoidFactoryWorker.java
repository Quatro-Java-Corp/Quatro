package factory;

import java.util.List;
import java.util.Map.Entry;

import exceptions.factory.InvalidArgumentsCombinationException;
import exceptions.factory.InvalidArgumentsNumberException;
import factory.ShapeFactory.ArgumentType;
import shapes.IsoscelesTrapezoid;

public class IsoscelesTrapezoidFactoryWorker implements ShapeFactoryWorker {

    public static final String shapeName = "isoscelestrapezoid";
    public static final double numberOfArguments = 3;

    public IsoscelesTrapezoid create(List<Entry<ArgumentType, Double>> args) {
        if (args.size() != numberOfArguments) {
            throw new InvalidArgumentsNumberException(shapeName);
        }

        var arg1 = args.get(0);
        var arg2 = args.get(1);
        var arg3 = args.get(2);
        return switch (arg1.getKey().toString() + "|" + arg2.getKey().toString() + "|" + arg3.getKey().toString() ){
            case "shortbase|longbase|side" -> IsoscelesTrapezoid.withTwoBaseAndSide(arg1.getValue(), arg2.getValue(), arg3.getValue());
            case "shortbase|longbase|height" -> IsoscelesTrapezoid.withTwoBaseAndHeight(arg1.getValue(), arg2.getValue(), arg3.getValue());
            case "shortbase|longbase|area" -> IsoscelesTrapezoid.withTwoBaseAndArea(arg1.getValue(), arg2.getValue(), arg3.getValue());
            case "shortbase|side|height" -> IsoscelesTrapezoid.withShortBaseAndSideAndHeight(arg1.getValue(), arg2.getValue(), arg3.getValue());
            case "longbase|side|height" -> IsoscelesTrapezoid.withLongBaseAndSideAndHeight(arg1.getValue(), arg2.getValue(), arg3.getValue());
            case "longbase|height|area", "shortbase|height|area" -> IsoscelesTrapezoid.withBaseAndHeightAndArea(arg1.getValue(), arg2.getValue(), arg3.getValue());
            case "side|height|area" ->  IsoscelesTrapezoid.withSideAndHeightAndArea(arg1.getValue(), arg2.getValue(), arg3.getValue());
            default -> throw new InvalidArgumentsCombinationException(shapeName);
        };
    }
}
