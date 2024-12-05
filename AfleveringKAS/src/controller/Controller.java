package controller;

import model.*;
import storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {


    //create metoder
    public static Konference createKonference(String navn, String adresse, LocalDate startDato, LocalDate slutDato,
                                              String kortBeskrivelse, double konferenceAfgift) {
        Konference konference = new Konference(navn, adresse, startDato, slutDato, kortBeskrivelse, konferenceAfgift);
        Storage.addKonference(konference);
        return konference;
    }

    public static Hotel createHotel(String navn, String tlf, String adresse, double enkeltpris, double dobbeltpris) {
        Hotel hotel = new Hotel(navn, tlf, adresse, enkeltpris, dobbeltpris);
        Storage.addHotel(hotel);
        return hotel;
    }

    //to deltager metoder til med og uden firma
    public static Deltager createDeltager(String navn, String adresse, String byOgLand, String firmaNavn, String tlfnr, String firmaTlf) {
        Deltager deltager = new Deltager(navn, adresse, byOgLand, firmaNavn, tlfnr, firmaTlf);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static Deltager createDeltager(String navn, String adresse, String byOgLand, String tlfnr) {
        Deltager deltager = new Deltager(navn, adresse, byOgLand, tlfnr);
        Storage.addDeltager(deltager);
        return deltager;
    }

    //------------------------------------------------------------------------
    public static Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder, Konference konference, Deltager deltager) {
        Tilmelding tilmelding = konference.createTilmelding(ankomstDato, afrejseDato, foredragsholder, deltager);
        Storage.addTilmelding(tilmelding);
        return tilmelding;
    }

    public static Udflugt createUdflugt(LocalDate dato, LocalTime startTidspunkt, LocalTime slutTidspunkt,
                                        String navn, String mødested, double pris, Konference konference) {
        Udflugt udflugt = konference.createUdflugt(dato, startTidspunkt, slutTidspunkt, navn, mødested, pris);
        Storage.addUdflugt(udflugt);
        return udflugt;
    }

    public static Ekstra createEkstra(double pris, String tilkøb, Hotel hotel) {
        Ekstra ekstra = hotel.createEkstra(pris, tilkøb);
        Storage.addEkstra(ekstra);
        return ekstra;
    }

    public static Ledsager createLedsager(String navn, String tlf, Tilmelding tilmelding) {
        Ledsager ledsager = tilmelding.createLedsager(navn, tlf);
        Storage.addLedsager(ledsager);
        return ledsager;
    }

    //------------------------------------------------------------------------
    //getmetoder
    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteller();
    }

    public static ArrayList<Deltager> getDeltagere() {
        return Storage.getDeltagere();
    }

    public static ArrayList<Tilmelding> getTilmeldinger() {
        return Storage.getTilmeldinger();
    }

    public static ArrayList<Udflugt> getUdflugt() {
        return Storage.getUdflugter();
    }

    public static ArrayList<Ekstra> getEkstra() {
        return Storage.getEkstraArrayList();
    }

    public static ArrayList<Ledsager> getLedsagere() {
        return Storage.getLedsagere();
    }

    //------------------------------------------------
    public static ArrayList<String> printDeltagereOgLedsagere(Konference konference) {
        ArrayList<String>leverer = new ArrayList<>();
        for (Tilmelding t : getTilmeldinger()) {
            if (t.getLedsager() != null) {
                leverer.add("Deltagernavn" + t.getDeltager().getNavn() + " Ledsager " + t.getLedsager().getNavn());

            }
        }
        return leverer;
    }

    //------------------------------------------------------------------------------------
    public static void addHotelTilKonference(Konference konference, Hotel hotel) {

        if (!konference.getHoteller().contains(hotel)) {
            konference.addhotel(hotel);
        }
    }
    public static void addTilmeldingTilUdflugt(Udflugt udflugt,Tilmelding tilmelding){
        if(!udflugt.getTilmeldinger().contains(tilmelding)){
            udflugt.addTilmelding(tilmelding);
        }
    }
    public static void addTilmeldingTilHotel(Hotel hotel,Tilmelding tilmelding){
        if(!hotel.getTilmeldinger().contains(tilmelding)){
            hotel.addTilmelding(tilmelding);
        }
    }
    public static void addEkstraTilTilmelding(Hotel hotel, Tilmelding Tilmelding,Ekstra ekstra) {
        if ( hotel.getEkstraArrayList().contains(ekstra)) {
            Tilmelding.addEkstra(ekstra);
        }
    }


    //------------------------------------------------------------------------------------
    //
    public static ArrayList<Tilmelding> getdeltagerTilkonferencen(Konference konference) {

        ArrayList<Tilmelding> deltager = konference.getTilmeldinger();

        ArraylistinsertioneSort(deltager);

        return deltager;
    }
    //-------------------------------------------------------------------------------------
    //sorteringsalgoritme
    public static void ArraylistinsertioneSort(ArrayList<Tilmelding> list) {
        for (int i = 1; i < list.size(); i++) {

            Tilmelding next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.getDeltager().getNavn().compareTo(list.get(j-1).getDeltager().getNavn())>=0) {
                    found = true;
                } else {

                    list.set(j,list.get(j-1));
                    j--;
                }
            }
            list.set(j,next);
        }
    }

//-------------------------------------------------------------------------------
public static ArrayList<String> getUdflugtMedDeltagerOgLedsager(Konference konference) {


    ArrayList<String> Result = new ArrayList<>();

    ArrayList<Udflugt> udflugter = konference.getUdflugter();

    for (Udflugt udflugt : udflugter) {

        Result.add("Navn " + udflugt.getNavn());
        ArrayList<Tilmelding> tilmeldinger = udflugt.getTilmeldinger();

        for (Tilmelding tilmelding : tilmeldinger) {

            Ledsager ledsager = tilmelding.getLedsager();
            Result.add("\n Navn " + ledsager.getNavn() + "TlfNr" + ledsager.getTlf());

            Deltager deltager = tilmelding.getDeltager();
            Result.add("\n (Navn" + deltager.getNavn() + " tlfNr " + deltager.getTlfnr() + ")");
        }
    }

    return Result;
}


//------------------------------------------------------------------------------------------
public static ArrayList<String> getHotelMedDeltagerogledsager(Konference konference) {

    ArrayList<String> Result = new ArrayList<>();

    ArrayList<Hotel> hoteller = konference.getHoteller();

    for (Hotel hotel : hoteller) {

        Result.add("Navn " + hotel.getNavn());

        ArrayList<Tilmelding> tilmeldinger = hotel.getTilmeldinger();

        for (Tilmelding tilmelding : tilmeldinger) {

            if (tilmelding.getLedsager() != null) {
                Result.add("\n navn " + tilmelding.getDeltager().getNavn() + " AnkomstDato " + tilmelding.getAnkomstDato() + " AfrejseDato " + tilmelding.getAfrejseDato() + " ledsager " + tilmelding.getLedsager().getNavn() + " Ekstra service " + tilmelding.getEkstras() + "Dobbelt værelse ");
            } else {
                Result.add("\n Navn" + tilmelding.getDeltager().getNavn() + " AnkomstDato " + tilmelding.getAnkomstDato() + " AfrejseDato " + tilmelding.getAfrejseDato() + " Ekstra service " + tilmelding.getEkstras() + " Enkelt værelse");
            }
        }
    }
    return Result;
}
//--------------------------------------------------------------------------------------------------
    public static ArrayList<String> getDeltagerMedFuldInfo(Deltager deltager) {

        ArrayList<String> result = new ArrayList<>();

        ArrayList<Tilmelding> tilmeldinger = deltager.getTilmeldinger();

        for (Tilmelding tilmelding : tilmeldinger) {
            result.add("Navn på Konferencen " + tilmelding.getKonference().getNavn() + " Prisen for deltagelse " + tilmelding.getSamletPris());

        }
        return result;

    }
//-------------------------------------------------------------------------------------------------------
public static void Tofile(ArrayList<String>data,String fileName){

    try(Scanner scan = new Scanner(System.in);PrintWriter printWriter = new PrintWriter(fileName)){
        printWriter.println(data);

        System.out.println("fil er scannet");
    }catch (IOException e){
        System.out.println(e.getMessage());
    }
}

//------------------------------------------------------------------------------------------------------
//samlet pris metode
    public static double samletpris(Tilmelding tilmelding){
        double pris = 0.0;
        pris = tilmelding.getSamletPris();
        return pris;
    }
//---------------------------------------------------------------------------------------------------------


}
