package com.nodo;

import com.mongodb.MongoClient;
import com.nodo.view.controllers.LoginOverviewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static Stage primaryStage;
    private static BorderPane rootLayout;

    private static Morphia morphia = new Morphia();
    private static Datastore ds = morphia.createDatastore(new MongoClient(), "dbnodo");

    public static Datastore getDs() {return ds; }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static BorderPane getRootLayout() { return rootLayout; }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nodo Entrenamiento Funcional");
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("view/images/icon.png")));

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(getClass().getResource("view/css/global.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

            LoginOverviewController login = new LoginOverviewController();
            login.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
