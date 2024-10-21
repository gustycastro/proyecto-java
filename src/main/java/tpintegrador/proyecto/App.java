package tpintegrador.proyecto;

import javafx.application.Application;
import javafx.stage.Stage;
import java.sql.*;


public class App extends Application {
    
    @Override
    public void start(Stage interfaz)throws Exception{
        Turnero turnero = new Turnero();
        turnero.interfazGrafica(interfaz);

    }

    public static void main(String[] args) {
        
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test01.sqlite");

            if (conn != null)
		System.out.println("Conexión a base de datos ... Ok");
            else
                System.out.println("Conexión a base de datos: problemas!");

           conn.close();

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
