public class Square extends Figure{
    protected double sideLength;
    protected double diagonalLength;

    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                ", diagonalLength=" + diagonalLength +
                ", surfaceArea=" + surfaceArea +
                '}';
    }

    public Square(double value, int which) throws Exception {
        super();
        if(value < 0) throw new Exception("Value cannot be negative.");
        switch(which) {
            case 0:
                this.surfaceArea = value;
                this.sideLength = Math.pow(surfaceArea,0.5);
                this.diagonalLength = sideLength * Math.pow(2.0,0.5);
                break;
            case 1:
                this.diagonalLength = value;
                this.surfaceArea = diagonalLength * diagonalLength / 2;
                this.sideLength = Math.pow(surfaceArea,0.5);
                break;
            default:
                this.sideLength = value;
                this.diagonalLength = sideLength * Math.pow(2,0.5);
                this.surfaceArea =  sideLength * sideLength;
                // code block
        }


    }
}
