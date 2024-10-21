package exercise_01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application
{
    

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc)
    {
        // Replace the statement here with your code.

        //draw an arrowhead at (50,30)
        int x = 50;
        int y = 30;
        gc.strokeLine(x, y, x+20,y -4);
        gc.strokeLine(x, y, x+20, y+4);

        //draw an arrowhead at (25,140)
        int X = 25;
        int Y = 140;
        gc.strokeLine(X,Y,X+20, Y-4);
        gc.strokeLine(X, Y, X+20, Y+4);

        //draw arrowhead at (20,50)
        int z = 20;
        int t = 50;
        gc.strokeLine(z,t,z+20,t-4);
        gc.strokeLine(z,t,z+20,t+4);
    }

}
