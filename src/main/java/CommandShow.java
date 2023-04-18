public class CommandShow implements Command{
    Boolean noArgs;
    ShapeRepository shapeRepo;

    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";

    public CommandShow(ShapeRepository shapeRepo,Boolean noArgs) {
        this.shapeRepo = shapeRepo;
        this.noArgs = noArgs;
    }

    @Override
    public void run() {
        if ( !noArgs)
            System.out.println(NO_NEED_ARGUMENTS);
        else
            shapeRepo.getShapes().forEach(System.out::println);
    }
}
