package com.nodo.view;

import com.nodo.Main;
import com.nodo.model.Profesor;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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

        this.rootLayout = Main.getRootLayout();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("IndexOverview.fxml"));
            AnchorPane indexOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(indexOverview);

            System.out.println(profesor.getNombre());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


