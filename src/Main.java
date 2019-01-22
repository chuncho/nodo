import com.nodo.dao.MainDao;
import com.nodo.models.Turno;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.nodo.models.Alumno;
import java.util.List;

import static javax.swing.text.StyleConstants.Size;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Nodo Entrenamiento Funcional");


        MainDao dao = new MainDao();
        List<Alumno> lista = dao.GetListAlumnos();
        System.out.println(lista.size());

        for(Alumno a :lista) {

            System.out.println(a.getClase().getNombre());

        }

        initRootLayout();

    }


    /** Levanta Layout. */
    public void initRootLayout() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
