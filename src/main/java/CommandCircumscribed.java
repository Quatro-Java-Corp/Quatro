import shapes.Circle;
import shapes.Shape;

import java.util.Optional;

public class CommandCircumscribed implements  Command{
     private ShapeRepository figureList;
     private String[] args;

    public CommandCircumscribed(String[] args, ShapeRepository figureList) {
        this.figureList = figureList;
        this.args = args;
    }

    @Override
    public void run() {

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


    }
}
