package input;

import command.CommandFactory.CommandName;
import exceptions.argument.InvalidArgumentTypeException;
import exceptions.argument.InvalidArgumentValueException;
import exceptions.command.InvalidFunctionNameException;
import exceptions.factory.UnknownShapeException;
import factory.ShapeFactory.ArgumentType;
import utils.Dictionary;

public class Parser {

    public CommandName parseCommand(String command) {
        try {
            return CommandName.valueOf(Dictionary.toENG(command.toLowerCase()));
        } catch (IllegalArgumentException e) {
            throw new InvalidFunctionNameException();
        }
    }

    public ArgumentType parseArgumentType(String type) {
        try {
            return ArgumentType.valueOf(Dictionary.toENG(type.toLowerCase()));
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
            return Dictionary.toENG(shapeName.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new UnknownShapeException(shapeName);
        }
    }
}
