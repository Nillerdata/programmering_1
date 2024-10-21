package fillName;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {

        Rectangle rectangle = new Rectangle(100,100,150,80);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.BLUE);
        rectangle.setStroke(Color.BLACK);
        Text text = new Text(160, 145, "Niels");
        text.setFill(Color.RED);
        pane.getChildren().add(text);
    }
}
