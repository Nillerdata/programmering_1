package opgave_3;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class rentalApp {
    public static void main(String[] args) {
        rental r1 = new rental(23,30, 1000,LocalDate.of(2024,10,1));
        System.out.println(r1.toString());


        LocalDate dato = LocalDate.now();
        rental r2 = new rental(23,50,1000,dato.plusMonths(10));
        r2.getTotalPrice();
        r2.getStartdate();
        r2.getEndDate();
        System.out.println(r2);


        long days = ( ChronoUnit.DAYS.between(r1.getEndDate(), r2.getStartdate()));
        System.out.println(days);


    }

}
