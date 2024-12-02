package model;

public class Ekstra {
    private double pris;
    private String tilkøb;
    //-------------------------------------
    //TODO linkattributter
    private Hotel hotel;
    //------------------------------------
    //constructor
     Ekstra(double pris, String tilkøb) {
        this.pris = pris;
        this.tilkøb = tilkøb;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getTilkøb() {
        return tilkøb;
    }

    public void setTilkøb(String tilkøb) {
        this.tilkøb = tilkøb;
    }


    //TODO linkattributter
    //linkattributter til hotel
    public Hotel getHotel() {
        return hotel;
    }


    //TODO metoder?
}
