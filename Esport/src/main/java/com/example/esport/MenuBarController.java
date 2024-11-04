package com.example.esport;

import Thread.OldestPlayerThread;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.stage.Stage;

import utils.AlertUtility;


import java.io.IOException;
public class MenuBarController {

    @FXML
    private Menu showChangesMenuItem;


    @FXML
    void initialize(){

        if(!LoginApplication.isAdminLoggedIn()){

            showChangesMenuItem.setVisible(false);
        }
    }
    @FXML
    public void Dashboard(Stage stage){


        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("menubar.fxml"));

        try{
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            LoginApplication.getMainstage().setTitle("Dashboard");
            LoginApplication.getMainstage().setScene(scene);
            LoginApplication.getMainstage().show();
        }catch (IOException e){

            throw new RuntimeException(e);
        }

    }

    @FXML
    private void ShowTeams() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("teams.fxml"));
        try {

            Scene scene = new Scene(loader.load(), 600, 400);
            LoginApplication.getMainstage().setTitle("Dashboard");
            LoginApplication.getMainstage().setScene(scene);
            LoginApplication.getMainstage().show();

        }catch(IOException e){

            throw new RuntimeException(e);

        }
    }


    @FXML
    private void ShowPlayers() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("players.fxml"));
        try {


            Scene scene = new Scene(loader.load(), 600, 400);
            LoginApplication.getMainstage().setTitle("Dashboard");
            LoginApplication.getMainstage().setScene(scene);
            LoginApplication.getMainstage().show();

            Thread oldestPlayerThread = new Thread(new OldestPlayerThread());
            oldestPlayerThread.start();


        }catch(IOException e){

            throw new RuntimeException(e);

        }
    }



    @FXML
    void AddPlayer() {

        if (LoginApplication.isAdminLoggedIn()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewPlayer.fxml"));
            try {

                Scene scene = new Scene(loader.load(), 600, 400);
                LoginApplication.getMainstage().setTitle("NewPlayer");
                LoginApplication.getMainstage().setScene(scene);
                LoginApplication.getMainstage().show();

            } catch (IOException e) {

                throw new RuntimeException(e);

            }
        }else{
            AlertUtility.showAlert("Morate se prijaviti kao admin kako biste pristupili dodavanju igrača.");
        }
    }



    @FXML
    private void openChangeLog() {
        if (LoginApplication.isAdminLoggedIn()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("changes.fxml"));
                Parent root = loader.load();

                Scene scene = new Scene(root, 600, 400);

                Stage stage = new Stage();
                stage.setTitle("Change Log");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            AlertUtility.showAlert("Morate se prijaviti kao admin kako biste pristupili promjenama.");
        }
    }


    @FXML
    private void openStreamingPlatforms() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stream.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 600, 400);

            Stage stage = new Stage();
            stage.setTitle("Streaming Platforms");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
