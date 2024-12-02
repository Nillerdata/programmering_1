package model;

import java.time.LocalDate;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {


        Konference k1 = new Konference("ob","fjidf",
                LocalDate.of(2023,10,12),LocalDate.of(2023,11,15),
                "miljø",500);
        Hotel h1 = new Hotel("Radison","554","sodfkdsof",33,55);
        k1.addhotel(h1);
        h1.createEkstra(55,"Mad");

        Deltager d1 = new Deltager("funder","Silkeborg","DK","23303");
        k1.createTilmelding(LocalDate.of(2023,5,20),LocalDate.of(2023,6,24),
                false,d1);

    }
}
