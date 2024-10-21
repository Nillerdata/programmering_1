package opg_05;

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
        int r = 25;
        Circle circle = new Circle(70, 70, r);
        pane.getChildren().add(circle);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLUE);
        circle.setStrokeWidth(3);

        Circle yellow = new Circle(95,95,r);
        pane.getChildren().add(yellow);
        yellow.setFill(Color.TRANSPARENT);
        yellow.setStroke(Color.YELLOW);
        yellow.setStrokeWidth(3);

        Circle black = new Circle(120,70,r);
        pane.getChildren().add(black);
        black.setFill(Color.TRANSPARENT);
        black.setStroke(Color.BLACK);
        black.setStrokeWidth(3);

        Circle green = new Circle(145,95,r);
        pane.getChildren().add(green);
        green.setFill(Color.TRANSPARENT);
        green.setStroke(Color.GREEN);
        green.setStrokeWidth(3);

        Circle red = new Circle(170,70,r);
        pane.getChildren().add(red);
        red.setFill(Color.TRANSPARENT);
        red.setStroke(Color.RED);
        red.setStrokeWidth(3);


    }
}
