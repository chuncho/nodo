import com.nodo.dao.AlumnoDao;
import com.nodo.dao.ProfesorDao;
import com.nodo.models.Alumno;
import com.nodo.models.Profesor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
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

        ProfesorDao dao = new ProfesorDao();
        Profesor profe = dao.GetByUser("martin");

        System.out.println(profe.getUltimaModificacion());

        profe.setNombre("Martin");

        dao.Update(profe);

        profe = dao.GetByUser("martin");

        System.out.println(profe.getUltimaModificacion());

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
