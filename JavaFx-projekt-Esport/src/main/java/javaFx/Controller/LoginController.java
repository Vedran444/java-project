package javaFx.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static javaFx.javafxprojektesport.utils.FileRead.login;
import static javaFx.javafxprojektesport.utils.FileRead.login2;


public class LoginController {
    @FXML
    private TextField UserName;

    @FXML
    private TextField UserPass;

    @FXML
    private Button UserSubmit;


    @FXML
    private TextField AdminName;

    @FXML
    private TextField AdminPass;

    @FXML
    private Button AdminSubmit;


    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    public void UserLogin(){

        if (login(UserName.getText(), UserPass.getText())) {

            showAlert("Korisnicka prijava uspjesna");
            logger.info("Korisnicka prijava uspjesna!");
        } else {

            showAlert("Pogresno korisnicko ime ili lozinka!");
        }

    }


        private void showAlert(String message) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(message);
            alert.showAndWait();
        }




    public void AdminLogin(){

        if (login2(UserName.getText(), UserPass.getText())) {

            showAlert("Admin prijava uspjesna");
            logger.info("Admin prijava uspjesna!");
        } else {
            showAlert("Pogresno korisnicko ime ili lozinka za admina!");
        }

    }

}