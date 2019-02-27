package com.nodo.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;

import javafx.event.ActionEvent;

import java.io.IOException;

public class RootLayoutController {

    @FXML
    private MenuItem itemAsistencia;

    @FXML
    private void asistencias(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RegistroAsistenciaOverview.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RegistroAsistenciaOverviewController registroAsistenciaController = loader.getController();
        registroAsistenciaController.show();

    }

}
