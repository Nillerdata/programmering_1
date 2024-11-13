package Gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Forestilling;
import model.Kunde;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class GuiFX extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Forestilling");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    //________________________________
    //TODO feltvariabler
    private ArrayList<Kunde> kunder = new ArrayList<>();
    private ArrayList<Forestilling> forestillinger = new ArrayList<>();
    //listview
    private ListView lvwKunder;
    private ListView lvwForestilling;


    //----------------------------------------------------------


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger, 0, 0);

        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder, 1, 0);

        //initialisere listviews
        forestillinger = Controller.getForestilling();
        kunder = Controller.getKunde();
        lvwForestilling.getItems().setAll(forestillinger);
        lvwKunder.getItems().setAll(kunder);
        lvwForestilling.setPrefSize(200, 200);
        lvwKunder.setPrefSize(200, 200);

        //indsætte listview
        pane.add(lvwForestilling, 0, 1);
        pane.add(lvwKunder, 1, 1);

        //TODO indsætte labels
        //forestillingLabel
        Label lblNavn = new Label("Navn");
        pane.add(lblNavn,0,2);
        Label lblStartDato = new Label("StartDato");
        pane.add(lblStartDato,0,3);
        Label lblSlutDato = new Label("Slut Dato");
        pane.add(lblSlutDato,0,4);


        //kundeLabels
        Label lblKundeNavn = new Label("Kunde navn");
        pane.add(lblKundeNavn,1,2);
        Label lblKundeMobil = new Label("Kunde mobil");
        pane.add(lblKundeMobil,1,3);

    //TODO indsætte textfelter
        //Forestilling textfields

        }

        //indsætte textfield

    }
}
