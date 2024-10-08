package tpintegrador.proyecto;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("turnero.fxml"));
        primaryStage.setTitle("Agendar Turno");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        
        Connection conn = null;
        try {
            //cargar el driver
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test01.sqlite");

            if (conn != null)
		System.out.println("Conexión a base de datos ... Ok");
            else
                System.out.println("Conexión a base de datos: problemas!");

           conn.close();        //cerrar la BD

        }
        catch (SQLException a) {
            System.out.println(a);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        
        launch(args);
    }
  }
