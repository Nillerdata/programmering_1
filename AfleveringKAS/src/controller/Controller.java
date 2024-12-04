package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
}
