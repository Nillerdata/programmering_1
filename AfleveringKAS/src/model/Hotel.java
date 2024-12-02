package model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private String tlf;
    private String adresse;
    private double enkeltpris;
    private double dobbeltpris;
    private  ArrayList<Ekstra>ekstraArrayList = new ArrayList<>();
    //TODO linkattributter
    private final ArrayList<Tilmelding>tilmeldinger = new ArrayList<>();
    private final ArrayList<Konference>konferencer = new ArrayList<>();
    private Ekstra ekstra;

    public Hotel(String navn, String tlf, String adresse, double enkeltpris, double dobbeltpris) {
        this.navn = navn;
        this.tlf = tlf;
        this.adresse = adresse;
        this.enkeltpris = enkeltpris;
        this.dobbeltpris = dobbeltpris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getEnkeltpris() {
        return enkeltpris;
    }

    public void setEnkeltpris(double enkeltpris) {
        this.enkeltpris = enkeltpris;
    }

    public double getDobbeltpris() {
        return dobbeltpris;
    }

    public void setDobbeltpris(double dobbeltpris) {
        this.dobbeltpris = dobbeltpris;
    }
    //------------------------------------------------
    //TODO linkattributter
    //link attributter til ekstra
    public Ekstra createEkstra(double pris, String tilkøb){
        Ekstra ekstra = new Ekstra(pris,tilkøb);
        ekstraArrayList.add(ekstra);
        return ekstra;
    }
    //get metode til ekstraarraylist
    public ArrayList<Ekstra> getEkstraArrayList() {
        return new ArrayList<>(ekstraArrayList);
    }
    //---------------------------



    //----------------------------------------------------
    // Hotel 0..* aggregering - 0..* konference
    //add
    public void addKonference(Konference konference){
        if(!konferencer.contains(konference)){
            konferencer.add(konference);
            konference.addhotel(this);
        }
    }
    //remove
    public void removeKonference(Konference konference){
        if(konferencer.contains(konference)){
            konferencer.add(konference);
            konference.removeHotel(this);
        }
    }
    //get

    public ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    //------------------------------
    //hotel 0..1 -- *Tilmelding

    //add
    public void addTilmelding(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
            tilmelding.setHotel(this);
        }

    }
    //remove
    public void removeTilmelding(Tilmelding tilmelding){
    if(tilmeldinger.contains(tilmelding)){
        tilmeldinger.remove(tilmelding);
        tilmelding.setHotel(null);
    }
    }
    //get
    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }


    //--------------------------------------------
    //TODO get metoder


}
