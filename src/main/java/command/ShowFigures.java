package command;

import repository.ShapeRepository;

public class ShowFigures implements Command{
    private final ShapeRepository shapeRepo;

    private static final String NO_NEED_ARGUMENTS = "This function don't need any arguments";

    public ShowFigures(ShapeRepository shapeRepo) {
        this.shapeRepo = shapeRepo;
    }

    @Override
    public void run() {
        shapeRepo.print();
    }
}
