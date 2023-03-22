public class Quatro {
    public static void main(String[] args) {
        try {
            Square sqr = new Square(4,3);
            System.out.println(sqr.toString());
            Circle crc = new Circle(4,3);
            System.out.println(crc.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}

