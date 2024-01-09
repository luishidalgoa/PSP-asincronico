package dev.iesfranciscodelosrios.psp_async_navidad.Controller;

import dev.iesfranciscodelosrios.psp_async_navidad.Services.Simulacion;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class HomeController {

    @FXML
    private TextField input_mat;

    @FXML
    private Button btnSimulacion;

    @FXML
    private ComboBox<String> comboBoxMarca;

    @FXML
    private TextField textFieldModelo;

    @FXML
    private ProgressBar progressBar;

    private Simulacion simulacion;

    @FXML
    private void initialize() {
        // Método llamado después de cargar la interfaz.
        // Puedes realizar configuraciones adicionales aquí.

        // Inicializar la simulación
        simulacion = Simulacion.getInstance();

        // Configurar el ComboBox con algunos valores de ejemplo
        comboBoxMarca.getItems().addAll("Marca1", "Marca2", "Marca3");

        // Configurar el evento del botón de simulación
        btnSimulacion.setOnAction(event -> iniciarSimulacion());
    }

    private void iniciarSimulacion() {
        // Obtener datos de los campos de texto y ComboBox
        String matricula = input_mat.getText();
        String marca = comboBoxMarca.getValue();
        String modelo = textFieldModelo.getText();

        // Crear un objeto de revisión con los datos del vehículo
        Revision revision = new Revision(matricula, marca, modelo);

        // Iniciar la simulación y obtener el número total de pruebas realizadas
        int totalPruebas = simulacion.startSimulacion(revision);

        // Actualizar la barra de progreso basada en el progreso de la revisión
        actualizarBarraProgreso(totalPruebas);
    }

    private void actualizarBarraProgreso(int totalPruebas) {
        // Actualizar la barra de progreso según el número total de pruebas
        double progreso = (double) totalPruebas / Simulacion.NUMERO_TOTAL_PRUEBAS;
        progressBar.setProgress(progreso);

        // Puedes realizar acciones adicionales según el progreso, si es necesario.
    }
}
