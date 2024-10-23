package opgaver_3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 2");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField combined = new TextField();
    private final TextField firstName = new TextField();
    private final TextField lastName = new TextField();


    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(true);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(combined,0,1,2,1);
        pane.add(firstName, 0, 2, 1, 1);
        pane.add(lastName,1,2,1,1);

   

        // add a button to the pane (at col=1, row=1)
        Button btnSplit = new Button("Split");
        pane.add(btnSplit, 0, 3);
        GridPane.setMargin(btnSplit, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnSplit.setOnAction(event -> splitAction());

    }

    // -------------------------------------------------------------------------

    private void splitAction() {
        String fullName = combined.getText().trim();
        int index = fullName.indexOf(" ");
        String forNavn = fullName.substring(0,index);
        firstName.setText(forNavn);
        String efterNavn = fullName.substring(index);
        lastName.setText(efterNavn);


    }

}
