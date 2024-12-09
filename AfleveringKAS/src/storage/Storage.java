package storage;

import model.*;

import java.util.ArrayList;

public class storage {

    private static ArrayList<Konference> konferenceer = new ArrayList<>();

    private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    private static ArrayList<Hotel> hoteller = new ArrayList<>();

    private static ArrayList<Deltager> deltagerer = new ArrayList<>();

    private static ArrayList<Udflugt> udflugter = new ArrayList<>();

    private static ArrayList<Ekstra> ekstras = new ArrayList<>();

    private static ArrayList<Ledsager> ledsagerer = new ArrayList<>();


    //----------------------------------------------------


    public static ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public static void addTilmeldning(Tilmelding tilmelding) {
        tilmeldinger.add(tilmelding);
    }

    //----------------------------------------------------


    public static ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public static void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    //----------------------------------------------------


    public static ArrayList<Deltager> getDeltagerer() {
        return new ArrayList<>(deltagerer);
    }

    public static void addDeltager(Deltager deltager) {
        deltagerer.add(deltager);
    }

    //----------------------------------------------------


    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public static void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    //----------------------------------------------------

    public static ArrayList<Ekstra> getEkstras() {
        return new ArrayList<>(ekstras);
    }

    public static void addEkstra(Ekstra ekstra) {
        ekstras.add(ekstra);
    }

//----------------------------------------------------

    public static ArrayList<Konference> getKonferenceer() {
        return new ArrayList<>(konferenceer);
    }

    public static void addKonference(Konference konference) {
        konferenceer.add(konference);
    }

    //----------------------------------------------

    public static void addLedsager(Ledsager ledsager) {
        ledsagerer.add(ledsager);
    }
    public static ArrayList<Ledsager> getLedsager(){
        return new ArrayList<>(ledsagerer);
    }


    public static ArrayList<String> getLedsagerer1() {

        ArrayList<String> strings = new ArrayList<>();
        for (Konference konference : konferenceer) {
            for (Tilmelding tilmelding : tilmeldinger) {
                if (tilmelding.getLedsager() != null) {
                    strings.add(tilmelding.getDeltager().getNavn() + tilmelding.getDeltager().getTlfNr() + tilmelding.getLedsager().getNavn() + tilmelding.getLedsager().getTlf());
                }
            }
        }
        return strings;
    }







}


