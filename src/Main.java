import com.nodo.dao.*;
import com.nodo.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;
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

        /*AlumnoDao dao = new AlumnoDao();
        Alumno alumno = dao.GetByDni(33313023);

        System.out.println(alumno.getNombre());

        AsistenciaDao asisDao = new AsistenciaDao();
        List<Asistencia> listA = asisDao.GetByAlumnos(alumno);

        for (Asistencia as : listA) {
            System.out.println(as.getFecha());
        }

        try {
            String sDate1="2018-01-04";
            Date desde=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);

            String sDate2="2018-01-06";
            Date hasta=new SimpleDateFormat("yyyy-MM-dd").parse(sDate2);

            List<Asistencia> listB = asisDao.GetByFecha(desde, hasta);

            for (Asistencia as : listB) {
                System.out.println(as.getFecha());
            }

        } catch (Exception e) {
            System.out.println(e);
        }*/


        /*CuotaDao dao = new CuotaDao();
        List<Cuota> lista = dao.GetImpagas();

        for(Cuota c : lista) {
            System.out.println(c.getAlumno().getNombre());
        }*/

        /*RutinaDao dao = new RutinaDao();
        List<Rutina> lista = dao.GetVencidas();

        for(Rutina r : lista) {
            System.out.println(r.getVencimiento());
        }*/

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
