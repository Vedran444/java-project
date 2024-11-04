package Serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeLogger {

    private static final String CHANGE_LOG_FILE = "serialized-txt/changes.ser";

    public static void logChange(Change change) {
        List<Change> changes = loadChanges();
        changes.add(change);
        saveChanges(changes);
    }

    public static List<Change> loadChanges() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CHANGE_LOG_FILE))) {
            return (List<Change>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private static void saveChanges(List<Change> changes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CHANGE_LOG_FILE))) {
            oos.writeObject(changes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
