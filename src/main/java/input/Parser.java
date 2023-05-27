package input;

import java.util.Map;

import command.CommandFactory.CommandName;
import exceptions.argument.InvalidArgumentTypeException;
import exceptions.argument.InvalidArgumentValueException;
import exceptions.command.InvalidFunctionNameException;
import exceptions.factory.UnknownShapeException;
import factory.ShapeFactory.ArgumentType;
import utils.ActiveLanguage;

public class Parser {

    private static final Map<String, CommandName> CommandDictionaryPL = Map.ofEntries(
            Map.entry("zakoncz", CommandName.exit),
            Map.entry("pokaz", CommandName.showfigures),
            Map.entry("sortuj", CommandName.sort),
            Map.entry("opisz", CommandName.circumscribed),
            Map.entry("zdubluj", CommandName.doubled),
            Map.entry("usun", CommandName.remove),
            Map.entry("dodaj", CommandName.add),
            Map.entry("zapisz", CommandName.save),
            Map.entry("precyzja", CommandName.precision),
            Map.entry("jezyk", CommandName.language));

    private static final Map<String, ArgumentType> ArgumentTypeDictionaryPL = Map.ofEntries(
            Map.entry("bok", ArgumentType.side),
            Map.entry("przekątna", ArgumentType.diagonal),
            Map.entry("powierzchnia", ArgumentType.area),
            Map.entry("promień", ArgumentType.radius),
            Map.entry("średnica", ArgumentType.diameter),
            Map.entry("obwód", ArgumentType.circuit),
            Map.entry("wysokość", ArgumentType.height),
            Map.entry("podstawa", ArgumentType.base),
            Map.entry("przyprostokatka", ArgumentType.cathetus),
            Map.entry("przeciwprostokątna", ArgumentType.hypotenuse),
            Map.entry("półośmała", ArgumentType.semiminoraxis),
            Map.entry("półoświelka", ArgumentType.semimajoraxis),
            Map.entry("dlugapodstawa", ArgumentType.shortbase),
            Map.entry("krótkapodstawa", ArgumentType.longbase));

    private static final Map<String, String> ShapeNameDictionaryPL = Map.ofEntries(
            Map.entry("koło", "circle"),
            Map.entry("elipsa", "ellipse"),
            Map.entry("trapezrównoramienny", "isoscelestrapezoid"),
            Map.entry("trójkątrównoramienny", "isoscelestriangle"),
            Map.entry("prostokąt", "rectangle"),
            Map.entry("trójkątrównoboczny", "regulartriangle"),
            Map.entry("romb", "rhombus"),
            Map.entry("trójkątprostokątny", "righttriangle"),
            Map.entry("kwadrat", "square"));

    public CommandName parseCommand(String command) {
        try {
            return switch (ActiveLanguage.language) {
                case PL -> CommandDictionaryPL.get(command.toLowerCase());
                default -> CommandName.valueOf(command.toLowerCase());
            };
        } catch (IllegalArgumentException e) {
            throw new InvalidFunctionNameException();
        }
    }

    public ArgumentType parseArgumentType(String s) {
        try {
            return switch (ActiveLanguage.language) {
                case PL -> ArgumentTypeDictionaryPL.get(s.toLowerCase());
                default -> ArgumentType.valueOf(s.toLowerCase());
            };
        } catch (IllegalArgumentException e) {
            throw new InvalidArgumentTypeException();
        }
    }

    public Double parseArgumentValue(String s) {
        try {
            double val = Double.parseDouble(s);
            if (val <= 0) {
                throw new NumberFormatException();
            }
            return val;
        } catch (NumberFormatException e) {
            throw new InvalidArgumentValueException();
        }
    }

    public String parseShapeName(String shapeName) {
        try {
            return switch (ActiveLanguage.language) {
                case PL -> ShapeNameDictionaryPL.get(shapeName.toLowerCase());
                default -> shapeName.toLowerCase();
            };
        } catch (IllegalArgumentException e) {
            throw new UnknownShapeException(shapeName);
        }
    }
}
