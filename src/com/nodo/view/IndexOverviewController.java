package com.nodo.view;

import com.nodo.Main;
import com.nodo.model.Profesor;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class IndexOverviewController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

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
        Main.getPrimaryStage().setMaxHeight(800);
        Main.getPrimaryStage().setMaxWidth(1200);
        Main.getPrimaryStage().setMaximized(true);

        Main.getRootLayout().getTop().setVisible(true);
        Main.getRootLayout().getBottom().setVisible(true);

        Label label = (Label) Main.getRootLayout().getBottom().lookup("#labelUser");
        label.setText(profesor.getUser());

        this.rootLayout = Main.getRootLayout();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("IndexOverview.fxml"));
            AnchorPane indexOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(indexOverview);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


