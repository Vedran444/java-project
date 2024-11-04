package com.example.esport;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApplication extends Application {


    private static boolean adminLoggedIn = false;

    public static Stage mainstage;

    @Override
    public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);
            stage.show();

            mainstage=stage;
    }

    public static Stage getMainstage() {
        return mainstage;
    }

    public static void main(String[] args) {
        launch();
    }

    public static boolean isAdminLoggedIn() {
        return adminLoggedIn;
    }

    public static void setAdminLoggedIn(boolean loggedIn) {
        adminLoggedIn = loggedIn;
    }

}