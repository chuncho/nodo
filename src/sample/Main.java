package sample;

import com.mongodb.async.client.MongoDatabase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import database.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Button acceptButton, cancelButton, returnButton;
    Scene inactiveScene, activeScene;
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MongoDatabase db = mongo.connectDB();
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
        window.show();
    }

}
