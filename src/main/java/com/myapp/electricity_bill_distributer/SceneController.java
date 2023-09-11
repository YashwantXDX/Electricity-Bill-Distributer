package com.myapp.electricity_bill_distributer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button exitBtn;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private TextField unit1tf,unit2tf,amttf,mbTotElecUnit,mbCurrUnit,mbPrevUnit,mbAmount,mbNoHouse,prevunit1tf,prevunit2tf;
    @FXML
    private Button calculateBtn, calculateMB;

    public void switchToMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHouseBill(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("H-B-D.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMotorBill(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MB.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void exitApp(){
        stage = (Stage) mainPane.getScene().getWindow();
        stage.close();
    }

    House_Bill_Distributer hbd;
    float U1Amount, U2Amount, HBAmount, PU1Amount, PU2Amount;
    public void calculate(ActionEvent event) {
        try{
            U1Amount = Float.parseFloat(unit1tf.getText());
            U2Amount = Float.parseFloat(unit2tf.getText());
            HBAmount = Float.parseFloat(amttf.getText());
            PU1Amount = Float.parseFloat(prevunit1tf.getText());
            PU2Amount = Float.parseFloat(prevunit2tf.getText());

            hbd = new House_Bill_Distributer();
            hbd.calculateAmount(U1Amount,U2Amount,HBAmount,PU1Amount, PU2Amount);
        }
        catch(Exception e){
            hbd = new House_Bill_Distributer();
            hbd.error();
            unit1tf.setText("");
            unit2tf.setText("");
            amttf.setText("");
            prevunit1tf.setText("");
            prevunit2tf.setText("");
        }
    }

    Motor_Bill mBill;
    float amount1, amount2, amount3, amount4, nhouse;
    public void calculatemb(ActionEvent event){
        try{
            amount1 = Float.parseFloat(mbTotElecUnit.getText());
            amount2 = Float.parseFloat(mbCurrUnit.getText());
            amount3 = Float.parseFloat(mbPrevUnit.getText());
            amount4 = Float.parseFloat(mbAmount.getText());
            nhouse = Float.parseFloat(mbNoHouse.getText());
            mBill = new Motor_Bill();
            mBill.calculateAmount(amount3, amount2, amount1, amount4, nhouse);
        }
        catch(Exception e){
            mBill = new Motor_Bill();
            mBill.error();
            mbTotElecUnit.setText("");
            mbCurrUnit.setText("");
            mbPrevUnit.setText("");
            mbAmount.setText("");
            mbNoHouse.setText("");
        }
    }
}
