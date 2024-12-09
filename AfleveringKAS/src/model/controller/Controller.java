package model.controller;

import model.*;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;


import storage.storage;

public class Controller {

    public static Konference createKonference(String navn, String adresse, LocalDate startDato, LocalDate slutDato, String kortBeskrivelse, int konkurrenceAfgit) {
        Konference konference = new Konference(navn, adresse, startDato, slutDato, kortBeskrivelse, konkurrenceAfgit);
        storage.addKonference(konference);
        return konference;
    }


    public static Deltager createDeltagerMedFirma(String navn, String adresse, String land, String firmanavn, String tlfNr, String firmatlfNr) {
        Deltager deltager = new Deltager(navn, adresse, land, firmanavn, tlfNr, firmatlfNr);
        storage.addDeltager(deltager);
        return deltager;
    }

    public static Deltager createDeltager(String navn, String adresse, String land, String tlfNr) {
        Deltager deltager = new Deltager(navn, adresse, land, tlfNr);
        storage.addDeltager(deltager);
        return deltager;
    }

    public static Tilmelding createTilmeldning(LocalDate ankomstdato, LocalDate afrejseDato, Boolean foredragsHolder, Deltager deltager, Konference konference) {
        Tilmelding tilmelding = konference.createTilmelding(ankomstdato, afrejseDato, foredragsHolder, deltager);
        storage.addTilmeldning(tilmelding);
        return tilmelding;
    }

    public static Udflugt createUdflugt(LocalDate dato, LocalTime startTidspunkt, LocalTime slutTidspunkt, String navn, String mødested, double pris, Konference konference) {
        Udflugt udflugt = konference.createUdflugt(dato, startTidspunkt, slutTidspunkt, navn, mødested, pris);
        storage.addUdflugt(udflugt);
        return udflugt;
    }

    public static Hotel createHotel(String navn, String tlf, String adresse, double enkeltværesle, double doubleværelse) {
        Hotel hotel = new Hotel(navn, tlf, adresse, enkeltværesle, doubleværelse);
        storage.addHotel(hotel);
        return hotel;
    }

    public static Ekstra createEkstra(String service, double pris, Hotel hotel) {
        Ekstra ekstra = hotel.CreateEkstra(service, pris);
        storage.addEkstra(ekstra);
        return ekstra;
    }

    public static void AddHotelTilKonference(Hotel hotel, Konference konference) {
        if (!konference.getHotels().contains(hotel)) {
            konference.addHotel(hotel);
        }
    }

    public static void AddLedsagerTilUdflugt(Tilmelding tilmelding, Udflugt udflugt) {
        if (!udflugt.getTilmeldinger().contains(tilmelding)) {
            udflugt.addTilmelding(tilmelding);
        }
    }

    public static void AddHotelTilTilmeldning(Hotel hotel, Tilmelding tilmelding) {
        if (!hotel.getTilmeldinger().contains(tilmelding)) {
            hotel.AddTilmeldning(tilmelding);
        }
    }

    public static void AddEkstraTilTilmeldning(Hotel hotel, Tilmelding tilmelding, Ekstra ekstra) {
        if (hotel.getEkstras().contains(ekstra)) {
                tilmelding.addEkstra(ekstra);
            }
        }



    //get metoder til dem alle

    public static ArrayList<Konference> getKonference() {
        return new ArrayList<>(storage.getKonferenceer());
    }

    public static ArrayList<Udflugt> getUdflugt() {
        return new ArrayList<>(storage.getUdflugter());
    }

    public static ArrayList<Deltager> getDeltager() {
        return new ArrayList<>(storage.getDeltagerer());
    }

    public static ArrayList<Tilmelding> getTilmelding() {
        return new ArrayList<>(storage.getTilmeldinger());
    }

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(storage.getHoteller());
    }

    public static ArrayList<Ekstra> getEkstra() {
        return new ArrayList<>(storage.getEkstras());
    }

    public static double samletpris(Tilmelding tilmelding) {
        double pris = 0.0;
        pris = tilmelding.getSamletPris();
        return pris;
    }

    //UpdateringsMetoder
    public static void updateKonference(Konference konference, String name, String adresse, LocalDate startDato, LocalDate slutDato, String beskrivelse, int afgift) {
        konference.setAdresse(adresse);
        konference.setStartDato(startDato);
        konference.setSlutDato(slutDato);
        konference.setKortBeskrivelse(beskrivelse);
        konference.setKonkurrenceAfgit(afgift);
    }

    //MULIGVIS ÆNDRINGER HER-------------------------------------------------------------------------------------------

    public static Ledsager createLedsager(String navn, String tlf, Tilmelding tilmelding) {
        Ledsager ledsager = tilmelding.createLedsager(navn, tlf);
        tilmelding.setLedsager(ledsager);
        return ledsager;
    }

    public static ArrayList<Tilmelding> getdeltagerTilkonferencen(Konference konference) {

        ArrayList<Tilmelding> deltager = konference.getTilmeldinger();

        deltager.sort(Comparator.comparing(tilmelding -> tilmelding.getDeltager().getNavn().split(" ")[0]));

        return deltager;
    }

    public static ArrayList<String> getDeltagerTilKonferencen1(Konference konference) {
        // Hent tilmeldinger for konferencen
        ArrayList<Tilmelding> deltager = konference.getTilmeldinger();

        // Sorter tilmeldinger efter deltagernes fornavn
        deltager.sort(Comparator.comparing(tilmelding -> tilmelding.getDeltager().getNavn().split(" ")[0]));

        // Konverter til en ArrayList<String>
        ArrayList<String> deltagerInfo = new ArrayList<>();
        for (Tilmelding tilmelding : deltager) {
            if (tilmelding.getForedragsHolder() == true) {
                Deltager deltagerObjekt = tilmelding.getDeltager();
                String deltagerString = "Navn " + deltagerObjekt.getNavn() +
                        " TlfNr " + deltagerObjekt.getTlfNr() +
                        " Ankomstdato " + tilmelding.getAnkomstdato() +
                        " Afrejsedato " + tilmelding.getAfrejseDato() +
                        "Foredragsholder" + "Ledsager = "+ tilmelding.getLedsager();
                deltagerInfo.add(deltagerString);
            } else {
                Deltager deltagerObjekt = tilmelding.getDeltager();
                String deltagerString = "Navn " + deltagerObjekt.getNavn() +
                        " TlfNr " + deltagerObjekt.getTlfNr() +
                        " Ankomstdato " + tilmelding.getAnkomstdato() +
                        " Afrejsedato " + tilmelding.getAfrejseDato() +
                        "Ledssger = " + tilmelding.getLedsager();
                        deltagerInfo.add(deltagerString);
            } if(tilmelding.getLedsager() == null && tilmelding.getForedragsHolder() == null){
                Deltager deltagerObjekt = tilmelding.getDeltager();
                String deltagerString = "Navn " + deltagerObjekt.getNavn() +
                        " TlfNr " + deltagerObjekt.getTlfNr() +
                        " Ankomstdato " + tilmelding.getAnkomstdato() +
                        " Afrejsedato " + tilmelding.getAfrejseDato();
                deltagerInfo.add(deltagerString);
            }
        }
        return deltagerInfo;
    }

    public static ArrayList<String> getUdflugtMedDeltagerOgLedsager(Konference konference) {

        ArrayList<String> Result = new ArrayList<>();

        ArrayList<Udflugt> udflugter = konference.getUdflugter();

        for (Udflugt udflugt : udflugter) {

            Result.add("\n Navn " + udflugt.getNavn());
            ArrayList<Tilmelding> tilmeldinger = udflugt.getTilmeldinger();

            for (Tilmelding tilmelding : tilmeldinger) {

                Ledsager ledsager = tilmelding.getLedsager();
                Result.add(" Navn " + ledsager.getNavn() + "TlfNr" + ledsager.getTlf());

                Deltager deltager = tilmelding.getDeltager();
                Result.add(" Navn " + deltager.getNavn() + " tlfNr " + deltager.getTlfNr() + ")");
            }
        }
        saveToFile(Result, "Udflugter med tilhørende infor om deltager og ledsager");
        return Result;
    }

    public static ArrayList<String> getHotelMedDeltagerogledsager(Konference konference) {

        ArrayList<String> Result = new ArrayList<>();

        ArrayList<Hotel> hoteller = konference.getHotels();

        for (Hotel hotel : hoteller) {

            Result.add("\n Navn " + hotel.getNavn());

            ArrayList<Tilmelding> tilmeldinger = hotel.getTilmeldinger();

            for (Tilmelding tilmelding : tilmeldinger) {

                if (tilmelding.getLedsager() != null) {
                    Result.add("Navn" + tilmelding.getDeltager().getNavn() + " AnkomstDato " + tilmelding.getAnkomstdato() + " AfrejseDato " + tilmelding.getAfrejseDato() + " ledsager " + tilmelding.getLedsager().getNavn() + " Ekstra service " + tilmelding.getEkstras() + "Dobbelt værelse ");
                } else {
                    Result.add("Navn" + tilmelding.getDeltager().getNavn() + " AnkomstDato " + tilmelding.getAnkomstdato() + " AfrejseDato " + tilmelding.getAfrejseDato() + " Ekstra service " + tilmelding.getEkstras() + " Enkelt værelse");
                }
            }
        }
        saveToFile(Result, "Tilmeldninger til hotel og nødvendige info");
        return Result;
    }

    public static ArrayList<String> getDeltagerMedFuldInfo(Deltager deltager) {

        ArrayList<String> result = new ArrayList<>();

        ArrayList<Tilmelding> tilmeldinger = deltager.getTilmeldinger();

        for (Tilmelding tilmelding : tilmeldinger) {
            if(tilmelding.getLedsager() != null && tilmelding.getForedragsHolder() == false) {
                result.add("Navn på tilmeldning " + tilmelding.getDeltager().getNavn() + "Navn på Konferencen " + tilmelding.getKonference().getNavn() + "Navn på ledsager " + tilmelding.getLedsager().getNavn() + "Hotel = " + tilmelding.getHotel().GetHotelINfo() + " Prisen for deltagelse " + tilmelding.getSamletPris());
            } else if(tilmelding.getHotel() != null && tilmelding.getForedragsHolder() == false){
                result.add(tilmelding.getDeltager().getNavn() + " Konferencen " + tilmelding.getKonference().getNavn() + "Hotel = " + tilmelding.getHotel().GetHotelINfo() + " Prisen for deltagelse " + tilmelding.getSamletPris());
            } else if(tilmelding.getForedragsHolder() == true){
                result.add("Navn på tilmeldning " + tilmelding.getDeltager().getNavn() + "Navn på Konferencen " + tilmelding.getKonference().getNavn() + " Foredrags holder true " + " Prisen for deltagelse " + tilmelding.getSamletPris());
            } else {
                result.add("Navn på tilmeldning " + tilmelding.getDeltager().getNavn() + "Navn på Konferencen " + tilmelding.getKonference().getNavn() + " Prisen for deltagelse " + tilmelding.getSamletPris());
            }
        }
        saveToFile(result, "Deltager med Fuld info");
        return result;
    }

    public static void saveToFile(ArrayList<String> data, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (String Line : data) {
                writer.println(Line);
            }
            System.out.println("Skulle gerne være gemt i en fil");
        } catch (IOException e) {
            System.out.println("Der sker en fejl " + e.getMessage());
        }
    }


    @Override
    public String toString() {
        return "controller{}";
    }
}
