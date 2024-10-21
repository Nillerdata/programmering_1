package exercise_06;

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
        {


            gc.strokeLine(20, 180, 160, 180); // x1, y1, x2, y2 (den lange linje)
            // tegne y akse streger
            for (int i = 0; i <= 10; i++) {
                int x = 20 + i * 13; // placering og afstand af stregerne
// skrive numre ind
                //skrive nul ind
                String nul = "0";
                gc.fillText(nul, 20, 195);

                //skrive fem ind
                String fem = "5";
                gc.fillText(fem,85,195);

                //skrive 10 ind
                String ti = "10";
                gc.fillText(ti,150, 195);
                //skifte imellem kort eller lang y streg
                if (i % 2 == 0) {
                    gc.strokeLine(x, 182, x, 178); // korte streger på y akse
                } else {
                    gc.strokeLine(x, 185, x, 175); // lange streger på y akse
                }

            }
        }

        // slutningen af den lange linje mod højre skal der være pilehoved
        gc.strokeLine(162, 180, 158, 175);
        gc.strokeLine(162, 180, 158, 185);


    }

}


