package factory;

import java.util.List;

import factory.ShapeFactory.ArgumentType;
import factory.ShapeFactory.ShapeName;
import shapes.Shape;

public interface IShapeFactoryWorker {
    Shape create(ShapeName shapeName, List<ArgumentType> paramsTypes, List<Double> paramsValues) throws Exception;
}
