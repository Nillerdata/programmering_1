package exercise_04_03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc) {
        // Replace the statement here with your code.
        //lave en ellipse
        //initialize loop control variables
        int x = 100; // center: x,y
        int y = 100;
        int r1 = 20;
        int r2 = 40;
        while (r1 <= 90) {//loop continuation condition
            gc.strokeOval(x-r1, y-r2, 2*r1, 2*r2);//action after each iteration
            r1=r1+10;//-||-
        }

    }
}