package model;

import java.util.ArrayList;

public class Hotel {

    private String navn;
    private String tlf;
    private String adresse;
    private double enkeltværesle;
    private double doubleværelse;
    private ArrayList<Konference> konferences = new ArrayList<>();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private ArrayList<Ekstra> ekstras = new ArrayList<>();

    public Hotel(String navn, String tlf, String adresse, double enkeltværesle, double doubleværelse) {
        this.navn = navn;
        this.tlf = tlf;
        this.adresse = adresse;
        this.enkeltværesle = enkeltværesle;
        this.doubleværelse = doubleværelse;
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

    public double getEnkeltværeslePris() {
        return enkeltværesle;
    }

    public void setEnkeltværesle(double enkeltværesle) {
        this.enkeltværesle = enkeltværesle;
    }

    public double getDoubleværelsePris() {
        return doubleværelse;
    }

    public void setDoubleværelse(double doubleværelse) {
        this.doubleværelse = doubleværelse;
    }


    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public Ekstra CreateEkstra(String tilkøb,double pris){
        Ekstra ekstra1 = new Ekstra(tilkøb,pris);
        ekstras.add(ekstra1);
        return ekstra1;
    }

    public ArrayList<Ekstra> getEkstras() {
        return new ArrayList<>(ekstras);
    }



    public ArrayList<Konference> getKonferences() {
        return new ArrayList<>(konferences);
    }


    public void addkonference(Konference konference){
        if(!konferences.contains(konference)){
            konferences.add(konference);
            konference.addHotel(this);

        }
    }
    public void removeKonference(Konference konference){
        if(konferences.contains(konference)){
            konferences.remove(konference);
            konference.removeHotel(this);
        }
    }

    public void AddTilmeldning(Tilmelding tilmelding){
        if(!tilmeldinger.contains(tilmelding)){
            tilmeldinger.add(tilmelding);
            tilmelding.setHotel(this);
        }
    }
    public void removeTilmelding(Tilmelding tilmelding){
        if(tilmeldinger.contains(tilmelding)){
            tilmeldinger.remove(tilmelding);
            tilmelding.setHotel(null);
        }
    }

    public String GetHotelINfo(){
        return getNavn() + " Adresse " + getAdresse();

    }

    @Override
    public String toString() {
        return "Hotel{" +
                "adresse='" + adresse + '\'' +
                ", navn='" + navn + '\'' +
                ", tlf='" + tlf + '\'' +
                ", tilmeldinger=" + tilmeldinger +

                '}';
    }
}
