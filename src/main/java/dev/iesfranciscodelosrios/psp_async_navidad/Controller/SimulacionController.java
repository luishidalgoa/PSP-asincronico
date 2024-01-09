package dev.iesfranciscodelosrios.psp_async_navidad.Controller;

import dev.iesfranciscodelosrios.psp_async_navidad.Services.Simulacion;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class SimulacionController {

    @FXML
    private TextField txtMatricula;

    @FXML
    private Button btnIniciarSimulacion;

    @FXML
    private ProgressBar progressBar;

    private Simulacion simulacion;
    private static final int NUMERO_TOTAL_PRUEBAS = 5; // Ajusta esto según el número total de pruebas en tu simulación

    @FXML
    private void initialize() {
        // Método llamado después de cargar la interfaz.
        // Puedes realizar configuraciones adicionales aquí.

        // Inicializar la simulación
        simulacion = Simulacion.getInstance();

        // Configurar el evento del botón
        btnIniciarSimulacion.setOnAction(event -> iniciarSimulacion());
    }

    private void iniciarSimulacion() {
        // Obtener la matrícula del vehículo desde el campo de texto
        String matricula = txtMatricula.getText();

        // Crear un objeto de revisión con la matrícula
        Revision revision = new Revision(matricula);

        // Iniciar la simulación y obtener el número total de pruebas realizadas
        int totalPruebas = simulacion.startSimulacion(revision);

        // Actualizar la barra de progreso basada en el progreso de la revisión
        actualizarBarraProgreso(totalPruebas);
    }

    private void actualizarBarraProgreso(int totalPruebas) {
        // Actualizar la barra de progreso según el número total de pruebas
        double progreso = (double) totalPruebas / NUMERO_TOTAL_PRUEBAS;
        progressBar.setProgress(progreso);

        // Puedes realizar acciones adicionales según el progreso, si es necesario.
    }
}
