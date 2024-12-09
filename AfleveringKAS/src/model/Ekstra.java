package model;

public class Ekstra {

    private double pris;
    private String tilkøb;
    private Hotel hotel;

    Ekstra(String tilkøb, double pris){
        this.tilkøb = tilkøb;
        this.pris = pris;
    }

    public double getPris() {
        return pris;
    }

    public void setTilkøb(String tilkøb) {
        this.tilkøb = tilkøb;
    }

    public String getTilkøb() {
        return tilkøb;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public Hotel getHotel() {
        return hotel;
    }

    @Override
    public String toString() {
        return  "tilkøb='" + getTilkøb();
    }
}
