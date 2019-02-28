package com.nodo.view.controllers;

import com.nodo.Main;
import com.nodo.dao.ProfesorDao;
import com.nodo.model.Profesor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginOverviewController implements Initializable {

    private BorderPane rootLayout;

    private Profesor profesor;

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void show() {

        Main.getRootLayout().getTop().setVisible(false);
        Main.getRootLayout().getBottom().setVisible(false);

        this.rootLayout = Main.getRootLayout();

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../LoginOverview.fxml"));
            AnchorPane loginOverview = (AnchorPane) loader.load();

            this.rootLayout.setCenter(loginOverview);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField userTextField;

    @FXML
    private TextField passField;

    @FXML
    private Label lblInfo;

    @FXML
    private Pane panelInfo;

    @FXML
    private void aceptar(ActionEvent event) {
        String user = userTextField.getText();
        String pass = passField.getText();
        panelInfo.setVisible(false);

        if (validForm()) {
            ProfesorDao dao = new ProfesorDao();
            profesor = dao.GetByUser(user);

            if (profesor == null) {
                panelInfo.setVisible(true);
                lblInfo.setText("El usuario no existe");
            } else {
                if (profesor.getPass().equals(pass)) {
                    redirect();
                } else {
                    panelInfo.setVisible(true);
                    lblInfo.setText("Contraseña incorrecta");
                }

            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        userTextField.getStyleClass().remove("error");
        passField.getStyleClass().remove("error");
        panelInfo.setVisible(false);
        redirect();
    }

    private void redirect() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../IndexOverview.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        IndexOverviewController indexController = loader.getController();

        indexController.setProfesor(profesor);
        indexController.show();

    }

    private boolean validForm() {
        boolean validate = true;

        userTextField.getStyleClass().remove("error");
        passField.getStyleClass().remove("error");

        if (userTextField.getLength() == 0) {
            validate = false;
            userTextField.getStyleClass().add("error");
        }

        if (passField.getLength() == 0) {
            validate = false;
            passField.getStyleClass().add("error");
        }

        return validate;
    }


}
