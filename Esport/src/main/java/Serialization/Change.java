package Serialization;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Change implements Serializable {


    private String fieldName;
    private String oldValue;
    private String newValue;
    private String role;
    private LocalDateTime timestamp;

    public Change(String fieldName, String oldValue, String newValue, String role, LocalDateTime timestamp) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.role = role;
        this.timestamp = timestamp;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getRole() {
        return role;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Change{" +
                "fieldName='" + fieldName + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                ", role='" + role + '\'' +
                ", Date=" + timestamp +
                '}';
    }
}
