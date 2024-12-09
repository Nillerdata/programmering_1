package Aplication;

import model.controller.Controller;
import javafx.application.Application;
import model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class GUI_APP {

    public static void main(String[] args) {

        initStorage();
        Application.launch(GUI.class);

    }

    private static void initStorage(){

        //Opretter mine Datoer
        LocalDate StartDato = LocalDate.of(2024,12,18);
        LocalDate SlutDato = LocalDate.of(2024,12,20);

        LocalDate startDato1 = LocalDate.of(2024,12,18);
        LocalDate slutDato1 = LocalDate.of(2024,12,20);

        LocalDate Dato19 = LocalDate.of(2024,12,18);
        LocalDate Dato20 = LocalDate.of(2024,12,18);


        LocalTime startTidspunktUdflugtOdense = LocalTime.of(10, 0);
        LocalTime SlutTidspunktUdflugtOdense = LocalTime.of(14,0);



        // Opretter konference
        Konference K_Hav_og_Himmel = Controller.createKonference("Hav og Himmel","Niels Juels Gade" ,StartDato,SlutDato,"Dejligt miljø konference med alt muligt lækkert",1500);

        //Opretter Hoteller og Adder ekstra til vores Hoteller

        Hotel H_Den_Hvide_svane = Controller.createHotel("Den Hvide Svane","12121212","Aarhus 8000, Spurven 12",1050,1250);
        Ekstra E_WIFI_Den_Hvide_svane = Controller.createEkstra("WIFI",50,H_Den_Hvide_svane);

        Hotel H_Høtel_Phonix = Controller.createHotel("Høtel Phønix","12312312","Odense 1200, sprækken 12",700,800);
        Ekstra E_bad_Høtel_Phønix = Controller.createEkstra("Bad",200,H_Høtel_Phonix);
        Ekstra E_Wifi_Høtel_Phønix = Controller.createEkstra("Wifi",75,H_Høtel_Phonix);


        Hotel H_Pension_Tusindfryd = Controller.createHotel("Pension Tusindfryd","12341234","Odense 1200, spætten 13",500,600);
        Ekstra E_Morgenmad_Pension_Tusindfryd = Controller.createEkstra("Morgenmad",100,H_Pension_Tusindfryd);

        // Opretter deltager
        Deltager D_Finn = Controller.createDeltager("Finn Madsen","Gyvelvænget","Danmark","20202020");

        Deltager D_Niels_Petersen = Controller.createDeltager("Niels Petersen","Niels Juels","Finland","12345678");

        Deltager D_Peter_Sommer = Controller.createDeltager("Peter Sommer","Geanvænget 2","Danmark","20301750");

        Deltager D_Lone_Jensen = Controller.createDeltager("Lone Jensen","Spurven 12","Finland","88888888");



        //Opretter tilmeldninger
        Tilmelding T_Finn = Controller.createTilmeldning(startDato1,slutDato1,false,D_Finn,K_Hav_og_Himmel);

        Tilmelding T_Niels_Petersen = Controller.createTilmeldning(startDato1,slutDato1,false,D_Niels_Petersen,K_Hav_og_Himmel);

        Tilmelding T_Peter_sommer = Controller.createTilmeldning(startDato1,slutDato1,false,D_Peter_Sommer,K_Hav_og_Himmel);

        Tilmelding T_Lone_Jensen = Controller.createTilmeldning(startDato1,slutDato1,true,D_Lone_Jensen,K_Hav_og_Himmel);

        //Opretter Udflugter
        Udflugt U_Byrundtur_Odense = Controller.createUdflugt(startDato1,startTidspunktUdflugtOdense,SlutTidspunktUdflugtOdense,"Byrundtur, Odense","foyer",125,K_Hav_og_Himmel);

        Udflugt U_Egeskov = Controller.createUdflugt(Dato19,startTidspunktUdflugtOdense,SlutTidspunktUdflugtOdense,"Egeskov","foyer",75,K_Hav_og_Himmel);

        Udflugt U_Traphold_Museum_Kolding = Controller.createUdflugt(Dato20,startTidspunktUdflugtOdense,SlutTidspunktUdflugtOdense,"Traphol Museum, Kolding","foyer",200,K_Hav_og_Himmel);


        // Opretter ledsager

        Ledsager L_Mie_sommer = Controller.createLedsager("Mie Sommer","12345678",T_Peter_sommer);
        Ledsager L_Jan_Madsen = Controller.createLedsager("Jan Madsen","88888888",T_Lone_Jensen);

        // Tilmelder vores ledsager til udflugter
        Controller.AddLedsagerTilUdflugt(T_Peter_sommer,U_Egeskov);
        Controller.AddLedsagerTilUdflugt(T_Peter_sommer,U_Traphold_Museum_Kolding);

        Controller.AddLedsagerTilUdflugt(T_Lone_Jensen,U_Egeskov);
        Controller.AddLedsagerTilUdflugt(T_Lone_Jensen,U_Byrundtur_Odense);


        // Adder hoteller til Konferencer
        Controller.AddHotelTilKonference(H_Den_Hvide_svane,K_Hav_og_Himmel);
        Controller.AddHotelTilKonference(H_Høtel_Phonix,K_Hav_og_Himmel);
        Controller.AddHotelTilKonference(H_Pension_Tusindfryd,K_Hav_og_Himmel);

        // Adder Hoteller til tilmeldinger hvis valgt
        Controller.AddHotelTilTilmeldning(H_Den_Hvide_svane,T_Niels_Petersen);
        Controller.AddHotelTilTilmeldning(H_Den_Hvide_svane,T_Peter_sommer);
        Controller.AddHotelTilTilmeldning(H_Den_Hvide_svane,T_Lone_Jensen);

        //Adder ekstra hvis valgt

        Controller.AddEkstraTilTilmeldning(H_Den_Hvide_svane,T_Peter_sommer,E_WIFI_Den_Hvide_svane);
        Controller.AddEkstraTilTilmeldning(H_Den_Hvide_svane,T_Lone_Jensen,E_WIFI_Den_Hvide_svane);

        //Adder vores metoder

        Controller.getDeltagerMedFuldInfo(D_Finn);
        Controller.getDeltagerMedFuldInfo(D_Lone_Jensen);
        Controller.getDeltagerMedFuldInfo(D_Niels_Petersen);
        Controller.getDeltagerMedFuldInfo(D_Peter_Sommer);

        Controller.getHotelMedDeltagerogledsager(K_Hav_og_Himmel);

        Controller.getdeltagerTilkonferencen(K_Hav_og_Himmel);

        Controller.getUdflugtMedDeltagerOgLedsager(K_Hav_og_Himmel);

        System.out.println("h" + T_Peter_sommer.getEkstras());

        System.out.println(T_Peter_sommer.getEkstras());


    }
}
