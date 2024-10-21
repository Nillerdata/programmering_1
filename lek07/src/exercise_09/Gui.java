package exercise_09;

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
        double x1 = 180;//start (x1,y1)
        double y1 = 180;//start y koordinat (bunden af linjen)
        //slut (x2, y2)
        double y2 = 90; //slut y koordinat toppen af y

        while (x1 > 5) {
            gc.strokeLine(x1,y1,x1,y2); //25% af linjen (top)
            y1*=0.98;
            y2*=1.04;

            x1 *=0.75;//skabe afstand imellem linjer (obligatorisk. gør lærer glad)
//        int i = 0;
//        while (x1 > 5 || i == 13) {
//            gc.strokeLine(x1, y1, x1, y2);
//            x1 *= 0.75;//får x1 til at skabe plads imellem linjerne
//            y1 -=5;
//            y2 += 2;
//            i++;
//
//        }

        }
    }
}