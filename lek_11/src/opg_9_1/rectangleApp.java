package opg_9_1;

public class rectangleApp {
    public static void main(String[] args) {
        rectangle r1 = new rectangle();
        r1.setHeight(1);
        r1.getHeight();
        r1.setWidth(1);
        r1.getWidth();

        r1.getArea();
        r1.getPerimeter();

        r1.opg_9_1Print();
        System.out.println("______________________");
        rectangle r2 = new rectangle();
        r2.setHeight(40);
        r2.setWidth(4);
        r2.getHeight();
        r2.getWidth();
        r2.getArea();
        r2.getPerimeter();

        r2.opg_9_1Print();
    }
}
