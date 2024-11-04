package opg3;

public class RentalApp {
    public static void main(String[] args) {

        //rental
        Rental r1 = new Rental(50, "02/10-24", 5);
        Rental r2 = new Rental(20, "24/12-2024", 10);

        //biler
        Car c1 = new Car("valid", 3);
        Car c2 = new Car("Hola", 3);
        Car c3 = new Car("Bonjour", 5);
        Car c4 = new Car("Guten tag", 5);
        Car c5 = new Car("sparkecykel", 5);
       r1.addCar(c1);
       r1.addCar(c2);

        c1.setDayPrice(2000);
        c2.setDayPrice(5);
        System.out.println(r1.getPrice());
    }

}
