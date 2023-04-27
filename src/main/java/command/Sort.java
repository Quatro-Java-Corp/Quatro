package command;

import repository.ComparatorFactory;
import repository.ShapeRepository;

import java.util.Queue;

class Sort implements Command {
    private final ShapeRepository shapeRepository;
    private final Queue<String> args;
    private final ComparatorFactory comparatorFactory = new ComparatorFactory();

    public Sort(Queue<String> args, ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
        this.args = args;
    }

    @Override
    public void run() {
        try {
            shapeRepository.sort(comparatorFactory.getComparator(
                            ComparatorFactory.CompareBy.valueOf(args.poll()),
                            ComparatorFactory.OrderBy.valueOf(args.poll())
                    )
            );
            shapeRepository.print();
        } catch (Exception e) {
            System.out.println("Wrong sort arguments");
        }
    }
}
