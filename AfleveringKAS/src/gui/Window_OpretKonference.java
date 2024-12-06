package gui;


import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Window_OpretKonference extends Stage {

    private Konference konference;

    public Window_OpretKonference(String title) {

        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);



        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private TextField txfName, txfadresse, txfStartDato, txfSlutDato, txfbeskrivelse, txfAfgift;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);


        Label lblAdresse = new Label("Adresse");
        pane.add(lblAdresse, 0, 2);

        txfadresse = new TextField();
        pane.add(txfadresse, 0, 3);


        Label LblStartDato = new Label("StartDato");
        pane.add(LblStartDato,0,4);

        txfStartDato = new TextField();
        pane.add(txfStartDato,0,5);


        Label lblSlutDato = new Label("Slutdato");
        pane.add(lblSlutDato,0,6);

        txfSlutDato = new TextField();
        pane.add(txfSlutDato,0,7);


        Label lblBeskrivelse = new Label("Beskrivelse");
        pane.add(lblBeskrivelse,0,8);

        txfbeskrivelse = new TextField();
        pane.add(txfbeskrivelse,0,9);


        Label lblKonferenceAgift = new Label("Konference afgift");
        pane.add(lblKonferenceAgift,0,10);

        txfAfgift = new TextField();
        pane.add(txfAfgift,0,11);


        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 12);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 0, 12);
        GridPane.setHalignment(btnOpret, HPos.RIGHT);
        btnOpret.setOnAction(event -> this.okAction());

        lblError = new Label();
        pane.add(lblError, 0, 14);
        lblError.setStyle("-fx-text-fill: red");
    }

    private void okAction() {
        String name = txfName.getText().trim();
        String adresse = txfadresse.getText().trim();
        String beskrivelse = txfbeskrivelse.getText().trim();
        String input = txfStartDato.getText().trim();
        String input1 = txfSlutDato.getText().trim();

        if (name.isEmpty()) {
            lblError.setText("Navn er tomt.");
            return;
        }

        int hours = -1;
        LocalDate startDato = null;
        LocalDate slutDato = null;

        try {
            startDato = LocalDate.parse(input);
            slutDato = LocalDate.parse(input1);
            hours = Integer.parseInt(txfAfgift.getText().trim());
        } catch (DateTimeParseException e) {
            lblError.setText("Fejl i input. Tjek datoformat og afgift.");
            return;
        }

        if (hours < 0) {
            lblError.setText("Er det gratis at deltage?");
            return;
        }

            Controller.createKonference(name, adresse, startDato, slutDato, beskrivelse, hours);
          //  controller.updateKonference(konference,name,adresse, startDato, slutDato, beskrivelse, hours);



        this.hide();
    }

    private void cancelAction() {
        this.hide();
    }

    private void resetErrorStyles() {
        txfStartDato.getStyleClass().remove("text-field-error");
        txfSlutDato.getStyleClass().remove("text-field-error");
        txfAfgift.getStyleClass().remove("text-field-error");
    }

    private boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}


