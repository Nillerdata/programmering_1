package opg_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
        int h = 100;
        Color y123 = (Color.YELLOW);
        Circle circle = new Circle(70+h, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(y123);
        circle.setStroke(Color.BLACK);
        Rectangle rectangle = new Rectangle(100+h,110,160+h,90);
        pane.getChildren().add(rectangle);
        rectangle.setFill(y123);
        rectangle.setStroke(Color.TOMATO);
        Line line = new Line(150+h,30,150+h,90);
        pane.getChildren().add(line);
        line.setStroke(y123);

    }

}
