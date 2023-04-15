package factory;

import java.util.List;
import java.util.Map.Entry;

import factory.ShapeFactory.ArgumentType;
import shapes.Shape;

public interface ShapeFactoryWorker {
    Shape create(List<Entry<ArgumentType, Double>> args) throws Exception;
}
