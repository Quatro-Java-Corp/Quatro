package factory;

import shapes.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ShapeFactory {

    public enum ArgumentType {
        side, diagonal, area, radius, diameter, circuit, height, base, cathetus, hypotenuse
    }

    private final Map<String, ShapeFactoryWorker> workers = new HashMap<>();

    public ShapeFactory() {
        registerWorker(CircleFactoryWorker.shapeName, new CircleFactoryWorker());
        registerWorker(SquareFactoryWorker.shapeName, new SquareFactoryWorker());
        registerWorker(RegularTriangleFactoryWorker.shapeName, new RegularTriangleFactoryWorker());
        registerWorker(RectangleFactoryWorker.shapeName, new RectangleFactoryWorker());
        registerWorker(RhombusFactoryWorker.shapeName, new RhombusFactoryWorker());
        registerWorker(IsoscelesTriangleFactoryWorker.shapeName, new IsoscelesTriangleFactoryWorker());
        registerWorker(RightTriangleWorker.shapeName, new RightTriangleWorker());
    }

    private void registerWorker(String shapeName, ShapeFactoryWorker worker) {
        workers.put(shapeName, worker);
    }

    public Shape createShape(String shapeName, List<Entry<ArgumentType, Double>> args) throws Exception {
        if (workers.containsKey(shapeName)) {
            Shape shape = workers.get(shapeName).create(args);
            if (shapeName.equals("rhombus")) {
                return convertRhombusToSquareIfPossible((Rhombus) shape);
            }
            return shape;
        }
        throw new Exception(shapeName + " is not avaliable shape");
    }

    private Shape convertRhombusToSquareIfPossible(Rhombus rhombus) {
        if (rhombus.getLongDiagonalLength() - rhombus.getShortDiagonalLength() < 0.0001) {
            return Square.withDiagonalLength(rhombus.getShortDiagonalLength());
        }
        return rhombus;
    }
}
