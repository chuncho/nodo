package com.nodo.view;

import com.nodo.Main;
import com.nodo.dao.ProfesorDao;
import com.nodo.model.Profesor;
import com.nodo.utils.Encrypter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginOverviewController {

    private Main main;

    @FXML
    private TextField userTextField;

    @FXML
    private TextField passField;

    @FXML
    private Button aceptarButton;

    @FXML
    private Button cancelarButton;

    @FXML
    private void aceptar(ActionEvent event) {
        String user = userTextField.getText();
        String pass = passField.getText();

        ProfesorDao dao = new ProfesorDao();
        Profesor profesor = dao.GetByUser(user);

        if (profesor == null) {
            System.out.println("El usuario ingresado no existe");
        } else {
            System.out.println(profesor.getPass());
            System.out.println(pass);
            if (profesor.getPass().equals(pass)) {
                System.out.println("Bienvenido");
            } else {
                System.out.println("Contraseña incorrecta");
            }

        }


    }


}
