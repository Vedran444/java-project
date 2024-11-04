package com.example.esport;

import Serialization.Change;
import Serialization.ChangeLogger;
import entiteti.Igraci;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Database;

import java.time.LocalDateTime;

public class EditPlayerController {

    @FXML
    private TextField ime;

    @FXML
    private TextField prezime;

    @FXML
    private TextField godine;

    @FXML
    private TextField nacionalnost;

    private Igraci player;
    private PlayerController playerController;


    public void setPlayer(Igraci player) {

        this.player = player;
        ime.setText(player.getName());
        prezime.setText(player.getSurname());
        godine.setText(String.valueOf(player.getAge()));
        nacionalnost.setText(player.getNationality());
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    @FXML
    public void savePlayer() {

        String oldValue = player.toString();

        player.setName(ime.getText());
        player.setSurname(prezime.getText());
        player.setAge(Integer.parseInt(godine.getText()));
        player.setNationality(nacionalnost.getText());

        Database.updatePlayer(player);

        String newValue = player.toString();


        playerController.PlayerSearch();
        ChangeLogger.logChange(new Change("Player", oldValue, newValue, "Admin", LocalDateTime.now()));
        closeDialog();

    }

    private void closeDialog() {
        Stage stage = (Stage) ime.getScene().getWindow();
        stage.close();
    }

}
