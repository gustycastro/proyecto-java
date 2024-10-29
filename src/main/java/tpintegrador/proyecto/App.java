package tpintegrador.proyecto;

import javafx.application.Application;
import javafx.stage.Stage;
//import java.sql.*;


public class App extends Application {
    
    @Override
    public void start(Stage interfaz)throws Exception{
        Turnero turnero = new Turnero();
        turnero.interfazGrafica(interfaz);
        GestionTurnos dbTurnos = new GestionTurnos();
        dbTurnos.mostrarRegistros();
    }

    public static void main(String[] args) {
         GestionTurnos dbTurnos = new GestionTurnos();
         dbTurnos.conexion();
         launch(args);
         dbTurnos.mostrarRegistros();
    }
  }
