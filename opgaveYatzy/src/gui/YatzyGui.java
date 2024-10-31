package gui;


import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.YatzyDice;


public class YatzyGui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // Shows the face values of the 5 dice.
    private TextField[] txfValues;
    // Shows the hold status of the 5 dice.
    private CheckBox[] chbHolds;
    // Shows the results previously selected .
    // For free results (results not set yet), the results
    // corresponding to the actual face values of the 5 dice are shown.
    private TextField[] txfResults;
    // Shows points in sums, bonus and total.
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    // Shows the number of times the dice has been rolled.
    private Label lblRolled;
    private boolean[] holds;
    private Button btnRoll;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------
        holds = new boolean[5];
        for (int i = 0; i < holds.length; i++) {
            holds[i] = false;
        }
        GridPane dicePane = new GridPane();//Øverste gridpane
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // initialize txfValues, chbHolds, btnRoll and lblRolled
        // TODO
        txfValues = new TextField[5];

        for (int i = 0; i < txfValues.length; i++) {

            TextField txfDice = new TextField();
            dicePane.add(txfDice, i, 0, 1, 1);
            txfDice.setPrefHeight(50);
            txfDice.setPrefWidth(50);
            txfDice.setEditable(false);
            txfValues[i] = txfDice;

        }

        chbHolds = new CheckBox[5];
        for (int i = 0; i < chbHolds.length; i++) {
            CheckBox chbValue = new CheckBox("Hold");
            dicePane.add(chbValue, i, 1);
            chbHolds[i] = chbValue;
            chbHolds[i].setDisable(true); /*Sørger for at man i starten af spillet
              ikke bare kan vælge hold og lade være med at bruge terninger*/
        }
        lblRolled = new Label("Rolled : " + yatzy.getThrowCount());
        dicePane.add(lblRolled, 4, 2);

        btnRoll = new Button("Roll");
        dicePane.add(btnRoll, 3, 2);

        btnRoll.setOnAction(event -> rollAction());
        // ---------------------------------------------------------------------
        GridPane scorePane = new GridPane();//nederste gridpane
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields
        // Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.
        // TODO
        String[] results = new String[]{"1-s", "2-s", "3-s", "4-s", "5-s", "6-s",
                "One pair", "Two pairs", "Three same", "Four same", "Full house", "Small straight",
                "Large straight", "Chance", "Yatzy"};

        txfResults = new TextField[15];

        for (int i = 0; i < results.length; i++) {
            Label lblResult = new Label(results[i]);
            scorePane.add(lblResult, 0, i);
            TextField txfResult = new TextField();
            txfResults[i] = txfResult;
            txfResult.setPrefWidth(30);
            txfResult.setEditable(false);
            txfResult.setOnMouseClicked(event -> this.chooseFieldAction(event));

            scorePane.add(txfResult, 1, i);

        }
        Label lblSumSame = new Label("Sum");
        scorePane.add(lblSumSame, 3, 5);

        txfSumSame = new TextField("0");
        scorePane.add(txfSumSame, 4, 5);
        txfSumSame.setEditable(false);
        txfSumSame.setPrefWidth(30);

        Label lblBonus = new Label("Bonus");
        scorePane.add(lblBonus, 5, 5);


        txfBonus = new TextField("0");
        scorePane.add(txfBonus, 6, 5);
        txfBonus.setEditable(false);
        txfBonus.setPrefWidth(30);


        Label lblSumOther = new Label("Sum :");
        scorePane.add(lblSumOther, 3, 14);

        txfSumOther = new TextField("0");
        scorePane.add(txfSumOther, 4, 14);
        txfSumOther.setEditable(false);
        txfSumOther.setPrefWidth(25);

        Label lblTotal = new Label("Total :");
        scorePane.add(lblTotal, 5, 14);

        txfTotal = new TextField("0");
        scorePane.add(txfTotal, 6, 14);
        txfTotal.setPrefWidth(25);
        txfTotal.setEditable(false);
    }

    // -------------------------------------------------------------------------

    private YatzyDice yatzy = new YatzyDice();

    // Create a method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    // TODO
    public void rollAction() {

        for (int i = 0; i < holds.length; i++) {
            holds[i] = chbHolds[i].isSelected();
            chbHolds[i].setDisable(false); /*l88 se reference */
        }
        yatzy.throwDice(holds);
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i].setText(yatzy.getValues()[i] + "");

        }
        if (yatzy.getThrowCount() == 3) {
            btnRoll.setDisable(true);
        }
        lblRolled.setText("Rolled : " + yatzy.getThrowCount());
        txfSumSame.setText("0");
        txfSumOther.setText("0");


        int[] result = yatzy.getResults(); //spørge Thomas/Lasse, hvordan dette fungerer fra 188
        for (int i = 0; i < result.length; i++) {

            if (!txfResults[i].isDisabled()) {
                txfResults[i].setText(result[i] + "");

            } else if (i < 6) {
                int newSumSame = Integer.parseInt(txfResults[i].getText());
                int oldSumSame = Integer.parseInt(txfSumSame.getText());

                txfSumSame.setText((newSumSame + oldSumSame) + "");
            } else {
                int newSumOther = Integer.parseInt(txfResults[i].getText());
                int oldSumOther = Integer.parseInt(txfSumOther.getText());

                txfSumOther.setText((newSumOther + oldSumOther) + "");
            }
        }
        if (Integer.parseInt(txfSumSame.getText()) >= 63) {
            txfBonus.setText("50");
        }
        int sumSame = Integer.parseInt(txfSumSame.getText());
        int sumOther = Integer.parseInt(txfSumOther.getText());
        int bonus = Integer.parseInt(txfBonus.getText());

        if (txfBonus.getText().equals("0")) {
            txfTotal.setText((sumSame + sumOther + bonus) + "");
        } else {
            txfTotal.setText((sumSame + sumOther) + "");
        }

    }
    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    // TODO
    public void chooseFieldAction(Event event) {
        TextField txfresultater = ((TextField) event.getSource());

        txfresultater.setDisable(true);//disable det resultat du har valgt
        yatzy.resetThrowCount();
        lblRolled.setText("rolled: " + yatzy.getThrowCount());
        for (int i = 0; i < chbHolds.length; i++) {
            chbHolds[i].setSelected(false);
            txfValues[i].clear();
            chbHolds[i].setDisable(true); //sørger for at du ikke kan starte næste kast med manglende terning
        }
        /*Fjerner de resultater der ikke blev trykket på */
        for (int i = 0; i < 15; i++) {
            if (!txfResults[i].isDisabled()) {
                txfResults[i].clear();
            }
            btnRoll.setDisable(false);/*l 180 disablede uden at slå til igen. */
        }

    }
}



