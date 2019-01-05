package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nodo Entrenamiento Funcional");

        initRootLayout();



        /*MongoDatabase db = Mongo.connectDB();
        System.out.println(db.getCollection("alumnos"));

        window = primaryStage;
        window.setTitle("NODO - Entrenamiento Funcional.");

        acceptButton = new Button("Aceptar");
        acceptButton.setOnAction(e -> window.setScene(activeScene));
        cancelButton = new Button("Cancelar");

        VBox layout = new VBox(20);
        layout.getChildren().addAll(acceptButton, cancelButton);

        inactiveScene = new Scene(layout, 300, 300);

        returnButton = new Button("Volver");
        returnButton.setOnAction(e -> window.setScene(inactiveScene));

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(returnButton);
        activeScene = new Scene(layout2, 300, 300);

        window.setScene(inactiveScene);
        window.show();*/
    }


    /** Levanta Layout. */
    public void initRootLayout() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
