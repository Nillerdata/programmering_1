package Aplication;

import model.controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Deltager;
import model.Konference;
import model.Tilmelding;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Tilmeldning_Window extends Stage {

    private Tilmelding tilmelding;
    private Label lblError;
    private TextField TxfForedragsHolder, txfStartDato,txfSlutDato;
    private ListView<Konference> konferenceListView = new ListView<>();
    private ListView<Deltager> deltagerListView = new ListView<>();

    public Tilmeldning_Window(String title) {

        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
       // this.tilmelding = Tilmelding;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);


    }
    public void setListViews(ListView<Konference> konferenceListView, ListView<Deltager> deltagerListView) {
        this.konferenceListView = konferenceListView;
        this.deltagerListView = deltagerListView;
    }


    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);



        Label LblStartDato = new Label("StartDato");
        pane.add(LblStartDato,0,1);
        txfStartDato = new TextField();
        pane.add(txfStartDato,0,2);
        txfStartDato.setPromptText("yyyy-mm-dd");


        Label lblSlutDato = new Label("Slutdato");
        pane.add(lblSlutDato,0,3);

        txfSlutDato = new TextField();
        pane.add(txfSlutDato,0,4);
        txfSlutDato.setPromptText("yyyy-mm-dd");

        Label lblForedragsHolder = new Label("ForedragsHolder");
        pane.add(lblForedragsHolder,0,5);
        TxfForedragsHolder = new TextField();
        pane.add(TxfForedragsHolder,0,6);
        TxfForedragsHolder.setPromptText("True or False");




        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 12);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());



        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 0, 12);
        GridPane.setHalignment(btnOpret, HPos.RIGHT);
        btnOpret.setOnAction(event ->okAction(this.deltagerListView.getSelectionModel().getSelectedItem(),konferenceListView.getSelectionModel().getSelectedItem()));

        lblError = new Label();
        pane.add(lblError, 0, 14);
        lblError.setStyle("-fx-text-fill: red");

    }


    private void okAction(Deltager deltager, Konference konference) {
        String input = txfStartDato.getText().trim();
        String input1 = txfSlutDato.getText().trim();
        String Foredrags = TxfForedragsHolder.getText().trim();
        konference = konferenceListView.getSelectionModel().getSelectedItem();
        deltager = deltagerListView.getSelectionModel().getSelectedItem();


        int hours = -1;
        LocalDate startDato = null;
        LocalDate slutDato = null;
        Boolean True = null;

        try {
            startDato = LocalDate.parse(input);
            slutDato = LocalDate.parse(input1);
            True = Boolean.TRUE;
        } catch (DateTimeParseException NullPointerException ) {
            lblError.setText("Fejl i input. Tjek datoformat og afgift.");
            System.out.println("Det virker ikke");
            return;
        }

        Controller.createTilmeldning(startDato, slutDato, True,deltager,konference);


        this.hide();
    }


    private void cancelAction() {
        this.hide();
    }

}
