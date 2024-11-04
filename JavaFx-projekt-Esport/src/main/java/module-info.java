module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires jbcrypt;

    opens javaFx.Application to javafx.fxml;
    exports javaFx.Application;
}