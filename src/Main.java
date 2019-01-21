import com.nodo.dao.MainDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.nodo.models.Alumno;
import com.nodo.models.Profesor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
        List<Profesor> listaP = dao.GetListProfesores();

        for(Alumno a :lista) {

            for(Profesor p: listaP){
                System.out.println(p.getNombre());
            }

            System.out.println(a.getNombre());
            System.out.println(a.getDni());
            System.out.println(a.getFechaCreacion());
        }


        initRootLayout();

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
