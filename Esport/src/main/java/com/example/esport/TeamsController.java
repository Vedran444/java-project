package com.example.esport;

import entiteti.Timovi;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import utils.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeamsController extends  HomeController {

    @FXML
    private TableView<Timovi> timoviTableView;

    @FXML
    private TableColumn<Timovi, String> TeamNameTableColumn;

    @FXML
    private TableColumn<Timovi, String> NationalityTableColumn;

    @FXML
    private TableColumn<Timovi, String> WinsTableColumn;

    @FXML
    private TextField TeamName;

    @FXML
    private ComboBox<Integer> Wins;


    @FXML
    void initialize(){

        TeamNameTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Timovi,String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Timovi, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getTeamName());
            }
        });

        NationalityTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Timovi,String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Timovi, String> param) {
                return new ReadOnlyStringWrapper(param.getValue().getTeamNationality());
            }
        });

        WinsTableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Timovi,String>, ObservableValue<String>>() {
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Timovi, String> param) {
                return new ReadOnlyStringWrapper(String.valueOf(param.getValue().getBrojPobjeda()));
            }
        });

        TeamSearch();
        WinsComboBox();
    }

    public void TeamSearch(){

        List<Timovi> teams = Database.GetTeams();
        ObservableList<Timovi> ObservableTimovi = FXCollections.observableArrayList(teams);
        timoviTableView.setItems(ObservableTimovi);
    }

    @FXML
    private void WinsComboBox() {

        List<Integer> wins = Database.GetTeams().stream()
                .map(Timovi::getBrojPobjeda)
                .distinct()
                .collect(Collectors.toList());
        Wins.setItems(FXCollections.observableArrayList(wins));
    }

    @FXML
    private void filterTeams() {

        String teams = TeamName.getText().toLowerCase();
        Integer selectedWins = Wins.getValue();

        List<Timovi> filteredTeams = Database.GetTeams().stream()
                .filter(team -> team.getTeamName().toLowerCase().contains(teams))
                .filter(team -> selectedWins == null || team.getBrojPobjeda() == selectedWins)
                .collect(Collectors.toList());

        timoviTableView.setItems(FXCollections.observableArrayList(filteredTeams));
    }


    @FXML
    private void resetFilters() {
        TeamName.clear();
        Wins.setValue(null);
        TeamSearch();
    }

    @FXML
    public  void handleBackButton(ActionEvent event) {
        super.handleBackButton(event);
    }
}
