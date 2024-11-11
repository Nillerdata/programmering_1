package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class CustomerWindow extends Stage {
    private Customer customer;
    private Company company;
    public CustomerWindow(String title, Company company) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.company = company;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    public CustomerWindow(String title){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);



        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private TextField txfName;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new javafx.scene.control.Label("Name");
        pane.add(lblName, 0, 0);

        txfName = new TextField();
        pane.add(txfName, 0, 1);

        Button btnOK = new Button("ok");
        pane.add(btnOK, 1, 0);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        Button btncancel = new Button("cancel");
        pane.add(btncancel, 1, 1);
        GridPane.setHalignment(btncancel, HPos.LEFT);
        btncancel.setOnAction(event -> this.cancelAction());

    }

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
        }else if (company != null){
            Controller.createCustomer(name,company);

        }else
            Controller.createCustomer(name);
    this.hide();
    }
}
