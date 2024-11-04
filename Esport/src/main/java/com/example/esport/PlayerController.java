package com.example.esport;

import entiteti.Igraci;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.Database;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PlayerController extends HomeController {

    @FXML
    private TextField name;

    @FXML
    private ComboBox<Integer> godine;

    @FXML
    private TableView<Igraci> PlayersTableView;

    @FXML
    private TableColumn<Igraci, String> PlayerNameTableColumn;

    @FXML
    private TableColumn<Igraci, String> PlayerSurnameTableColumn;

    @FXML
    private TableColumn<Igraci, String> PlayerAgeTableColumn;

    @FXML
    private TableColumn<Igraci, String> PlayerNationalityTableColumn;

    @FXML
    private TableColumn<Igraci, String> PlayerIdTableColumn;

    @FXML
    private TableColumn<Igraci, Void> editColumn;

    @FXML
    private Button Home;

    private ObservableList<Igraci> playerList;

    @FXML
    void initialize() {

        playerList = FXCollections.observableArrayList(Database.GetPlayers());

        PlayerNameTableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getName()));
        PlayerSurnameTableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getSurname()));
        PlayerAgeTableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(String.valueOf(param.getValue().getAge())));
        PlayerNationalityTableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(param.getValue().getNationality()));
        PlayerIdTableColumn.setCellValueFactory(param -> new ReadOnlyStringWrapper(String.valueOf(param.getValue().getId())));

        editColumn.setCellFactory(param -> new TableCell<>() {

            private final Button deleteButton = new Button("Delete");
            private final Button editButton = new Button("Edit");
            private final HBox pane = new HBox(deleteButton, editButton);

            {
                if (!LoginApplication.isAdminLoggedIn()) {
                    pane.setVisible(false);
                    deleteButton.setVisible(false);
                    editButton.setVisible(false);
                }

                deleteButton.setOnAction(event -> {
                    Igraci player = getTableView().getItems().get(getIndex());

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirm Deletion");
                    alert.setHeaderText("Are you sure you want to delete this player?");
                    alert.setContentText("Player: " + player.getName() + " " + player.getSurname());

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        Database.deletePlayer(player);
                        Platform.runLater(() -> playerList.remove(player));
                    }
                });

                editButton.setOnAction(event -> {
                    Igraci player = getTableView().getItems().get(getIndex());

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirm Edit");
                    alert.setHeaderText("Are you sure you want to edit this player?");
                    alert.setContentText("Player: " + player.getName() + " " + player.getSurname());

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        openEditDialog(player);
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(pane);
                }
            }
        });

        PlayersTableView.setItems(playerList);
        PlayerSearch();
        godineComboBox();
    }

    private void godineComboBox() {

        List<Integer> years = playerList.stream()
                .map(Igraci::getAge)
                .distinct()
                .collect(Collectors.toList());
        godine.getItems().setAll(years);
    }

    public void PlayerSearch() {

        FilteredList<Igraci> playerFilter = new FilteredList<>(playerList);

        String ime = name.getText();
        Integer age = godine.getValue();


        if (age != null) {
            playerFilter.setPredicate(igrac -> Objects.equals(igrac.getAge(), age));
        }

        if (ime != null && !ime.isEmpty()) {
            playerFilter.setPredicate(igrac -> igrac.getName().equalsIgnoreCase(ime));
        }

        PlayersTableView.setItems(playerFilter);
    }

    @FXML
    public void resetFilter() {
        name.clear();
        godine.setValue(null);
        PlayersTableView.setItems(playerList);
    }

    private void openEditDialog(Igraci player) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editPlayer.fxml"));
            Parent root = loader.load();

            EditPlayerController controller = loader.getController();
            controller.setPlayer(player);
            controller.setPlayerController(this);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Uredi igrača");
            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleBackButton(ActionEvent event) {
        super.handleBackButton(event);
    }
}
