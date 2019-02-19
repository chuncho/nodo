package com.nodo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;
    public BorderPane rootLayout;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nodo Entrenamiento Funcional");
        this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("view/images/icon.png")));

        initRootLayout();
        showLoginOverview();

    }

    /**
     * Levanta Layout.
     */
    public void initRootLayout() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add(getClass().getResource("view/css/global.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showLoginOverview() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/LoginOverview.fxml"));
            AnchorPane loginOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(loginOverview);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
