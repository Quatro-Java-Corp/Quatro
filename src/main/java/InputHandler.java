import repository.ComparatorFactory;
import repository.ShapeRepository;
import shapes.Circle;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;
import java.util.Optional;

import factory.ShapeFactory;
import factory.ShapeFactory.ArgumentType;

public class InputHandler {

    private final ShapeFactory shapeFactory = new ShapeFactory();
    private final ShapeRepository figureList = new ShapeRepository();
    private final ComparatorFactory comparatorFactory=new ComparatorFactory();

    private static final String INVALID_ARGUMENT_VALUE = "Value must be a positive number.";
    private static final String INVALID_ARGUMENT_TYPE = "Unknown argument name";
    private static final String INVALID_NUMBER_OF_ARGUMENTS = "Each argument type must have a value";
    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";
    private static final String UNKNOWN_FUNCTION = "Unknown function";

    public void parseInput(String input) {
        String[] args = input.split(" ");
        if (args.length > 0) {
            if (args.length == 1 && args[0].equals("exit")) {
                System.exit(0);
            } else if(args.length==2 && args[0].equalsIgnoreCase("circumscribed")){
                try{
                    int index=Integer.parseInt(args[1]);
                    Shape shape=figureList.get(index).orElseThrow(Exception::new);
                    Optional<Circle> optionalCircle=shape.getCircumscribedCircle();
                    if(optionalCircle.isPresent()){
                        System.out.println(optionalCircle.get());
                        figureList.addShape(optionalCircle.get());
                    }
                    else{
                        System.out.println("No circle for this shape");
                    }
                }
                catch (Exception e){
                    System.out.println("Illegal Index");
                }
            } else if(args.length==2 && args[0].equalsIgnoreCase("doubled")){
                try {
                    int index = Integer.parseInt(args[1]);
                    Shape shape = figureList.get(index).orElseThrow(Exception::new);
                    Shape doubledSizedShape = shape.getDoubledSized();

                    System.out.println(doubledSizedShape);
                    figureList.addShape(doubledSizedShape);
                }
                catch (Exception e){
                    System.out.println("Illegal Index");
                }
            }
            else if (args.length % 2 == 0) {
                System.out.println(INVALID_NUMBER_OF_ARGUMENTS);
            } else if (args.length >= 1 && args[0].equalsIgnoreCase("showfigures")) {
                if (args.length != 1)
                    System.out.println(NO_NEED_ARGUMENTS);
                figureList.print();
            } else if (args.length == 1) {
                System.out.println(UNKNOWN_FUNCTION);
            }
            else if(args.length==3 && args[0].equalsIgnoreCase("sort")){
                try {
                    figureList.sort(comparatorFactory.getComparator(ComparatorFactory.CompareBy.valueOf(args[1]),ComparatorFactory.OrderBy.valueOf(args[2])));
                }
                catch (Exception e) {
                    System.out.println("Wrong sort arguments");
                }
            }
            else {
                try {
                    Shape shape = createFigureWithArguments(args);
                    figureList.addShape(shape);
                    System.out.println(shape.toString());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public Shape createFigureWithArguments(String[] args) throws Exception {
        return shapeFactory.createShape(args[0], getArgumentsList(args));
    }

    private static List<Entry<ArgumentType, Double>> getArgumentsList(String[] args) throws Exception {
        List<Entry<ArgumentType, Double>> argsList = new ArrayList<>();
        for (int i = 1; i < args.length; i += 2) {
            argsList.add(new SimpleImmutableEntry<>(
                    convertStringToArgumentType(args[i]),
                    convertStringToArgumentValue(args[i + 1])));
        }
        return argsList;
    }

    private static ShapeFactory.ArgumentType convertStringToArgumentType(String s) throws Exception {
        try {
            return ShapeFactory.ArgumentType.valueOf(s.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new Exception(INVALID_ARGUMENT_TYPE);
        }
    }

    private static Double convertStringToArgumentValue(String s) throws Exception {
        try {
            double val = Double.parseDouble(s);
            if (val <= 0) {
                throw new NumberFormatException();
            }
            return val;
        } catch (NumberFormatException e) {
            throw new Exception(INVALID_ARGUMENT_VALUE);
        }
    }
}
