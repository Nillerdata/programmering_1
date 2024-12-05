package gui;

import controller.Controller;
import javafx.application.Application;
import model.Konference;

import java.time.LocalDate;

public class GuiApp {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
    }
    private static void initStorage(){

        LocalDate StartDato = LocalDate.of(2024,12,18);
        LocalDate SlutDato = LocalDate.of(2024,12,20);

        LocalDate startDato1 = LocalDate.of(2024,10,10);
        LocalDate slutDato1 = LocalDate.of(2024,10,13);

        LocalDate startDato2 = LocalDate.of(2025,2,13);
        LocalDate slutDato2 = LocalDate.of(2025,2,20);

        Konference MiljøKonference = Controller.createKonference("MiljøKonference","Niels Juels Gade" ,StartDato,SlutDato,"Dejligt miljø konference med alt muligt lækkert",1500);

        Konference AtomKraftVærkKonference = Controller.createKonference("Atomkraft værk konference","Gyvelvænget 9",startDato1,slutDato1,"Alle for atomkraftværk",2000);

        Konference HavMøllerKonference = Controller.createKonference("Havmøller for the win","Hvide sande",startDato2,slutDato2,"Alle for havmøller WUHU!!!!!",3000);


    }
}
