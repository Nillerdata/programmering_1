package opgave_1;

import demoopenwindow.Movie;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PersonInputWindow extends Stage {

    public PersonInputWindow(String name, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(name);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfTitle = new TextField();
    private final TextField txfName = new TextField();
    private CheckBox chbSenior = new CheckBox();

    private Person actualPerson = null;


    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);



        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);

        pane.add(txfName, 1, 0, 2, 1);
        pane.add(txfTitle,1,1,2,1);
        chbSenior = new CheckBox("Senior");
        pane.add(chbSenior,1,2);

        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void cancelAction() {
        txfTitle.clear();
        txfTitle.requestFocus();
        txfName.clear();
        actualPerson = null;
        PersonInputWindow.this.hide();
    }

    private void okAction() {
        String title = txfTitle.getText().trim();
        String name = txfName.getText().trim();
        boolean senior = chbSenior.isSelected();

        if (title.length() > 0 && name.length() > 0) {
            actualPerson = new Person(name,title,senior);
            txfTitle.clear();
            txfName.clear();
            txfTitle.requestFocus();
            PersonInputWindow.this.hide();



        }else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add person");
            alert.setHeaderText("No name typed");
            alert.setContentText("Type the name of the person");
            alert.show();
        }
    }

    // -------------------------------------------------------------------------

    public Person getActualPerson() {
        return actualPerson;
    }

    public void clearActualPerson() {
        actualPerson = null;
    }
}
