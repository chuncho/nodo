package com.nodo.view;

import com.nodo.Main;
import com.nodo.dao.ProfesorDao;
import com.nodo.model.Profesor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginOverviewController {

    private Main main;

    @FXML
    private TextField userTextField;

    @FXML
    private TextField passField;

    @FXML
    private void aceptar(ActionEvent event) {
        String user = userTextField.getText();
        String pass = passField.getText();

        if (validForm()) {
            ProfesorDao dao = new ProfesorDao();
            Profesor profesor = dao.GetByUser(user);

            if (profesor == null) {
                System.out.println("El usuario ingresado no existe");
            } else {
                if (profesor.getPass().equals(pass)) {
                    System.out.println("Bienvenido");
                } else {
                    System.out.println("Contraseña incorrecta");
                }

            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event){
        userTextField.getStyleClass().remove("error");
        passField.getStyleClass().remove("error");
    }

    private boolean validForm(){
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
