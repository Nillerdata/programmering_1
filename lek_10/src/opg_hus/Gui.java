package opg_hus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
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
        Circle circle = new Circle(240, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.YELLOW);
        circle.setStroke(Color.BLACK);

        Line line = new Line(20,340,390,340);
        pane.getChildren().add(line);
        line.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle(40,240,100,100);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.RED);
        rectangle.setStroke(Color.BLACK);

        Polygon polygon = new Polygon(20,240,160,240,90,170);
        pane.getChildren().add(polygon);
        polygon.setFill(Color.GREEN);
        polygon.setStroke(Color.BLACK);

        Rectangle rectd = new Rectangle(65,265,33,30);
        pane.getChildren().add(rectd);
        rectd.setFill(Color.BLACK);


        //min egen addition til tegningen
        //rektangel af toppen af skorsten
        Rectangle skorstentop = new Rectangle(50,150,20,40);
        pane.getChildren().add(skorstentop);
        skorstentop.setFill(Color.GREY);
        skorstentop.setStroke(Color.BLACK);

        //polygon til bunden af skorsten
        Polygon skorstenbund = new Polygon(50,210,70,190,50,180);
        pane.getChildren().add(skorstenbund);
        skorstenbund.setFill(Color.GREY);
        skorstenbund.setStroke(Color.BLACK);
        //røg fra skorstenen 1
        Circle røg1 = new Circle(60,130,10);
        pane.getChildren().add(røg1);
        røg1.setFill(Color.LIGHTGRAY);
        //røg fra skorsten 2
        Circle røg2 = new Circle(65,110,15);
        pane.getChildren().add(røg2);
        røg2.setFill(Color.LIGHTGRAY);




    }
}
