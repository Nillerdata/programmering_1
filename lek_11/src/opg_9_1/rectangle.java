package opg_9_1;

public class rectangle {
    private double height;
    private double width;
    private double area;
    private double perimeter;

public rectangle(){
    }
    //sætter højde her
    public void setHeight(double height) {
        this.height = height;
}
    public double getHeight(){
    return this.height;
    }
    //sætter width her
    public void setWidth(double width){
    this.width=width;
    }
    public double getWidth(){
    return this.width;
    }
    //area
    public double getArea(){
    area = height * width;
    return this.area;
    }
    //perimeter
    public double getPerimeter(){
    perimeter = (height*2) + (width*2);
    return this.perimeter;
    }
public void opg_9_1Print(){
    System.out.println("____________________");
    System.out.println(height);
    System.out.println(width);
    System.out.println(area);
    System.out.println(perimeter);
    System.out.println("____________________");
    }
}
