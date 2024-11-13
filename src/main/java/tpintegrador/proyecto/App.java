package tpintegrador.proyecto;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage interfaz) throws Exception {
        //Crea una instancia de la clase Turnero que es responsable de manejar la lógica del turno
        Turnero turnero = new Turnero();

        //Llama al método 'interfazGrafica' de la clase Turnero para configurar la interfaz gráfica
        //El parámetro 'interfaz' es el Stage principal de la aplicación
        turnero.interfazGrafica(interfaz);
    }

    public static void main(String[] args) {
        //Crea una instancia de la clase GestionTurnos, que se encarga de manejar la conexión a la base de datos
        GestionTurnos dbTurnos = new GestionTurnos();

        //Llama al método 'conexion' para establecer la conexión con la base de datos de turnos
        dbTurnos.conexion();

        //Llama al método 'launch' que inicia la aplicación JavaFX
        //Este método es necesario para arrancar la interfaz gráfica
        launch(args);
    }
}
