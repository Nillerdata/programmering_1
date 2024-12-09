package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {

    private LocalDate Ankomstdato;
    private LocalDate AfrejseDato;
    private Boolean foredragsHolder;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private Deltager deltager;
    private Hotel hotel;
    private Konference konference;
    private ArrayList<Ekstra> ekstras = new ArrayList<>();
    private Ledsager ledsager;

    Tilmelding(LocalDate ankomstdato, LocalDate afrejseDato, Boolean foredragsHolder, Deltager deltager, Konference konference) {
        Ankomstdato = ankomstdato;
        AfrejseDato = afrejseDato;
        this.foredragsHolder = foredragsHolder;
        this.setDeltager(deltager);
        this.konference = konference;
    }

    public LocalDate getAnkomstdato() {
        return Ankomstdato;
    }

    public Konference getKonference() {
        return konference;
    }

    public LocalDate getAfrejseDato() {
        return AfrejseDato;
    }

    public Boolean getForedragsHolder() {
        return foredragsHolder;
    }

    public void setAfrejseDato(LocalDate afrejseDato) {
        AfrejseDato = afrejseDato;
    }

    public void setForedragsHolder(Boolean foredragsHolder) {
        this.foredragsHolder = foredragsHolder;
    }

    public void setAnkomstdato(LocalDate ankomstdato) {
        Ankomstdato = ankomstdato;
    }

    public Ledsager createLedsager(String navn, String tlf) {
        ledsager = new Ledsager(navn, tlf, this);
        return ledsager;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    void setDeltager(Deltager deltager) {
        if (this.deltager != deltager) {
            this.deltager = deltager;
            if (deltager != null) {
                deltager.addTilmelding(this);
            }
        }
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public void setHotel(Hotel hotel) {
        if (this.hotel != hotel) {
            Hotel oldhotel = this.hotel;
            if (oldhotel != null) {
                oldhotel.removeTilmelding(this);
            }
            this.hotel = hotel;
            if (hotel != null) {
                hotel.AddTilmeldning(this);
            }

        }
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Ekstra> getEkstras() {
        return new ArrayList<>(ekstras);
    }

    public void addEkstra(Ekstra ekstra) {
        if (!ekstras.contains(ekstra)) {
            ekstras.add(ekstra);
        }
    }

    public void removeEkstra(Ekstra ekstra) {
        if (ekstras.contains(ekstra)) {
            ekstras.remove(ekstra);
        }
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public void addUdflugt(Udflugt udflugt) {
        if (!udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
            udflugt.addTilmelding(this);
        }
    }

    public void removeUdflugt(Udflugt udflugt) {
        if (udflugter.contains(udflugt)) {
            udflugter.remove(udflugt);
            udflugt.removeTilmeldning(this);
        }
    }

    public double getSamletPris() {

        long antaldage = ChronoUnit.DAYS.between(this.getAnkomstdato(), this.getAfrejseDato()) + 1;
        long antalnætter = ChronoUnit.DAYS.between(this.getAnkomstdato(), this.getAfrejseDato());
        double samletPris = 0;

        if(!udflugter.isEmpty()) {
            for (Udflugt udflugt1 : udflugter) {
                samletPris += udflugt1.getPris();
            }
        }
        if (hotel != null) {
            for (Ekstra ekstra1 : ekstras) {
                samletPris += ekstra1.getPris() * antalnætter;
            }
            if (ledsager != null) {
                samletPris += hotel.getDoubleværelsePris() * antalnætter;
            } else {
               samletPris += hotel.getEnkeltværeslePris() * antalnætter;
            }
        }
        if(foredragsHolder == false || deltager.getFirmanavn() != null) {
            samletPris += konference.getKonkurrenceAfgit() * antaldage;
        }
        return samletPris;
    }


    @Override
    public String toString() {
        return "Tilmelding{" +
                "deltager=" + deltager.getNavn() + ": TlfNr " + deltager.getTlfNr();
    }
}





