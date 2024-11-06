package opg_5;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Kollegie {
    private String navn;
    private String adresse;
    private final ArrayList<Bolig> boligs;

    public Kollegie(String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
        boligs = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    //linkattributter------------
    public void addBolig(Bolig bolig) {
        if (!boligs.contains(bolig)) {
            boligs.add(bolig);
        }
    }

    public void removeBolig(Bolig bolig) {
        if (boligs.contains(bolig)) {
            boligs.remove(bolig);
            bolig.setKollegie(null);
        }
    }

    //opg 5.2
    public int getAntalLejeAftaler() {
        int antalBoliger = 0;
        for (Bolig b : boligs) {
            antalBoliger = b.getLejeaftales().size();
        }
        return antalBoliger;
    }//5.3

    public double gennenmsnitligAntalDage() {
        double sum = 0;
        double bob = 0;
        for (Bolig b : boligs) {

            for (Lejeaftale l : b.getLejeaftales()) {
                if (l.getTilDato() != null) {
                    bob += ChronoUnit.DAYS.between(l.getFraDato(), l.getTilDato());
                    sum++;
                }
            }

        }
        return bob/sum;
    }

}
