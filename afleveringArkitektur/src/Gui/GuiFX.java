package Gui;

import controller.Controller;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;

import java.time.LocalDate;
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
    //arraylister
    private ArrayList<Kunde> kunder = new ArrayList<>();
    private ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private ArrayList<Plads> pladser = new ArrayList<>();
    //listview
    private ListView<Kunde> lvwKunder = new ListView<>();
    private ListView<Forestilling> lvwForestilling = new ListView<>();
    private ListView<Plads> lvwplads = new ListView<>();
    //textfields

    private TextField txfName, txfStartDato, txfSlutDato, txfKundeNavn, txfMobil, txfDato;
    //buttons
    private Button btnForestilling, btnKunde, btnOpretBestilling;

    //----------------------------------------------------------


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);


        //initialisere listviews_____________________________

        forestillinger = Controller.getForestilling();
        kunder = Controller.getKunde();
        pladser = Controller.getPlads();
        lvwForestilling.getItems().setAll(forestillinger);
        lvwKunder.getItems().setAll(kunder);

        lvwplads.getItems().setAll(pladser);
        lvwplads.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);//sørger for at man kan vælge flere
        lvwForestilling.setPrefSize(200, 200);
        lvwKunder.setPrefSize(200, 200);
        lvwplads.setPrefSize(200, 200);


        //indsætte listview__________________________

        pane.add(lvwForestilling, 0, 1, 2, 1);
        pane.add(lvwKunder, 2, 1, 2, 1);
        pane.add(lvwplads, 4, 1, 2, 1);


        //kundeLabels_________________________________

        //TODO indsætte labels

        String[] labelNavne = {"Navn", "Start dato", "Slut dato", "Kunde navn", "Kunde mobil"};

        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger, 0, 0);

        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder, 2, 0);
        for (int i = 2; i < 5; i++) {
            Label label = new Label(labelNavne[i - 2]);
            pane.add(label, 0, i);
        }
        for (int i = 2; i < 4; i++) {
            Label label = new Label(labelNavne[i + 1]);
            pane.add(label, 2, i);

        }
        Label lblPladser = new Label("Pladser");
        pane.add(lblPladser, 4, 0);

        //indsætte textfield

        txfName = new TextField();
        txfStartDato = new TextField();
        txfSlutDato = new TextField();
        txfKundeNavn = new TextField();
        txfMobil = new TextField();
        txfDato = new TextField();

        pane.add(txfName, 1, 2);
        pane.add(txfStartDato, 1, 3);
        pane.add(txfSlutDato, 1, 4);
        pane.add(txfKundeNavn, 3, 2);
        pane.add(txfMobil, 3, 3);
        pane.add(txfDato, 4, 2);

        //buttons____________________________

        btnForestilling = new Button("opret forestilling");
        btnKunde = new Button("opret Kunde");
        btnOpretBestilling = new Button("Opret Bestilling");
        pane.add(btnForestilling, 1, 5);
        pane.add(btnKunde, 3, 4);
        pane.add(btnOpretBestilling, 4, 3);
        //koble button til action
        btnForestilling.setOnAction(Event -> createForestillingAction());
        btnKunde.setOnAction(Event -> createKundeAction());
        btnOpretBestilling.setOnAction(Event -> createBestillingAction());
    }

    //TODO buttonactions--------------------------------
    //create forestillings action

    public void createForestillingAction() {
        String navn = txfName.getText().trim();
        LocalDate startDato = LocalDate.parse(txfStartDato.getText().trim());
        LocalDate slutDato = LocalDate.parse(txfSlutDato.getText().trim());

        if (!navn.isEmpty() && startDato != null && slutDato != null) {
            Forestilling forestilling = Controller.createForestilling(navn, startDato, slutDato);
            forestillinger.add(forestilling);
            lvwForestilling.getItems().setAll(forestillinger);
            txfName.clear();
            txfStartDato.clear();
            txfSlutDato.clear();
        }


    }

    //create kunde action
    public void createKundeAction() {
        String navn = txfKundeNavn.getText().trim();
        String mobil = txfMobil.getText().trim();
        if (!navn.isEmpty() && !mobil.isEmpty()) {
            Kunde kunde = Controller.createKunde(navn, mobil);
            kunder.add(kunde);
            lvwKunder.getItems().setAll(kunder);
            txfKundeNavn.clear();
            txfMobil.clear();
        }
    }

    //create bestilling action
    //TODO opgave 6.3
    public void createBestillingAction() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bestilling");
        Forestilling forestilling = lvwForestilling.getSelectionModel().getSelectedItem();
        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
        ArrayList<Plads> pladser = new ArrayList<>(lvwplads.getSelectionModel().getSelectedItems());
        LocalDate dato = null;
        if (!txfDato.getText().trim().isEmpty()) {
            dato = LocalDate.parse(txfDato.getText().trim());
        }

        Bestilling bestilling = Controller.opretBestillingMedPladser(forestilling, kunde, dato, pladser);
        if (bestilling != null){
            alert.setHeaderText("Bestilling oprettet");
            alert.setContentText("Forestilling: " + forestilling.getNavn() +
                    "\nKunde: " + kunde + "\nDato: " + dato + "\nPladser: ");
            for (Plads plads: pladser){
                alert.setContentText(alert.getContentText() + plads);
            }
        } else {
            alert.setHeaderText("Fejl i oprettelse");
            alert.setContentText("Vælg venligst forestilling, kunde og indtast korrekt dato");
        }
        alert.show();
        txfDato.clear();


        }



}
