package Model.ShapeFactoryWorkers;

import Model.Shapes.Figure;

public interface ShapeFactoryWorker {
    boolean acceptParameters(String ShapeName, String[] arguments, Double[] parameterObject);

    Figure create(String[] arguments, Double[] parameterObject) throws Exception;
}
