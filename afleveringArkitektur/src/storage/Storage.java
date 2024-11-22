package storage;


import model.Forestilling;
import model.Kunde;
import model.Plads;

import java.util.ArrayList;

public class Storage {

    //arraylister

    private static ArrayList<Forestilling>forestillings = new ArrayList<>();
    private static ArrayList<Plads>pladser = new ArrayList<>();
    private static ArrayList<Kunde>kundes = new ArrayList<>();

    //add

    public static void addForestilling(Forestilling forestilling){
        if(!forestillings.contains(forestilling)){
            forestillings.add(forestilling);
        }
    }
    public static void addPLads(Plads plads){
        if(!pladser.contains(plads)){
            pladser.add(plads);
        }
    }
    public static void addKunde(Kunde kunde){
        if(!kundes.contains(kunde)){
            kundes.add(kunde);
        }
    }
    //get

    public static ArrayList<Forestilling> getForestillings() {
        return new ArrayList<>(forestillings) ;
    }

    public static ArrayList<Kunde> getKundes() {
        return new ArrayList<>(kundes) ;
    }

    public static ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }
}
