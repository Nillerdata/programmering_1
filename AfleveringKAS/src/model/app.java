package model;
import java.time.LocalTime;
import java.time.LocalDate;
import model.controller.Controller;

public class app {


    public static void main(String[] args) {

        LocalDate startDato = LocalDate.of(2024, 12, 18);

        LocalDate startDato1 = LocalDate.of(2024, 12, 12);

        LocalDate startdato2 = LocalDate.of(2024,12,20);



        LocalDate slutDato = LocalDate.of(2024, 12, 20);

        LocalTime startTid = LocalTime.of(14, 30);

        LocalTime slutTid = LocalTime.of(18,30);

        //LocalDateTime uflugtstart = LocalDateTime.of(startDato,startTid);

        //Konference

       Konference Hav_og_himmel = new Konference("Hav og himmel","Adresse 1",startDato,slutDato,"Miljøkonference",1500);

       // Udflugter
       Udflugt BYrundtur_Odense = Hav_og_himmel.createUdflugt(startDato,startTid,slutTid,"ByrundTur","foreyen",125);
       Udflugt Egeskov = Hav_og_himmel.createUdflugt(startDato1,startTid,slutTid,"Egeskov","foreyen",75);
       Udflugt TrapHollt_Museum = Hav_og_himmel.createUdflugt(startdato2,startTid,slutTid,"Trapholdt Museum, Kolding","foryen",200);

       //Hoteller objekter
       Hotel Den_hvidesvane = new Hotel("Den hvide Svane","20301750","Niels juels gade",1050,1250);
       Hotel Høtel_Phonix = new Hotel("Høtel Phønix","20302020","Gyvelvænget",700,800);
       Hotel Pension_Tusindfryd = new Hotel("Pension Tusindfryd","88888888","Thordenskjold",500,600);

       // adder hoteller til konferrencen
       Hav_og_himmel.addHotel(Den_hvidesvane);
       Hav_og_himmel.addHotel(Høtel_Phonix);
       Hav_og_himmel.addHotel(Pension_Tusindfryd);

       //Creater Ekstra til hoteller

       Ekstra wifi = Den_hvidesvane.CreateEkstra("Wi-fi" , 50);
       Ekstra bad = Høtel_Phonix.CreateEkstra("Bad",200);
       Ekstra Wifi = Høtel_Phonix.CreateEkstra("Bad",75);
       Ekstra Morgenmad = Pension_Tusindfryd.CreateEkstra("Morgenmad",100);

       //Opretter deltager
       Deltager deltager = new Deltager("Finn","niels juels","Danmark","20301760");
       Deltager d1_Niels = new Deltager("Niels Petersen","Niels juselgade","Danmark","20304004");
       Deltager d2_Peter = new Deltager("Peter", "thordenskjold","Danmark","20301750");
       Deltager d3_Lone = new Deltager("Lone","adresse","Danmark","88888888");


       //Opretter Ankomstdato og afrejsedato til vores objekter

        LocalDate AnkomstDato = LocalDate.of(2024,12,18);
        LocalDate AfrejseDato = LocalDate.of(2024,12,20);


       //Tilmelder deltager til konference
       Tilmelding t1 = Hav_og_himmel.createTilmelding(AnkomstDato,AfrejseDato,false,deltager);
       Tilmelding T1_Niels = Hav_og_himmel.createTilmelding(AnkomstDato,AfrejseDato,false,d1_Niels);
       Tilmelding t1_peter = Hav_og_himmel.createTilmelding(AnkomstDato,AfrejseDato,false,d2_Peter);
       Tilmelding t_1_lone = Hav_og_himmel.createTilmelding(AnkomstDato,AfrejseDato,true,d3_Lone);

       //Opretter ledsager til vores deltager
        Ledsager ledsagerTilPeter = t1_peter.createLedsager("Mie Sommer","20301750");
        Ledsager ledsagertilLone = t_1_lone.createLedsager("Jan","12345678");


       //Tilmelder hotel til objekter
        Den_hvidesvane.AddTilmeldning(T1_Niels);
        Den_hvidesvane.AddTilmeldning(t1_peter);
        Den_hvidesvane.AddTilmeldning(t_1_lone);

        System.out.println(ledsagerTilPeter.getDeltager());

        // jeg adder ekstra til vores tilmeldning;
        t1_peter.addEkstra(wifi);
        t_1_lone.addEkstra(wifi);

       //Tilmelder ledsager til udflugter

        t1_peter.addUdflugt(Egeskov);
        t1_peter.addUdflugt(TrapHollt_Museum);
        t_1_lone.addUdflugt(Egeskov);
        t_1_lone.addUdflugt(BYrundtur_Odense);



       System.out.println("Det er denne samlet pris for Finn " + t1.getSamletPris());

       System.out.println("Det er Den samlet Pris for Niels " + T1_Niels.getSamletPris());

       System.out.println("Det er den samlet pris for Peter sommer " + t1_peter.getSamletPris());

       System.out.println("Samlet pris for lone " + t_1_lone.getSamletPris());
//

        //-----------------------------------------------------------------------------------

        // Opretter Deltager
        Deltager D_Nikolaj = Controller.createDeltager("Nikolaj","gyvelvænget 9 ","Danamrk","20301750");
        Deltager D_Peter = Controller.createDeltager("Peter","Niels juels gade","Danmark", "20301750");
        Deltager D_Mike = Controller.createDeltager("Mike","thordenskjoldsgade","Danmark","20301540");

        // Opretter konference
        Konference konference = Controller.createKonference("Miljøkonference","Vejle 22",startDato,slutDato,"Ik alt det der fis mette",300);

        //Opretter tilmeldinger
        Tilmelding T_Mike = Controller.createTilmeldning(startDato,slutDato,false,D_Mike,konference);
        Tilmelding T_Peter = Controller.createTilmeldning(startDato,slutDato,false,D_Peter,konference);
        Tilmelding T_Nikolaj = Controller.createTilmeldning(slutDato,slutDato,false,D_Nikolaj,konference);

        //Opretter hoteller
        Hotel hotel = Controller.createHotel("MarienLyst","20202020","Niels Juels Gade",200,250);
        Ekstra ekstra = Controller.createEkstra("Bad",35,hotel);

        //Opretter Udflugt
        Udflugt udflugt = Controller.createUdflugt(startDato,startTid,slutTid,"HekseJagt","Foryen",200,konference);

        //Opretter Ledsager
        Ledsager ledsager = Controller.createLedsager("Nikolaj","20301750",T_Mike);

        //Tilmelder Ledsager ti Udflugt
        Controller.AddLedsagerTilUdflugt(T_Mike,udflugt);

        //Adder hotel til konference
        Controller.AddHotelTilKonference(hotel,konference);

        // Kalder controller metoder for og se om de virker
        Controller.AddHotelTilTilmeldning(hotel,T_Mike);

        System.out.println("Alle deltager til konference og deres info " + Controller.getdeltagerTilkonferencen(konference));

        System.out.println("Alle deltager til konferrence og hvor de bor " + Controller.getHotelMedDeltagerogledsager(konference));

        System.out.println("Alle Udflugter og info" + Controller.getUdflugtMedDeltagerOgLedsager(konference));

        System.out.println("Deltager info " + Controller.getDeltagerMedFuldInfo(D_Mike));









    }
}
