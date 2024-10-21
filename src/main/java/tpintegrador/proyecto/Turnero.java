/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert;
import java.time.LocalDate;
import java.util.Iterator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 *
 * @author HP
 */
public class Turnero {

    //Atributos
    @FXML
    private TextField nombreId; // Campo para el nombre del paciente
    @FXML
    private TextField apellidoId; // Campo para el apellido del paciente
    @FXML
    private TextField dniId; // Campo para el DNI del paciente
    @FXML
    private TextField edadId; // Campo para la edad del paciente
    @FXML
    private TextField historiaClinicaId; // Campo para la historia clínica del paciente
    @FXML
    private ComboBox<Especialidades> comboEspecialidades; // ComboBox para seleccionar especialidad
    @FXML
    private ComboBox<ObraSocial> comboObrasSociales; // ComboBox para seleccionar especialidad
    @FXML
    private ListView<Medico> listViewMedicos; // ListView para mostrar médicos
    @FXML
    private DatePicker datePicker; // Para seleccionar la fecha del turno
    @FXML
    private Button btnMostrarMedicos; // Botón para mostrar médicos
    @FXML
    private Button btnAgendarTurno; // Botón para agendar el turno
    
    
    // Método para cargar y mostrar la interfaz gráfica
    public void interfazGrafica(Stage interfaz) throws Exception {
        CentroDeSalud cs = new CentroDeSalud("sadasd", 0);
        cs.cargarListas();
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/turnero.fxml"));
        Parent root = loader.load();

        // Obtener el controlador
        Turnero turneroController = loader.getController();
        
        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        
        // Configurar la escena
        interfaz.setScene(scene);
        interfaz.setTitle("Sistema de Turnero");
        interfaz.show();

        // Llenar el ComboBox de especialidades
        turneroController.comboEspecialidades.getItems().addAll(cs.getListaEspecialidades());
        
        // Llenar el ComboBox de obra sociales
        turneroController.comboObrasSociales.getItems().addAll(cs.getListaObraSocial());

        // Manejar el evento de selección de especialidad
        turneroController.btnMostrarMedicos.setOnAction(event -> turneroController.mostrarMedicos());

        // Manejar el evento de agendar turno
        turneroController.btnAgendarTurno.setOnAction(event -> turneroController.agendarTurno());
    }

    // Método para mostrar médicos de la especialidad seleccionada
    @FXML
    private void mostrarMedicos() {
        CentroDeSalud cs = new CentroDeSalud("asdasd", 0);
        cs.cargarListas();
        Especialidades especialidadSeleccionada = comboEspecialidades.getValue();
        listViewMedicos.getItems().clear(); // Limpiar la lista antes de mostrar
        if (especialidadSeleccionada != null) {
        Iterator<Medico> it = cs.getListaMedicos().iterator();
        while (it.hasNext()) {
            Medico medico = it.next();
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
        // Obtener los valores de los campos
        String nombre = nombreId.getText();
        String apellido = apellidoId.getText();
        String dniStr = dniId.getText();
        String edadStr = edadId.getText();
        String historiaClinica = historiaClinicaId.getText();
        LocalDate selectedDate = datePicker.getValue();
        Medico medicoSeleccionado = listViewMedicos.getSelectionModel().getSelectedItem();

        // Validación de los campos
        if (nombre.isEmpty() || apellido.isEmpty() || dniStr.isEmpty() || edadStr.isEmpty() || historiaClinica.isEmpty() || selectedDate == null || medicoSeleccionado == null) {
            showAlert("Error", "Por favor, complete todos los campos.");
            return;
        }
        // Validar que el DNI y la edad sean números
        try {
            int dni = Integer.parseInt(dniStr);
            int edad = Integer.parseInt(edadStr);

            // Agendar el turno si todo es válido
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Turno Agendado");
            alert.setHeaderText(null);
            alert.setContentText("Turno agendado para " + nombre + " " + apellido + " el " + selectedDate + " con " + medicoSeleccionado.getNombre());
            alert.showAndWait();
            limpiarCampos();
    } catch (NumberFormatException e) {
        showAlert("Error", "Por favor, ingrese un número válido para el DNI y la edad.");
    }
  }
    // Método para limpiar los campos
    private void limpiarCampos() {
        // Limpia todos los campos de entrada
        nombreId.clear();
        apellidoId.clear();
        dniId.clear();
        edadId.clear();
        historiaClinicaId.clear();
        comboObrasSociales.getSelectionModel().clearSelection();
        comboEspecialidades.getSelectionModel().clearSelection();
        listViewMedicos.getItems().clear();
        datePicker.setValue(null);
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
