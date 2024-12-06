package storage;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    //arraylister
    private static ArrayList<Konference>konferencer = new ArrayList<>();
    private static ArrayList<Hotel>hoteller = new ArrayList<>();
    private static ArrayList<Deltager>deltagere = new ArrayList<>();
    private static List<Tilmelding> tilmeldinger = new ArrayList<>();
    private static ArrayList<Udflugt>udflugter = new ArrayList<>();
    public static ArrayList<Ekstra>ekstraArrayList = new ArrayList<>();
    public static ArrayList<Ledsager>ledsagere = new ArrayList<>();
    //---------------------------------------------------------------------------
    // add metoder
    public static void addKonference(Konference konference){
        konferencer.add(konference);
    }
    public static void addHotel(Hotel hotel){
        hoteller.add(hotel);
    }
    public static void addDeltager(Deltager deltager){
        deltagere.add(deltager);
    }
    public static void addTilmelding(Tilmelding tilmelding){
        tilmeldinger.add(tilmelding);
    }
    public static void addUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }
    public static void addEkstra(Ekstra ekstra){
        ekstraArrayList.add(ekstra);
    }
    public static void addLedsager(Ledsager ledsager){
        ledsagere.add(ledsager);
    }


    //---------------------------------------------------------------------------
    // getMetoder
    public static ArrayList<Konference>getKonferencer(){
        return new ArrayList<>(konferencer);
    }
    public static ArrayList<Hotel>getHoteller(){
        return new ArrayList<>(hoteller);
    }
    public static ArrayList<Deltager>getDeltagere(){
        return new ArrayList<>(deltagere);
    }
    public static ArrayList<Tilmelding>getTilmeldinger(){
        return new ArrayList<>(tilmeldinger);
    }
    public static ArrayList<Udflugt>getUdflugter(){
        return new ArrayList<>(udflugter);
    }
    public static ArrayList<Ekstra>getEkstraArrayList(){
        return new ArrayList<>(ekstraArrayList);
    }
    public static ArrayList<Ledsager>getLedsagere(){
        return new ArrayList<>(ledsagere);
    }


}
