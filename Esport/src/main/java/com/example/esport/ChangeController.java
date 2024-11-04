package com.example.esport;

import Serialization.Change;
import Serialization.ChangeLogger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ChangeController {

        @FXML
        private TextArea changeLogTextArea;

        @FXML
        public void initialize() {
            List<Change> changes = ChangeLogger.loadChanges();
            StringBuilder changeLogBuilder = new StringBuilder();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            for (Change change : changes) {
                changeLogBuilder.append("Field: ").append(change.getFieldName()).append("\n")
                        .append("Old Value: ").append(change.getOldValue()).append("\n")
                        .append("New Value: ").append(change.getNewValue()).append("\n")
                        .append("Role: ").append(change.getRole()).append("\n")
                        .append("Timestamp: ").append(change.getTimestamp().format(formatter)).append("\n")
                        .append("===============\n");
            }

            changeLogTextArea.setText(changeLogBuilder.toString());
        }


}

