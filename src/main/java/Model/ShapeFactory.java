package Model;

import java.util.ArrayList;
import java.util.List;

import Model.ShapeFactoryWorkers.CircleWorker;
import Model.ShapeFactoryWorkers.ShapeFactoryWorker;
import Model.ShapeFactoryWorkers.SquareWorker;
import Model.Shapes.Figure;

public class ShapeFactory {

    private List<ShapeFactoryWorker> workers = new ArrayList<>();

    public ShapeFactory() {
        this.registerWorker(new SquareWorker());
        this.registerWorker(new CircleWorker());
    }

    public void registerWorker(ShapeFactoryWorker worker) {
        workers.add(worker);
    }

    public Figure createShape(
            String ShapeName,
            String[] parametersNames,
            Double[] parametersValues) throws Exception {

        for (double value : parametersValues) {
            if (value < 0) {
                throw new Exception("Value cannot be negative.");
            }
        }

        for (ShapeFactoryWorker worker : workers) {
            if (worker.acceptParameters(ShapeName, parametersNames, parametersValues)) {
                return worker.create(parametersNames, parametersValues);
            }
        }
        throw new Exception("Shape is not avaliable");
    }

    public static boolean checkParametersTypes(String[] parametersTypes, String[] types) {
        for (String parameter : parametersTypes) {
            if (!checkParameterTypes(parameter, types)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkParameterTypes(String parameterType, String[] types) {
        for (String type : types) {
            if (type.equals(parameterType)) {
                return true;
            }
        }
        return false;
    }
}
