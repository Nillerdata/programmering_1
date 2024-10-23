package opgaver_4;

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

    private final TextField number = new TextField();

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
        Label lblName = new Label("Number:");
        pane.add(lblName, 0, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(number, 1, 0, 2, 1);
   

        // add a button to the pane (at col=1, row=1)
        Button btnNumUp = new Button("+");
        pane.add(btnNumUp, 1, 1);
        GridPane.setMargin(btnNumUp, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnNumUp.setOnAction(event -> numUpAction());

        // add a button to the pane (at col=2, row=1)
        Button btnNumDown = new Button("-");
        pane.add(btnNumDown, 2, 1);
        GridPane.setMargin(btnNumDown, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnNumDown.setOnAction(event -> this.numDownAction());
    }

    // -------------------------------------------------------------------------

    private void numUpAction() {
        String input = number.getText().trim();
        int tal = Integer.parseInt(input);
        tal++;
        number.setText(tal+"");
    }

    private void numDownAction() {
        String input = number.getText().trim();
        int tal = Integer.parseInt(input);
        tal--;
        String lowDown= Integer.toString(tal);
        number.setText(lowDown);


    }
}
