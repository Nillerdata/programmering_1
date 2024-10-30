package opgave_1;

import demoopenwindow.Movie;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {

  
    @Override
    public void start(Stage stage) {
        stage.setTitle("person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personwindow = new PersonInputWindow("add person",stage);
    }

    // -------------------------------------------------------------------------

    private final ListView<opgave_1.Person> lvwPersons = new ListView<>();
//    private final TextField Title = new TextField();
    private final ArrayList<opgave_1.Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
//    private  CheckBox chbSenior = new CheckBox();
    private PersonInputWindow personwindow;
    private final TextField txfResult = new TextField();

    private void initContent(GridPane pane) {
        this.initPersons();

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

//        Label lblName = new Label("Name:");
//        pane.add(lblName, 0, 0);
//        Label lblTitle = new Label("Title");
//        pane.add(lblTitle,0,1);
//
//        Label lblpersons = new Label("Persons:");
//        pane.add(lblpersons, 0, 3);
//

//        pane.add(Title,1,1,2,1);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 3, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<opgave_1.Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

//        chbSenior = new CheckBox("Senior");
//        pane.add(chbSenior,1,2);
//        pane.add(txfResult, 1, 0, 2, 1);
//        txfResult.setEditable(false);


        Button btnAddPerson = new Button("Add Person");
        pane.add(btnAddPerson, 6, 3);

        // connect a method to the button
        btnAddPerson.setOnAction(event -> this.AddPersonAction());

    }

    // -------------------------------------------------------------------------
    // Button actions

    private void AddPersonAction() {
        personwindow.showAndWait();

        if (personwindow.getActualPerson() != null) {
            Person person = personwindow.getActualPerson();
            System.out.println(person);
            persons.add(person);
            lvwPersons.getItems().setAll(persons);

        }
//        String name = txfName.getText().trim();
//        String title = Title.getText().trim();
//        boolean senior = chbSenior.isSelected();

//        if (name.length() > 0 && title.length() > 0) {
//            Person p = new Person(name, title, senior);
//
//            persons.add(p);
//            lvwPersons.getItems().setAll(persons);
//        } else {
//            //opgave 2
//
//                Alert bob = new Alert(Alert.AlertType.INFORMATION);
//                bob.setTitle("Create movie");
//                bob.setHeaderText("Information missing");
//                bob.setContentText("Type title and actor");
//                bob.show();
//
//
//        }
        }

    private void initPersons() {

    }

    // -------------------------------------------------------------------------
    // Selection changed action

    private void selectionChanged() {
        opgave_1.Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getName());
        } else {
            txfName.clear();
        }
    }
}
