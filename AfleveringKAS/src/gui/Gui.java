package gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

public class Gui extends Application {

    private TextField txfKonfernce, txfDeltager, txfUdflugter;

    private Button BtnCreateUdflugt, BtnCreateKonfernce, BtnCreateLedsager;

    private final ListView <Konference> konferenceListView = new ListView();
    private final ListView <Udflugt> udflugtListView = new ListView<>();
    private final ListView <Hotel> hotelListView = new ListView<>();
    private final ListView <Deltager> deltagerListView = new ListView<>();
    private final ListView <Ledsager> ledsagerListView = new ListView<>();

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
        pane.add(konferenceListView,0, 1, 2, 5);

        //Opretter vores Buttons
        BtnCreateKonfernce = new Button("Opret Konference");
        pane.add(BtnCreateKonfernce,1,8);

        BtnCreateLedsager = new Button("Opret Udflugt");

        // Laver vores ListViwes

        List<Konference> storageForestilling = Storage.getKonferencer();

        ObservableList<Konference> konferenceObservableList = FXCollections.observableArrayList(storageForestilling);

        //initalisere vores Listwievs

        konferenceListView.setItems(konferenceObservableList);


    }
}

