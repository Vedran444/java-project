package com.example.esport;

import Thread.SavePlayerThread;
import Serialization.Change;
import Serialization.ChangeLogger;
import entiteti.Igraci;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import utils.Database;


import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NewPlayerController extends HomeController {

    @FXML
    private TextField ime;

    @FXML
    private TextField prezime;
    @FXML
    private TextField nacionalnost;

    @FXML
    private TextField godine;

    @FXML
    private TextField id;


    @FXML
    public void SpremiIgraca() throws InterruptedException {

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Potvrda spremanja");
        confirmationAlert.setHeaderText("Jeste li sigurni da želite spremiti novog igrača?");

        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {

            Set<Igraci> igraci = new HashSet<>();

            String name = ime.getText();
            String surname = prezime.getText();
            String nationality = nacionalnost.getText();
            int age = Integer.parseInt(godine.getText());
            int ID = Integer.parseInt(id.getText());

            Igraci igrac = new Igraci(name, surname, age, nationality, ID);
            igraci.add(igrac);

            SavePlayerThread savePlayer = new SavePlayerThread(igraci);

            Executor executor = Executors.newSingleThreadExecutor();

            Thread.sleep(5000);

            executor.execute(() -> {
                savePlayer.run();


                boolean saveSuccessful = Database.isSaveSuccessful();

                Platform.runLater(() -> {
                    if (saveSuccessful) {

                        ChangeLogger.logChange(new Change("Player", "New Player", igrac.toString(), "Admin", LocalDateTime.now()));

                        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
                        infoAlert.setTitle("Spremanje uspješno");
                        infoAlert.setHeaderText("Spremanje novog igrača je bilo uspješno!");
                        infoAlert.showAndWait();
                    } else {
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setHeaderText("Greška pri spremanju igrača");
                        errorAlert.setContentText("Dogodila se greška prilikom spremanja igrača.");
                        errorAlert.showAndWait();
                    }
                });
            });
        } else {
            Alert cancelAlert = new Alert(Alert.AlertType.INFORMATION);
            cancelAlert.setTitle("Spremanje otkazano");
            cancelAlert.setHeaderText("Spremanje novog igrača je otkazano.");
            cancelAlert.showAndWait();
        }
    }


    @FXML
    public  void handleBackButton(ActionEvent event) {
        super.handleBackButton(event);
    }

}
