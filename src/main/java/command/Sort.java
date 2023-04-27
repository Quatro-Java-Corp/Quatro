package command;

import exceptions.IllegalSortArgumentException;
import repository.ComparatorFactory;
import repository.ShapeRepository;

class Sort implements Command {
    private final ShapeRepository shapeRepo;
    private final String[] args;
    private final ComparatorFactory comparatorFactory = new ComparatorFactory();

    public Sort(String[] args, ShapeRepository shapeRepo) {
        this.shapeRepo = shapeRepo;
        this.args = args;
    }

    @Override
    public void run() {
        try {
            shapeRepo.sort(comparatorFactory.getComparator(ComparatorFactory.CompareBy.valueOf(args[1]),
                    ComparatorFactory.OrderBy.valueOf(args[2])));
        } catch (Exception e) {
            throw new IllegalSortArgumentException();
        }
    }
}
