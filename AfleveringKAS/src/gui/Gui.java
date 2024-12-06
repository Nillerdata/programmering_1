package gui;


import controller.Controller;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.*;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Konference;
import model.Tilmelding;
import storage.Storage;

import java.util.List;

public class GUI extends Application {


    private TextField hek;

    private Button BtnCreateUdflugt, BtnCreateKonfernce, BtnCreateLedsager, btnCreateDeltager, btnCreatetilmelding;

    private final ListView<Konference> konferenceListView = new ListView();
    private final ListView<Udflugt> udflugtListView = new ListView<>();
    private final ListView<Hotel> hotelListView = new ListView<>();
    private final ListView<Deltager> deltagerListView = new ListView<>();
    private final ListView<Ledsager> ledsagerListView = new ListView<>();

    public void start(Stage stage) {
        stage.setTitle("KAS - Systemet");
        GridPane pane = new GridPane();
        this.initializeContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        stage.setMinWidth(0);
    }

    private void initializeContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(15));
        pane.setHgap(15);
        pane.setVgap(15);

        //Opretter vores listViews
        pane.add(konferenceListView, 0, 1, 2, 5);

        pane.add(deltagerListView,10,1,2,5);

        //Opretter vores Buttons og kobler buttons op
        BtnCreateKonfernce = new Button("Opret Konference");
        pane.add(BtnCreateKonfernce, 1, 8);
        BtnCreateKonfernce.setOnAction(event -> createOpretKonference());

        BtnCreateLedsager = new Button("Opret Ledsager");
        pane.add(BtnCreateLedsager,4,2);

        BtnCreateUdflugt = new Button("Opret udflugt");
        pane.add(BtnCreateUdflugt,5,2);

        btnCreateDeltager = new Button("Opret deltager");
        pane.add(btnCreateDeltager,6,2);

        btnCreatetilmelding = new Button("Opret Tilmeldning");
        pane.add(btnCreatetilmelding,7,2);


        // Laver vores ListViwes

        List<Konference> storageForestilling = Storage.getKonferencer();

        ObservableList<Konference> konferenceObservableList = FXCollections.observableArrayList(storageForestilling);
        //-----------------------------------------------------------------


        List<Deltager> storageDeltager = Storage.getDeltagere();

        ObservableList<Deltager> deltagerObservableList = FXCollections.observableArrayList(storageDeltager);

        //initalisere vores Listwievs

        konferenceListView.setItems(konferenceObservableList);

        deltagerListView.setItems(deltagerObservableList);


    }


    private void createOpretKonference() {
        Window_OpretKonference dia = new Window_OpretKonference("Opret Konference");
        dia.showAndWait();

        // Wait for the modal dialog to close

        konferenceListView.getItems().setAll(Controller.getKonferencer());
        int index = konferenceListView.getItems().size() - 1;
        konferenceListView.getSelectionModel().select(index);
    }

}

