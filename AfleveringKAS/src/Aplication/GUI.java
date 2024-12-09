package Aplication;

import model.controller.Controller;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.*;
import model.Konference;
import model.Tilmelding;
import storage.storage;

import java.util.ArrayList;
import java.util.List;

import static model.controller.Controller.getKonference;
import static model.controller.Controller.getTilmelding;

public class GUI extends Application {


    private Button BtnCreateUdflugt, BtnCreateKonfernce, BtnCreateLedsager, btnCreateDeltager, btnCreatetilmelding;
    private Label LblUdlfugter, LblTilmeldninger, LblHotelMedInfo, LblDeltagerMedFulInfo, lblKonference;

    private final ListView<Konference> konferenceListView = new ListView();
    private final ListView<Udflugt> udflugtListView = new ListView<>();
    private final ListView<Hotel> hotelListView = new ListView<>();
    private final ListView<Deltager> deltagerListView = new ListView<>();
    private final ListView<Ledsager> ledsagerListView = new ListView<>();
    private final ListView<Tilmelding> tilmeldingListView = new ListView<>();
    private ListView<String> UdflugtMedLedsagerOgdeltager = new ListView<>();
    private TextArea TxaUdflugtermedInfo, TxaHotelMedInfo, txaTilmeldning, txaDeltagerMedInfo;


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

        TxaUdflugtermedInfo = new TextArea();
        pane.add(TxaUdflugtermedInfo, 2, 1);
        TxaUdflugtermedInfo.setEditable(false);
        TxaUdflugtermedInfo.setPrefWidth(200);

        TxaHotelMedInfo = new TextArea();
        pane.add(TxaHotelMedInfo, 3, 1);
        TxaHotelMedInfo.setEditable(false);
        TxaHotelMedInfo.setPrefWidth(200);

        txaTilmeldning = new TextArea();
        pane.add(txaTilmeldning, 4, 1);
        txaTilmeldning.setEditable(false);
        txaTilmeldning.setPrefWidth(200);

        txaDeltagerMedInfo = new TextArea();
        pane.add(txaDeltagerMedInfo, 5, 1);
        txaDeltagerMedInfo.setEditable(false);
        txaDeltagerMedInfo.setPrefWidth(200);

        deltagerListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            if (newSelection != null) {
                ArrayList<String> DeltagerInfo = Controller.getDeltagerMedFuldInfo(newSelection);
                // Konverter ArrayList til én streng og opdater TextArea
                StringBuilder tekst = new StringBuilder();
                for (String linje : DeltagerInfo) {
                    tekst.append(linje).append("\n");
                }
                txaDeltagerMedInfo.setText(tekst.toString());

            }
        });
        konferenceListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            if (newSelection != null) {
                // Hent udflugtsoplysninger for den valgte konference
                ArrayList<String> udflugtInfo = Controller.getUdflugtMedDeltagerOgLedsager(newSelection);
                ArrayList<String> HotelInfor = Controller.getHotelMedDeltagerogledsager(newSelection);
                ArrayList<String> TilmeldningInfo = Controller.getDeltagerTilKonferencen1(newSelection);

                // Konverter ArrayList til én streng og opdater TextArea
                StringBuilder tekst = new StringBuilder();
                for (String linje : udflugtInfo) {
                    tekst.append(linje).append("\n");
                }
                TxaUdflugtermedInfo.setText(tekst.toString());

                StringBuilder tekst1 = new StringBuilder();
                for (String linje : HotelInfor) {
                    tekst1.append(linje).append("\n");
                }
                TxaHotelMedInfo.setText(tekst1.toString());

                StringBuilder tekst2 = new StringBuilder();
                for (String linje : TilmeldningInfo) {
                    tekst2.append(linje).append("\n");
                }
                txaTilmeldning.setText(tekst2.toString());


            }
        });


        //Opretter vores listViews
        pane.add(konferenceListView, 0, 1, 2, 5);

        pane.add(deltagerListView, 6, 1, 2, 5);

        // pane.add(hotelListView,5,1,2,5);

        // pane.add(tilmeldingListView,8,1,2,5);


        //Opretter Labels
        lblKonference = new Label("Konferencer");
        pane.add(lblKonference, 0, 0);

        LblUdlfugter = new Label("Udflugter");
        pane.add(LblUdlfugter, 2, 0);

        LblHotelMedInfo = new Label("Hoteller");
        pane.add(LblHotelMedInfo, 3, 0);

        LblTilmeldninger = new Label("Tilmeldninger");
        pane.add(LblTilmeldninger, 4, 0);

        LblDeltagerMedFulInfo = new Label("Deltager med fuld Info");
        pane.add(LblDeltagerMedFulInfo, 5, 0);


        //Opretter vores Buttons
        BtnCreateKonfernce = new Button("Opret Konference");
        pane.add(BtnCreateKonfernce, 1, 8);
        BtnCreateKonfernce.setOnAction(event -> createOpretKonference());

        btnCreatetilmelding = new Button("Opret Tilmeldning");
        pane.add(btnCreatetilmelding, 4, 4);

        btnCreatetilmelding.setOnAction(event -> {
            Konference valgtKonference = konferenceListView.getSelectionModel().getSelectedItem();
            Deltager valgtDeltager = deltagerListView.getSelectionModel().getSelectedItem();

            if (valgtKonference != null && valgtDeltager != null) {
                opretTilmeldingVindue(valgtKonference, valgtDeltager);
            }
        });

        // Laver vores ListViwes

        List<Konference> storageForestilling = storage.getKonferenceer();

        ObservableList<Konference> konferenceObservableList = FXCollections.observableArrayList(storageForestilling);


        List<Deltager> storageDeltager = storage.getDeltagerer();

        ArrayList<Konference> deltagerObservableList = Controller.getKonference();


        List<Tilmelding> storageTilmelding = storage.getTilmeldinger();

        ObservableList<Tilmelding> tilmeldingObservableList = FXCollections.observableList(storageTilmelding);


        List<Hotel> storageHotel = storage.getHoteller();

        ObservableList<Hotel> hotelObservableList = FXCollections.observableList(storageHotel);


        //initalisere vores Listwievs

        konferenceListView.setItems(konferenceObservableList);

        deltagerListView.setItems(deltagerObservableList);

        hotelListView.setItems(hotelObservableList);

        tilmeldingListView.setItems(tilmeldingObservableList);


    }


    private void createOpretKonference() {
        Window_OpretKonference dia = new Window_OpretKonference("Opret Konference");
        dia.showAndWait();

        konferenceListView.getItems().setAll(getKonference());
        int index = konferenceListView.getItems().size() - 1;
        konferenceListView.getSelectionModel().select(index);
    }

    private void opretTilmeldingVindue(Konference konference, Deltager deltager) {
        Tilmeldning_Window dia = new Tilmeldning_Window("Opret Tilmeldning");
        dia.showAndWait();

        tilmeldingListView.getItems().setAll(getTilmelding());
        int index = tilmeldingListView.getItems().size() - 1;
        tilmeldingListView.getSelectionModel().select(index);
    }






//    private void CreateOpretTilmeldning(){
//
//        Tilmeldning_Window dia = new Tilmeldning_Window("Opret Tilmeldning");
//        dia.showAndWait();
//        new Label("Konference: " + konferenceListView.getSelectionModel().getSelectedItems()
//                new Label("Deltager: " + deltager.getNavn()));
//
//        tilmeldingListView.getItems().setAll(getTilmelding());
//        int index = tilmeldingListView.getItems().size() - 1;
//        tilmeldingListView.getSelectionModel().select(index);
//    }
}

