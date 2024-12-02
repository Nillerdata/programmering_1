package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private boolean foredragsholder;
    //---------------------------------------------
    //TODO linkattributter
    private final ArrayList<Ekstra>ekstras = new ArrayList<>();
    private final ArrayList<Udflugt>udflugter = new ArrayList<>();
    private final ArrayList<Hotel>Hoteller = new ArrayList<>();
    private Hotel hotel;
    private Ledsager ledsager;
    private Deltager deltager;
    //---------------------------------------------
    //constructor
    Tilmelding(LocalDate ankomstDato, LocalDate afrejseDato,boolean foredragsholder,Deltager deltager){
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.foredragsholder = foredragsholder;
        this.setDeltager(deltager);
    }
    //---------------------------------------------
    //gettere


    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }
    //---------------------------------------------
    //settere

    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }
    //---------------------------------------------


    //---------------------------------------------

    public Ledsager createLedsager(String navn, String tlf){
        Ledsager ledsager1 = new Ledsager(navn,tlf,this);
        return ledsager1;
    }




    //---------------------------------------------
    //hjælpemetode til constructor
     void setDeltager(Deltager deltager){
        if(this.deltager != deltager){
            this.deltager = deltager;
            if(deltager != null){
                deltager.addTilmelding(this);
            }
        }
    }

    //--------------------------------------
    //getmetode

    public Ledsager getLedsager() {
        return ledsager;
    }

    //--------------------------------------
    //tilmelding * -- 0..1 Hotel

    //set
    public void setHotel(Hotel hotel){
        if(this.hotel != hotel){
          Hotel gammelHotel = this.hotel;
          if(gammelHotel != null){
              gammelHotel.removeTilmelding(this);
          }
          this.hotel = hotel;
          if(hotel != null){
              hotel.addTilmelding(this);
          }
        }
    }
    //get

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(Hoteller);
    }
    //---------------------------------------------------



    //tilmelding 0..* --> 0..* Ekstra

    //add
    public void addEkstra(Ekstra ekstra){
        if(!ekstras.contains(ekstra)){
            ekstras.add(ekstra);
        }
    }
    //remove
    public void removeEkstra(Ekstra ekstra){
        if(ekstras.remove(ekstra)){
            ekstras.remove(ekstra);
        }
    }
    //get

    public ArrayList<Ekstra> getEkstras() {
        return new ArrayList<>(ekstras);
    }
//-----------------------------------------------
    //Tilmelding 0..* -- 0..* Udflugt

    //add
    public void addUdflugt(Udflugt udflugt){
        if(!udflugter.contains(udflugt)){
            udflugter.add(udflugt);
            udflugt.addTilmelding(this);
        }
    }
    //remove
    public void removeUdflugt(Udflugt udflugt){
        if(!udflugter.contains(udflugt)){
            udflugter.add(udflugt);
            udflugt.removeTilmelding(this);
        }
    }
    //get

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter) ;
    }
    public double getSamletPris(Konference konference, Hotel hotel,Udflugt udflugt, Ekstra ekstra,Tilmelding tilmelding){
        double samletPris = 0.0;
        long antalDage = ChronoUnit.DAYS.between(tilmelding.ankomstDato, tilmelding.afrejseDato);

        double konferencePris = konference.getKonferenceAfgift() * antalDage;
        double hotelEnkeltprisPris = hotel.getEnkeltpris() * antalDage;
        double hotelDobbeltPris = hotel.getDobbeltpris() * antalDage;
        double ekstraPris = 0.0;
        double udflugtPris = 0.0;

        for (Ekstra ekstra1 : ekstras) {
            ekstraPris += ekstra1.getPris() * antalDage;

        }
        for (Udflugt udflugt1 : udflugter) {
            udflugtPris += udflugt1.getPris();
        }
       return samletPris += konferencePris + hotelEnkeltprisPris + hotelDobbeltPris + ekstraPris +
                udflugtPris + ekstraPris + udflugtPris;
    }
}
