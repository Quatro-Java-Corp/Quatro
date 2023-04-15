package factory;

import shapes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class ShapeFactory {

    public enum ArgumentType {
        side, diagonal, area, radius, diameter, circuit, height
    }

    private List<ShapeFactoryWorker> _workers = new ArrayList<ShapeFactoryWorker>();

    public ShapeFactory() {
        registerWorker(new CircleFactoryWorker());
        registerWorker(new SquareFactoryWorker());
        registerWorker(new RegularTriangleFactoryWorker());
        registerWorker(new RectangleFactoryWorker());
        registerWorker(new RhombusFactoryWorker());
    }

    private void registerWorker(ShapeFactoryWorker worker) {
        _workers.add(worker);
    }

    public Shape createShape(String shapeName, List<Entry<ArgumentType, Double>> args) throws Exception {
        for (ShapeFactoryWorker worker : _workers) {
            Shape createdShape = worker.create(shapeName, args);

            if (createdShape != null) {
                return createdShape;
            }
        }
        throw new Exception(shapeName + " is not avaliable shape");
    }
}
