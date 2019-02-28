package com.nodo.view.controllers;

import com.nodo.Main;
import com.nodo.model.Profesor;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class IndexOverviewController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    private Profesor profesor;

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public BorderPane rootLayout;

    public void show() {

        Main.getPrimaryStage().setMinHeight(400);
        Main.getPrimaryStage().setMinWidth(600);
        Main.getPrimaryStage().setMaxHeight(630);
        Main.getPrimaryStage().setMaxWidth(1000);
        Main.getPrimaryStage().setMaximized(true);

        Main.getRootLayout().getTop().setVisible(true);
        Main.getRootLayout().getBottom().setVisible(true);

        Label label = (Label) Main.getRootLayout().getBottom().lookup("#labelUser");
        if (profesor != null) {
            label.setText(profesor.getUser());
        } else {
            label.setText("test");
        }

        this.rootLayout = Main.getRootLayout();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../IndexOverview.fxml"));
            AnchorPane indexOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(indexOverview);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


