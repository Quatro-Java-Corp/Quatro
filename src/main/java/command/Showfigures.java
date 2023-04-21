package command;

import shapes.ShapeRepository;

class Showfigures implements Command{
    ShapeRepository shapeRepo;

    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";

    public Showfigures(ShapeRepository shapeRepo) {
        this.shapeRepo = shapeRepo;
    }

    @Override
    public void run() {
            shapeRepo.getShapes().forEach(System.out::println);
    }
}
