package opgaver.guidemo_2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

    private final TextField txfName = new TextField();
    private final TextField txfName1 = new TextField();
    private final TextArea combined1= new TextArea();

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
//        Label lblName = new Label("Name:");
//        pane.add(lblName, 0, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
        // Deleted here is:
        // TextField txfName = new TextField();
        pane.add(txfName,0 , 0, 1, 1);
        pane.add(txfName1,1,0,1,1);
        pane.add(combined1,0,1,2,1);
        combined1.setPrefRowCount(1);
        combined1.setPrefWidth(270);
        combined1.setEditable(false);
   

        // add a button to the pane (at col=1, row=1)
        Button btnUpperCase = new Button("kombiner");
        pane.add(btnUpperCase, 0, 2);
        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnUpperCase.setOnAction(event -> kombiner1());




    }

    // -------------------------------------------------------------------------

    private void kombiner1() {
    StringBuilder sb = new StringBuilder();

        String name = txfName.getText().trim();
        String lastName = txfName1.getText().trim();
        combined1.setText(name + " " + lastName);
    }


}
