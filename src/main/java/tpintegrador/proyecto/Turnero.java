/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.util.ArrayList;

public class Turnero {

    // Listas para médicos y especialidades
    private ArrayList<Medico> listaMedicos;
    private ArrayList<Especialidades> listaEspecialidades;

    @FXML
    private ComboBox<Especialidades> comboEspecialidades; // ComboBox para seleccionar especialidad
    @FXML
    private ListView<Medico> listViewMedicos; // ListView para mostrar médicos
    @FXML
    private DatePicker datePicker; // Para seleccionar la fecha del turno
    @FXML
    private Button btnMostrarMedicos; // Botón para mostrar médicos
    @FXML
    private Button btnAgendarTurno; // Botón para agendar el turno

    public Turnero() {
        listaMedicos = new ArrayList<>();
        listaEspecialidades = new ArrayList<>();

        // Llenar listas de médicos y especialidades
        llenarDatosDeEjemplo();
    }

    // Método para llenar listas con datos de ejemplo
    private void llenarDatosDeEjemplo() {
        Especialidades cardiologia = new Especialidades("Cardiología");
        Especialidades pediatria = new Especialidades("Pediatría");

        listaEspecialidades.add(cardiologia);
        listaEspecialidades.add(pediatria);

        listaMedicos.add(new Medico(cardiologia, "12345", "9:00-17:00", "Dr. Juan Pérez", "Pérez", 12345678, 40));
        listaMedicos.add(new Medico(pediatria, "67890", "9:00-17:00", "Dra. Ana Gómez", "Gómez", 87654321, 35));
    }

    // Método para cargar y mostrar la interfaz gráfica
    public void interfazGrafica(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("turnero.fxml"));
        Parent root = loader.load();

        // Obtener el controlador
        Turnero turneroController = loader.getController();

        // Configurar la escena
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Sistema de Turnero");
        primaryStage.show();

        // Llenar el ComboBox de especialidades
        turneroController.comboEspecialidades.getItems().addAll(turneroController.listaEspecialidades);

        // Manejar el evento de selección de especialidad
        turneroController.btnMostrarMedicos.setOnAction(event -> turneroController.mostrarMedicos());

        // Manejar el evento de agendar turno
        turneroController.btnAgendarTurno.setOnAction(event -> turneroController.agendarTurno());

    }

    // Método para mostrar médicos de la especialidad seleccionada
    @FXML
    private void mostrarMedicos() {
        Especialidades especialidadSeleccionada = comboEspecialidades.getValue();
        listViewMedicos.getItems().clear(); // Limpiar la lista antes de mostrar

        if (especialidadSeleccionada != null) {
            for (Medico medico : listaMedicos) {
                if (medico.getEspecialidad().equals(especialidadSeleccionada)) {
                    listViewMedicos.getItems().add(medico); // Agregar médicos a la ListView
                }
            }
        } else {
            showAlert("Error", "Por favor, seleccione una especialidad.");
        }
    }

    // Método para agendar un turno
    @FXML
    private void agendarTurno() {
        LocalDate selectedDate = datePicker.getValue();
        if (selectedDate != null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Turno Agendado");
            alert.setHeaderText(null);
            alert.setContentText("Turno agendado para el: " + selectedDate);
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Fecha no seleccionada");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione una fecha para agendar el turno.");
            alert.showAndWait();
        }
    }

    // Método para mostrar alertas
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
