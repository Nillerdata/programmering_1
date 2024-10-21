package opg_04;

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
        Circle circle = new Circle(70, 70, 5);
        pane.getChildren().add(circle);
        circle.setFill(Color.BLACK);
        circle.setStroke(Color.BLACK);

        Circle circle1 = new Circle(70,70,15);
        pane.getChildren().add(circle1);
        circle1.setFill(Color.TRANSPARENT);
        circle1.setStroke(Color.BLACK);
        circle1.setStrokeWidth(5);

        Circle circle2 = new Circle(70,70,25);
        pane.getChildren().add(circle2);
        circle2.setFill(Color.TRANSPARENT);
        circle2.setStroke(Color.BLACK);
        circle2.setStrokeWidth(5);
    }
}
