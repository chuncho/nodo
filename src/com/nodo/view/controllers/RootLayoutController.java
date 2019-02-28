package com.nodo.view.controllers;

import com.nodo.view.controllers.RegistroAsistenciaOverviewController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

import javafx.event.ActionEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class RootLayoutController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {


            /*second = LocalDateTime.now().getSecond();
            minute = LocalDateTime.now().getMinute();
            hour = LocalDateTime.now().getHour();*/
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            labelTime.setText(LocalDateTime.now().format(dtf));
            //labelTime.setText(hour + ":" + (minute) + ":" + second);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private int minute;
    private int hour;
    private int second;

    @FXML
    private Label labelTime;

    @FXML
    private MenuItem itemAsistencia;

    @FXML
    private void asistencias(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../RegistroAsistenciaOverview.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        RegistroAsistenciaOverviewController registroAsistenciaController = loader.getController();
        registroAsistenciaController.show();

    }

}
