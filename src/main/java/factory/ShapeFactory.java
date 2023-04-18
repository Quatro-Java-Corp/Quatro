package factory;

import shapes.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ShapeFactory {

    public enum ArgumentType {
        side, diagonal, area, radius, diameter, circuit, height, base
    }

    private Map<String, ShapeFactoryWorker> workers = new HashMap<String, ShapeFactoryWorker>();

    public ShapeFactory() {
        registerWorker(CircleFactoryWorker.shapeName, new CircleFactoryWorker());
        registerWorker(SquareFactoryWorker.shapeName, new SquareFactoryWorker());
        registerWorker(RegularTriangleFactoryWorker.shapeName,new RegularTriangleFactoryWorker());
        registerWorker(RectangleFactoryWorker.shapeName, new RectangleFactoryWorker());
        registerWorker(RhombusFactoryWorker.shapeName, new RhombusFactoryWorker());
        registerWorker(IsoscelesTriangleFactoryWorker.shapeName, new IsoscelesTriangleFactoryWorker());
    }

    private void registerWorker(String shapeName, ShapeFactoryWorker worker) {
        workers.put(shapeName, worker);
    }

    public Shape createShape(String shapeName, List<Entry<ArgumentType, Double>> args) throws Exception {
        if (workers.containsKey(shapeName)) {
            return workers.get(shapeName).create(args);
        }
        throw new Exception(shapeName + " is not avaliable shape");
    }
}
