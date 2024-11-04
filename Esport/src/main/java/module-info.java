module com.example.esport {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires bcrypt;
    requires java.sql;
    requires javafx.web;
    requires java.desktop;


    opens com.example.esport to javafx.fxml;
    exports com.example.esport;
}