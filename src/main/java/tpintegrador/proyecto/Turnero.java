/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpintegrador.proyecto;

import java.time.DayOfWeek;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import java.time.LocalDate;
import java.util.Iterator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
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
    GestionTurnos bdTurnos = new GestionTurnos();

    @FXML
    private TextField nombreId; //Campo para el nombre del paciente
    @FXML
    private TextField apellidoId; //Campo para el apellido del paciente
    @FXML
    private TextField dniId; //Campo para el DNI del paciente
    @FXML
    private TextField dniIdModificar;
    @FXML
    private TextField edadId; //Campo para la edad del paciente
    @FXML
    private DatePicker fechaId;
    @FXML
    private DatePicker datePicker; //Para seleccionar la fecha del turno
    @FXML
    private ComboBox<Especialidades> comboEspecialidades; //ComboBox para seleccionar especialidad
    @FXML
    private ComboBox<ObraSocial> comboObrasSociales; //ComboBox para seleccionar especialidad
    @FXML
    private ComboBox<String> comboHora;
    @FXML
    private Button btnMostrarMedicos; //Botón para mostrar médicos
    @FXML
    private Button btnAgendarTurno; //Botón para agendar el turno
    @FXML
    private Button btnCancelarTurno; //Botón para cancelar el turno
    @FXML
    private Button btnModificarTurno; //Botón para modificar el turno
    @FXML
    private Button btnTurnoModificado; //Botón para modificar el turno
    @FXML
    private Button btnBuscarPaciente; //Botón para buscar paciente  
    @FXML
    private Button btnBuscarTurno; //Botón para buscar turno
    @FXML
    private AnchorPane paginaPrincipal;
    @FXML
    private AnchorPane paginaAgregarTurno;
    @FXML
    private AnchorPane paginaMostrarTurno;
    @FXML
    private AnchorPane paginaModificarTurno;
    @FXML
    private AnchorPane paginaCancelarTurno;
    @FXML
    private TextArea datosArea;
    @FXML
    private ListView<Medico> listViewMedicos; //ListView para mostrar médicos
    @FXML
    private ListView<Turno> listTurnos; //ListView para mostrar turnos

    //Método para cargar y mostrar la interfaz gráfica
    public void interfazGrafica(Stage interfaz) throws Exception {
        CentroDeSalud cs = new CentroDeSalud("sadasd", 0); //ARREGLAR EL "SASDADA"
        cs.cargarListas();
        //Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/turnero.fxml"));
        Parent root = loader.load();

        //Obtener el controlador
        Turnero turneroController = loader.getController();

        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

        //Configurar la escena
        interfaz.setScene(scene);
        interfaz.setTitle("Sistema de Turnero");
        interfaz.show();

        //Llenar el ComboBox de especialidades
        turneroController.comboEspecialidades.getItems().addAll(cs.getListaEspecialidades());

        //Llenar el ComboBox de obra sociales
        turneroController.comboObrasSociales.getItems().addAll(cs.getListaObraSocial());
        
        
        turneroController.comboHora.getItems().addAll(cs.getListaHoras());
        
        //Manejar el evento de selección de especialidad
        turneroController.btnMostrarMedicos.setOnAction(event -> turneroController.mostrarMedicos());

        //Manejar el evento de agendar turno
        turneroController.btnAgendarTurno.setOnAction(event -> turneroController.agendarTurno());
        
        //Manejar el evento de modificar turno
        turneroController.btnTurnoModificado.setOnAction(event -> turneroController.modificarTurno());
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
    
    //Ir a la página Cancelar Turno
    @FXML
    private void irCancelarTurno() {
        paginaPrincipal.setVisible(false);
        paginaCancelarTurno.setVisible(true);
    }

    //Volver a la página principal
    @FXML
    private void volverPaginaPrincipal() {
        paginaAgregarTurno.setVisible(false);
        paginaMostrarTurno.setVisible(false);
        paginaModificarTurno.setVisible(false);
        paginaCancelarTurno.setVisible(false);
        paginaPrincipal.setVisible(true);
    }

    //Método para mostrar médicos de la especialidad seleccionada
    @FXML
    private void mostrarMedicos() {
        CentroDeSalud cs = new CentroDeSalud("asdasd", 0); //ARREGLAR EL "SASDADA"
        cs.cargarListas();
        Especialidades especialidadSeleccionada = comboEspecialidades.getValue();
        listViewMedicos.getItems().clear(); //Limpiar la lista antes de mostrar
        if (especialidadSeleccionada != null) {
            Iterator<Medico> it = cs.getListaMedicos().iterator();
            while (it.hasNext()) {
                Medico medico = it.next();
                if (medico.getEspecialidad().equals(especialidadSeleccionada)) {
                    listViewMedicos.getItems().add(medico); //Agregar médicos a la ListView
                }
            }
        } else {
            showAlertE("Por favor, seleccione una especialidad.");
        }
    }

    //Método para agendar un turno
    @FXML
    private void agendarTurno() {
        // Obtener los valores de los campos
        String nombre = nombreId.getText();
        String apellido = apellidoId.getText();
        String dniStr = dniId.getText();
        String edadStr = edadId.getText();
        LocalDate selectedDate = datePicker.getValue();
        Medico medicoSeleccionado = listViewMedicos.getSelectionModel().getSelectedItem();
        String horaStr = comboHora.getValue();
        //Validación de los campos
        if (nombre.isEmpty() || apellido.isEmpty() || dniStr.isEmpty() || edadStr.isEmpty() || selectedDate == null || medicoSeleccionado == null || horaStr == null) {
            showAlertE("Por favor, complete todos los campos.");
            return;
        }

        //Validación de la fecha seleccionada (debe ser día hábil y posterior a hoy)
        LocalDate today = LocalDate.now();
        if (selectedDate.isBefore(today) || selectedDate.equals(today)) {
            showAlertE("La fecha debe ser posterior a hoy.");
            return;
        }
        if (selectedDate.getDayOfWeek() == DayOfWeek.SATURDAY || selectedDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            showAlertE("Seleccione un día hábil (lunes a viernes).");
            return;
        }

        try {
            //Validar que el DNI y la edad sean números
            int dni = Integer.parseInt(dniStr);
            int edad = Integer.parseInt(edadStr);

            //Convertir la fecha a un formato adecuado
            String fecha = selectedDate.toString();

            //Agendar el turno si todo es válido
            showAlertC("Turno agendado correctamente");

            //Llamar al método para insertar en la base de datos
            int nuevoId = bdTurnos.obtenerUltimoId() + 1;
            bdTurnos.insertarPacientes(nuevoId, nombre, apellido, edad, fecha, dni, medicoSeleccionado.getNombre(), horaStr);
            bdTurnos.mostrarRegistros();

            limpiarCampos();
        } catch (NumberFormatException e) {
            showAlertE("Por favor, ingrese un número válido para el DNI y la edad.");
        }
    }

    @FXML
    public void modificarTurno() {    // Método que maneja la lógica para buscar y modificar el turno de un paciente
        LocalDate nuevaFecha = fechaId.getValue();
        LocalDate today = LocalDate.now();
        //Obtener el turno seleccionado
        Turno turno = listTurnos.getSelectionModel().getSelectedItem();

        //Verificar que el turno esté seleccionado antes de continuar
        if (turno == null) {
            showAlertE("Seleccione un turno para modificar.");
            return;
        }
        if (nuevaFecha.isBefore(today) || nuevaFecha.equals(today)) {
            showAlertE("La fecha debe ser posterior a hoy.");
            return;
        }

        //Validación: la fecha debe ser un día hábil (lunes a viernes)
        if (nuevaFecha.getDayOfWeek() == DayOfWeek.SATURDAY || nuevaFecha.getDayOfWeek() == DayOfWeek.SUNDAY) {
            showAlertE("Seleccione un día hábil (lunes a viernes).");
            return;
        }

        //Validación: la nueva fecha no debe ser anterior a la fecha actual del turno
        if (nuevaFecha.isBefore(turno.getFecha()) || nuevaFecha.equals(turno.getFecha())) {
            showAlertE("La nueva fecha debe ser posterior a la fecha actual del turno.");
            return;
        }

        turno.setFecha(nuevaFecha);
        bdTurnos.modificarFechaTurno(turno, nuevaFecha.toString());
        showAlertC("Turno modificado correctamente");
    }

    //Metodo para cancelar turno
    @FXML
    private void cancelarTurno() {
        int dni;
        try {
            dni = Integer.parseInt(dniIdModificar.getText().trim());

            //Obtener el turno seleccionado del ListView
            Turno turnoSeleccionado = listTurnos.getSelectionModel().getSelectedItem();
            if (turnoSeleccionado == null) {
                showAlertE("No se ha seleccionado ningún turno para cancelar.");
                return;
            }

            //Extraer la fecha desde el texto del turno seleccionado (suponiendo que el formato es "YYYY-MM-DD - HH:MM AM/PM")
            String fechaTurno = turnoSeleccionado.getFecha().toString(); // Obtiene solo la fecha

            //Lógica para cancelar el turno
            bdTurnos.eliminarTurno(dni, fechaTurno);
            showAlertC("Turno cancelado correctamente.");
        } catch (NumberFormatException ex) {
            showAlertE("El DNI ingresado no es válido.");
        }
    }

    @FXML
    public void buscarTurno() {
        int dni;
        try {
            dni = Integer.parseInt(dniIdModificar.getText().trim());   //Intentar convertir el texto a entero
        } catch (NumberFormatException e) {
            showAlertE("Por favor, introduce un número de DNI válido.");   //Mostrar un mensaje de error si el DNI no es válido
            return;
        }
        //Llama a buscarTurnos y verifica si el DNI existe
        boolean existe = bdTurnos.buscarTurnos(dni, listTurnos);
        if (!existe) {
            showAlertE("El DNI ingresado no existe en la base de datos.");  //Mostrar mensaje de error
        }

    }

    //Método para mostrar alertas de error
    private void showAlertE(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    //Método para mostrar alertas de confirmación
    private void showAlertC(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    //Método para limpiar los campos
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
}
