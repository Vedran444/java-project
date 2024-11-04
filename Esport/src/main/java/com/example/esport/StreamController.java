package com.example.esport;
import javafx.fxml.FXML;

import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import  java.awt.*;

public class StreamController {

    @FXML
    private Hyperlink hyperlink1;

    @FXML
    private Hyperlink hyperlink2;

    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    public void handleImageClick1(){
        try{
            Desktop.getDesktop().browse(new URI("https://www.twitch.tv/directory/category/counter-strike"));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleImageClick2() {
        try{
            Desktop.getDesktop().browse(new URI("https://www.twitch.tv/directory/category/league-of-legends"));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

}
