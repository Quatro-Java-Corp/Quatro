import java.util.LinkedList;
import java.util.List;

public class FigureRepository {
    private final List<Figure> figures=new LinkedList<>();

    public void addFigure(Figure figure){
        figures.add(figure);
    }

    public List<Figure> getFigures(){
        figures.sort( (Figure a, Figure b) -> a.getSurfaceArea() < b.getSurfaceArea() ? -1 : 1);
        return figures;
    }
}
