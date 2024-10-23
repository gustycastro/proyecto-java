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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private Button btnCancelarTurno; // Botón para cancelar el turno
    @FXML
    private ImageView logoImage;
    @FXML
    private AnchorPane paginaPrincipal;
    @FXML
    private AnchorPane paginaAgregarTurno;
    @FXML
    private AnchorPane paginaMostrarTurno;
    @FXML
    private AnchorPane paginaModificarTurno;

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

        // Cargar el logo
        try {
            Image logo = new Image(getClass().getResourceAsStream("/calendario.svg"));
            logoImage.setImage(logo);
            logoImage.getStyleClass().add("logo-svg"); // Agrega la clase CSS al ImageView
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    //Ir a la página de Agregar Turno
    @FXML
    private void irAgregarTurno() {
        paginaPrincipal.setVisible(false);
        paginaAgregarTurno.setVisible(true);
    }
    //Ir a la página de Modificar Turno
    @FXML
    private void irModificarTurno() {
        paginaPrincipal.setVisible(false);
        paginaModificarTurno.setVisible(true);
    }
    //Ir a la página de Mostrar Turno
    @FXML
    private void irMostrarTurno() {
        paginaPrincipal.setVisible(false);
        paginaMostrarTurno.setVisible(true);
    }
    //Volver a la página principal
    @FXML
    private void volverPaginaPrincipal() {
        paginaAgregarTurno.setVisible(false);
        paginaMostrarTurno.setVisible(false);
        paginaModificarTurno.setVisible(false);
        paginaPrincipal.setVisible(true);
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
        LocalDate selectedDate = datePicker.getValue();
        Medico medicoSeleccionado = listViewMedicos.getSelectionModel().getSelectedItem();

        // Validación de los campos
        if (nombre.isEmpty() || apellido.isEmpty() || dniStr.isEmpty() || edadStr.isEmpty() || selectedDate == null || medicoSeleccionado == null) {
            showAlert("Error", "Por favor, complete todos los campos.");
            return;
        }
        try {
            // Validar que el DNI y la edad sean números
            int dni = Integer.parseInt(dniStr);
            int edad = Integer.parseInt(edadStr);

            // Convertir la fecha a un formato adecuado
            String fecha = selectedDate.toString();

            // Agendar el turno si todo es válido
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            GestionTurnos dbTurnos = new GestionTurnos();
            alert.setTitle("Turno Agendado");
            alert.setHeaderText(null);
            alert.setContentText("Turno agendado para " + nombre + " " + apellido + " el " + fecha + " con " + medicoSeleccionado.getNombre());
            alert.showAndWait();

            // Llamar al método para insertar en la base de datos
            int nuevoId = dbTurnos.obtenerUltimoId() + 1;
            dbTurnos.insertarPacientes(nuevoId, nombre, apellido, edad, fecha, dni, medicoSeleccionado.getNombre());
            dbTurnos.mostrarRegistros();

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
        comboObrasSociales.getSelectionModel().clearSelection();
        comboEspecialidades.getSelectionModel().clearSelection();
        listViewMedicos.getItems().clear();
        datePicker.setValue(null);
    }
    
    //Metodo para cancelar turno
    @FXML
    private void cancelarTurno() {
        Stage cancelarStage = new Stage();
        cancelarStage.initStyle(StageStyle.UTILITY);
        cancelarStage.initModality(Modality.APPLICATION_MODAL);
        GestionTurnos gestion = new GestionTurnos();

        VBox vbox = new VBox(10);
        vbox.setId("cancelarTurnoVBox"); // Añadir ID al VBox
        vbox.getChildren().add(new Text("Ingrese el DNI para cancelar el turno:"));

        TextField dniField = new TextField();
        dniField.setId("dniTextField"); // Añadir ID al TextField
        dniField.setPromptText("Ingrese DNI del paciente");
        vbox.getChildren().add(dniField);

        Button confirmButton = new Button("Eliminar");
        confirmButton.setId("eliminarButton"); // Añadir ID al botón
        confirmButton.setOnAction(e -> {
            try {
                // Obtener el texto del campo y convertirlo a int
                String dniString = dniField.getText();
                int dni = Integer.parseInt(dniString);

                // Lógica para cancelar el turno
                gestion.eliminarTurno(dni); // Pasar el DNI al método eliminarTurno
                cancelarStage.close();
            } catch (NumberFormatException ex) {
                // Manejar el caso donde el DNI no es válido
                System.out.println("El DNI ingresado no es válido.");
            }
        });

        vbox.getChildren().add(confirmButton);

        Scene scene = new Scene(vbox, 300, 200);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm()); // Añadir la hoja de estilos
        cancelarStage.setScene(scene);
        cancelarStage.setTitle("Cancelar Turno");
        cancelarStage.show();
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
