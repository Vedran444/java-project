package com.example.esport;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AlertUtility;
import utils.FileRead;


import java.io.IOException;

import static utils.FileRead.registerAdmin;

public class AdminLoginController {

    @FXML
    private TextField AdminName;

    @FXML
    private PasswordField AdminPass;

    @FXML
    private Button AdminSubmit;

    @FXML
    private Button Home;



    private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @FXML
    private MenuBarController menuBarController;

    @FXML
    public void initialize() {
        menuBarController = new MenuBarController();
    }


    public void AdminLogin(){

        String username = "admin";

        registerAdmin(username);

        if (FileRead.login(AdminName.getText(),AdminPass.getText())) {
            AlertUtility.showAlert("Admin prijava uspjesna");
            logger.info("Admin prijava uspjesna!");

            LoginApplication.setAdminLoggedIn(true);
            menuBarController.Dashboard((Stage) AdminSubmit.getScene().getWindow());
        } else {

            AlertUtility.showAlert("Pogresno admin ime ili lozinka!");
        }
    }

    @FXML
    private void UserLogin() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent loginRoot = loader.load();

            Stage stage = (Stage) Home.getScene().getWindow();

            stage.setScene(new Scene(loginRoot));
            stage.show();
        } catch (IOException e) {
            logger.error("Neuspjesno ucitavanje user login stranice", e);
        }
    }




}
