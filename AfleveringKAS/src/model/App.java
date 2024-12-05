package model;

import controller.Controller;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {


    //konferencer
   Konference k1 = Controller.createKonference("Hav og Himmel","OrmslevVej",
            LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),
            "miljø",1500);

    //hoteller
       Hotel h1 = Controller.createHotel("Den hvide svane","203023","funder",1050,1250);
        Controller.addHotelTilKonference(k1,h1);
        //------------------------------------------------------------------
        //ekstra
      Ekstra e1=  Controller.createEkstra(50,"WIFI",h1);

//-----------------------------------------------------------------------
        //Udflugt
        Udflugt u1 = Controller.createUdflugt(LocalDate.of(2024,12,18),LocalTime.now(),LocalTime.now(),"Byrundtur","Odense",125,k1);
        Udflugt u2 = Controller.createUdflugt(LocalDate.of(2024,12,19), LocalTime.now(), LocalTime.now(),"Egeskov","Indgang",75,k1);
        Udflugt u3 = Controller.createUdflugt(LocalDate.of(2024,12,20),LocalTime.now(),LocalTime.now(),"Trapholt","Kolding",200,k1);

        //---------------------------------------------------

   //deltagere

  Deltager d1 = Controller.createDeltager("Finn Madsen","Silkeborg","DK","23303");
        Deltager d2 = Controller.createDeltager("Niels Petersen","Silkeborg","Dk","2034");
        Deltager d3 = Controller.createDeltager("Peter Sommer","Silkeborg","DK","1239912");
        Deltager d4 = Controller.createDeltager("Lone Jensen","Bobbity","DK","2023");
  //-----------------------------------------------------------------------------------------------

        //tilmeldinger
        Tilmelding t1 = Controller.createTilmelding(LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),
                false,k1,d1);

        Tilmelding t2 = Controller.createTilmelding(LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),false,k1,d2);

        Tilmelding t3  = Controller.createTilmelding(LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),false,k1,d3);

        Tilmelding t4  = Controller.createTilmelding(LocalDate.of(2023,10,18),LocalDate.of(2023,10,20),true,k1,d4);

        //ledsagere
        Ledsager l1 = Controller.createLedsager("mie","20923",t3);
        Ledsager l2 = Controller.createLedsager("Jan Madsen","20230",t4);

        //tilføj tilmelding til hotel

        Controller.addTilmeldingTilHotel(h1,t2);
        Controller.addTilmeldingTilHotel(h1,t3);
        Controller.addTilmeldingTilHotel(h1,t4);
  //------------------------------------------------------------------------------
        //tilføj tilmelding til udflugt

Controller.addTilmeldingTilUdflugt(u1,t3);
Controller.addTilmeldingTilUdflugt(u2,t3);
Controller.addTilmeldingTilUdflugt(u1,t4);
Controller.addTilmeldingTilUdflugt(u3,t4);
//-----------------------------------------------------------------
//tilføj ekstra til tilmelding
        Controller.addEkstraTilTilmelding(h1,t3,e1);
        Controller.addEkstraTilTilmelding(h1,t4,e1);
        //--------------------------------------------------------------------
//        System.out.println(Controller.getdeltagerTilkonferencen(k1));
        System.out.println(Controller.getUdflugtMedDeltagerOgLedsager(k1));
//        System.out.println(Controller.getHotelMedDeltagerogledsager(k1));
//        System.out.println(Controller.getDeltagerMedFuldInfo(d1));

Controller.Tofile(Controller.getHotelMedDeltagerogledsager(k1),"hotelnavn");
    }
}
