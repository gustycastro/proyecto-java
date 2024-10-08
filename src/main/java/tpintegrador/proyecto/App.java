package tpintegrador.proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("turnero.fxml"));
        primaryStage.setTitle("Agendar Turno");
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        
        GestionTurnos gestor = new GestionTurnos();
        Paciente laureano = new Paciente("Laureano", "Petri" ,44904736,21);
        gestor.agregarTurno(laureano);
    }
}