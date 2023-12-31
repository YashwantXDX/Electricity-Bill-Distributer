package com.myapp.electricity_bill_distributer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Electricity Bill Distributer");
        Image image = new Image("logo.png");
        stage.getIcons().add(image);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    

    public static void main(String[] args) {
        launch();
    }


}