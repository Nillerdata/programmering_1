package exercise_04_02;

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
        int x = 20; // center: x,y
        int y = 100;
        int r = 20;//radius
        while (r < 80) {//loop continuation statement
            gc.strokeOval(x - r, y - r, 2 * r, 2 * r);//loop body
            r = r + 10;//action after each iteration
            x = x + 10;// -||-
        }

    }
}
