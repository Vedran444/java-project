package com.example.esport;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AlertUtility;
import utils.FileRead;

import java.io.IOException;

import static utils.FileRead.*;


public class UserLoginController {
    @FXML
    private TextField UserName;

    @FXML
    private PasswordField UserPass;

    @FXML
    private TextField UserPassShowed;

    @FXML
    private Button UserSubmit;


    @FXML
    private CheckBox showPass;

    private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

    @FXML
    private MenuBarController menuBarController;

    @FXML
    public void initialize() {
        menuBarController = new MenuBarController();
    }


    public void UserLogin() {

        String username = UserName.getText();
        String password = UserPass.getText();


        if (username.isEmpty() || password.isEmpty()) {
            AlertUtility.showAlert("Molimo unesite korisničko ime i lozinku.");
            return;
        }

        registerUser(username, password);

        if (FileRead.login2(username, password)) {
            AlertUtility.showAlert("Korisnička prijava uspješna");
            logger.info("Korisnička prijava uspješna!");

            menuBarController.Dashboard((Stage) UserSubmit.getScene().getWindow());
        } else {
            AlertUtility.showAlert("Pogrešno korisničko ime ili lozinka!");
        }
    }





    public void OpenAdminLogin() {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("admin-login.fxml"));
        try {

            Scene scene = new Scene(loader.load(), 600, 400);
            LoginApplication.getMainstage().setTitle("Admin Login");
            LoginApplication.getMainstage().setScene(scene);
            LoginApplication.getMainstage().show();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }



    @FXML
    private void handleShowPassword() {
        if (showPass.isSelected()) {

            UserPassShowed.setText(UserPass.getText());
            UserPass.setVisible(false);
            UserPassShowed.setVisible(true);
        } else {

            UserPass.setText(UserPassShowed.getText());
            UserPass.setVisible(true);
            UserPassShowed.setVisible(false);
        }
    }


}