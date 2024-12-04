package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {


        //Konferencer
        Konference k1 = new Konference("Hav og Himmel","OrmslevVej",
                LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),
                "miljø",1500);
    //hoteller
        Hotel h1 = new Hotel("Den hvide svane","203023","funder",1050,1250);


    //tilvalg til hoteller
    Ekstra e1 = h1.createEkstra(50,"WIFI");




        //tilføj hotel til konf
        h1.addKonference(k1);



        //Udflugter
        Udflugt u3 = k1.createUdflugt(LocalDate.of(2024,12,18),LocalTime.now(),LocalTime.now(),"Byrundtur","Odense",125);
       Udflugt u1 =   k1.createUdflugt(LocalDate.of(2024,12,19), LocalTime.now(), LocalTime.now(),"Egeskov","Indgang",75);
        Udflugt u2 = k1.createUdflugt(LocalDate.of(2024,12,20),LocalTime.now(),LocalTime.now(),"Trapholt","Kolding",200);


        //Deltagere

        Deltager d1 = new Deltager("Finn Madsen","Silkeborg","DK","23303");
        Deltager d2 = new Deltager("Niels Petersen","Silkeborg","Dk","2034");
        Deltager d3 = new Deltager("Peter Sommer","Silkeborg","DK","1239912");
        Deltager d4 = new Deltager("Lone Jensen","Bobbity","DK","2023");



        //Tilmeldinger

        //k1 tilmeldinger
         Tilmelding t1 = k1.createTilmelding(LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),
                 false,d1);

        Tilmelding t2 = k1.createTilmelding(LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),false,d2);

        Tilmelding t3  = k1.createTilmelding(LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),false,d3);

        Tilmelding t4  = k1.createTilmelding(LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),true,d4);
        //ledsagere
        Ledsager l1 = t3.createLedsager("mie","20923");
        Ledsager l2 = t4.createLedsager("Jan Madsen","20230");

        //tilføj tilmelding til hotel
        h1.addTilmelding(t2);
        h1.addTilmelding(t3);
        h1.addTilmelding(t4);

        //tilføj tilmelding til udflugt
        u1.addTilmelding(t3);
        u2.addTilmelding(t3);

        u1.addTilmelding(t4);
        u3.addTilmelding(t4);

        //tilføj ekstra til tilmelding
        t3.addEkstra(e1);
        t4.addEkstra(e1);
        //print metoder


        System.out.println(t1.getSamletPris());
        System.out.println(t2.getSamletPris());
        System.out.println(t3.getSamletPris());
        System.out.println(t4.getSamletPris());






    }

}
