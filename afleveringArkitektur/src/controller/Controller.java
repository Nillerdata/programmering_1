package controller;

import model.Forestilling;
import model.Kunde;
import model.Plads;
import model.PladsType;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    //TODO createMetoder______________
    public static Forestilling createForestilling(String navn, LocalDate startDato, LocalDate slutDato){
        Forestilling forestilling = new Forestilling(navn,startDato,slutDato);
        Storage.addForestilling(forestilling);
        return forestilling;
    }
    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType){
        Plads plads = new Plads(række,nr,pris,pladsType);
        Storage.addPLads(plads);
        return plads;
    }
    public static Kunde createKunde(String navn, String mobil){
        Kunde kunde = new Kunde(navn,mobil);
        Storage.addKunde(kunde);
        return kunde;
        }

        //TODO getMetoder________________________
    public static ArrayList<Plads>getPlads(){
        return Storage.getPladser();
    }
    public static ArrayList<Forestilling>getForestilling(){
        return Storage.getForestillings();
    }
    public static ArrayList<Kunde>getKunde(){
        return Storage.getKundes();
    }

}
