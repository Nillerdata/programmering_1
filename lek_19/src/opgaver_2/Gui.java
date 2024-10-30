package opgaver_2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    private final TextField øverste = new TextField();
    private final TextField nederste = new TextField();

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
//        Label lblName = new Label("Swap Frame");
//        pane.add(lblName, 0, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(øverste, 0, 0, 2, 1);
        pane.add(nederste,0,1,2,1);
   

        // add a button to the pane (at col=1, row=1)
        Button btnSwap = new Button("ombyt");
        pane.add(btnSwap, 0, 3);
        GridPane.setMargin(btnSwap, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnSwap.setOnAction(event -> fieldSwap());



    }

    // -------------------------------------------------------------------------

    private void fieldSwap() {
        String upper = øverste.getText().trim();
        String downer = nederste.getText().trim();
        øverste.setText(downer);
        nederste.setText(upper);






    }


}
