package shapes.examplefillstroke;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        Circle c1 = new Circle(50, 50, 30);
        pane.getChildren().add(c1);

        Circle c2 = new Circle(130, 50, 30);
        pane.getChildren().add(c2);
        c2.setFill(Color.CORNFLOWERBLUE);

        Circle c3 = new Circle(210, 50, 30);
        pane.getChildren().add(c3);
        c3.setFill(Color.CORNFLOWERBLUE);
        c3.setStroke(Color.BLACK);

        Circle c4 = new Circle(290, 50, 30);
        pane.getChildren().add(c4);
        c4.setFill(null);
        c4.setStroke(Color.BLACK);
    }

}
