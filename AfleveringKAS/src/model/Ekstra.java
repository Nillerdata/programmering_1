package model;

public class Ekstra {
    private double pris;
    private String tilkøb;
    //-------------------------------------
    //TODO linkattributter
    private Hotel hotel;
    //------------------------------------
    //constructor
     Ekstra(double pris, String tilkøb,Hotel hotel) {
        this.pris = pris;
        this.tilkøb = tilkøb;
        this.hotel = hotel;
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

    //--------------------------------------------------
    //tostring metode

    @Override
    public String toString() {
        return "Ekstra{" +
                "pris=" + pris +
                ", tilkøb='" + tilkøb + '\'' +
                '}';
    }


    //TODO metoder?
}
