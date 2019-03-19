package com.nodo.view.controllers;

import com.nodo.dao.AlumnoDao;
import com.nodo.dao.AsistenciaDao;
import com.nodo.dao.CuotaDao;
import com.nodo.dao.RutinaDao;
import com.nodo.model.Alumno;
import com.nodo.model.Asistencia;
import com.nodo.model.Rutina;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.util.Callback;

public class RegistroAsistenciaOverviewController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // force dni text field only type numbers
        dniTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    dniTextField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        nameCol = new TableColumn<Alumno, String>("Nombre");
        nameCol.setCellValueFactory(new PropertyValueFactory<Alumno, String>("nombre"));
        //actionsCol = new TableColumn<>("Acciones");
        tableAlumnosActivos.getColumns().add(nameCol);
        //tableAlumnosActivos.getColumns().add(actionsCol);

        alumnosActivos = new ArrayList<Alumno>();

    }

    private BorderPane guestLayout;

    private Stage asistenciaStage;

    @FXML
    private TextField dniTextField;

    @FXML
    private TableView<Alumno> tableAlumnosActivos;

    /*
        private TableColumn<Alumno, Void> actionsCol;*/
    private TableColumn<Alumno, String> nameCol;

    private List<Alumno> alumnosActivos;

    public void show() {

        asistenciaStage = new Stage();
        asistenciaStage.setTitle("Nodo Entrenamiento Funcional - Control de asistencias");
        asistenciaStage.getIcons().add(new Image(getClass().getResourceAsStream("../images/icon.png")));
        asistenciaStage.setResizable(false);

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../GuestLayout.fxml"));
            guestLayout = (BorderPane) loader.load();

            Scene scene = new Scene(guestLayout);
            scene.getStylesheets().add(getClass().getResource("../css/global.css").toExternalForm());
            asistenciaStage.setScene(scene);
            asistenciaStage.show();

            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("../RegistroAsistenciaOverview.fxml"));
            AnchorPane registroAsistenciaOverview = (AnchorPane) loader2.load();

            this.guestLayout.setCenter(registroAsistenciaOverview);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void ingresar(ActionEvent event) {
        if (validForm()) {
            int dni = Integer.valueOf(dniTextField.getText());
            AlumnoDao alumnoDao = new AlumnoDao();
            Alumno alumno = alumnoDao.GetByDni(dni);

            // TODO validacion si ya esta logueado
            if (alumno == null) {
                System.out.println("no existe");
            } else {

                showAlumno(alumno);

                CuotaDao cuotaDao = new CuotaDao();
                String cuotaGenerada = cuotaDao.GenerarCuotas(alumno);

                // asentar asistencia de alumno
                AsistenciaDao asistenciaDao = new AsistenciaDao();
                Asistencia asistencia = new Asistencia();
                asistencia.setAlumno(alumno);
                String asistenciaGenerada = asistenciaDao.Insert(asistencia);

                System.out.println("asistencia generada: " + asistenciaGenerada);

                Map<String, Object> alerta = cuotaDao.AlertaCuotas(alumno);

                System.out.println(alerta);

            }
        }
    }


    private boolean validForm() {
        boolean validate = true;

        dniTextField.getStyleClass().remove("error");

        if (dniTextField.getLength() == 0) {
            validate = false;
            dniTextField.getStyleClass().add("error");
        }

        return validate;
    }

    private void showAlumno(Alumno alumno) {

        alumnosActivos.add(alumno);
        addDeleteButton();
        addRutinaButton();
        tableAlumnosActivos.getItems().add(alumno);

    }

    private void addDeleteButton() {
        TableColumn<Alumno, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Alumno, Void>, TableCell<Alumno, Void>> cellFactory = new Callback<TableColumn<Alumno, Void>, TableCell<Alumno, Void>>() {
            @Override
            public TableCell<Alumno, Void> call(final TableColumn<Alumno, Void> param) {
                final TableCell<Alumno, Void> cell = new TableCell<Alumno, Void>() {

                    private final Button btnDelete = new Button("-");

                    {
                        btnDelete.setOnAction((ActionEvent event) -> {
                            Alumno data = getTableView().getItems().get(getIndex());
                            tableAlumnosActivos.getItems().remove(data);
                            alumnosActivos.remove(data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnDelete);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableAlumnosActivos.getColumns().add(colBtn);

    }

    private void addRutinaButton() {
        TableColumn<Alumno, Void> colBtn = new TableColumn("");

        Callback<TableColumn<Alumno, Void>, TableCell<Alumno, Void>> cellFactory = new Callback<TableColumn<Alumno, Void>, TableCell<Alumno, Void>>() {
            @Override
            public TableCell<Alumno, Void> call(final TableColumn<Alumno, Void> param) {
                final TableCell<Alumno, Void> cell = new TableCell<Alumno, Void>() {

                    private final Button btnRutina = new Button("+");

                    {
                        btnRutina.setOnAction((ActionEvent event) -> {
                            Alumno data = getTableView().getItems().get(getIndex());
                            showRutina(data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnRutina);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableAlumnosActivos.getColumns().add(colBtn);

    }


    private void showRutina(Alumno alumno) {
        RutinaDao rutinaDao = new RutinaDao();
        Rutina rutina = rutinaDao.GetActiveByAlumno(alumno);

        System.out.println(rutina.getEjercicios());

    }

}
