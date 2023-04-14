package factory;

import shapes.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeFactory {

    public enum ShapeName {
        circle, square, rectangle, rhombus, regulartriangle
    }

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

    private void registerWorker(ShapeFactoryWorker worker)
    {
        _workers.add(worker);
    }

    public Shape createShape(
            ShapeName shapeName,
            List<ArgumentType> parametersNames,
            List<Double> parametersValues) throws Exception {

        for (ShapeFactoryWorker worker : _workers)
        {
            Shape createdShape = worker.create(shapeName, parametersNames, parametersValues);

            if (createdShape != null)
            {
                return createdShape;
            }
        }

        throw new Exception(shapeName + " is not avaliable in factory");
    }
}
