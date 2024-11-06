package opg_1;

public class RentalApp {
    public static void main(String[] args) {

        //rental
        Rental r1 = new Rental(50, "02/10-24", 5);


        Car c1 = new Car("bs", 2000);
        r1.addCar(c1);

        c1.setDayPrice(2000);

        r1.getDays();
        c1.getMaxDays();

        System.out.println(c1.getMaxDays());


    }

}
