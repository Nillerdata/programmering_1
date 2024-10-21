package opg_02_smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        Circle circle = new Circle(70, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);

        Circle circle1 = new Circle(60,65,5);
        pane.getChildren().add(circle1);
        circle1.setFill(Color.TRANSPARENT);
        circle1.setStroke(Color.BLACK);

        Circle circle2 = new Circle(78,65,5);
        pane.getChildren().add(circle2);
        circle2.setFill(Color.TRANSPARENT);
        circle2.setStroke(Color.BLACK);

        Line line = new Line(60,82,78,82);
        pane.getChildren().add(line);
        line.setStroke(Color.BLACK);
    }
}
