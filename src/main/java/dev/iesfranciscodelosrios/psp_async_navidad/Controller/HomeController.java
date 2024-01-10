package dev.iesfranciscodelosrios.psp_async_navidad.Controller;

import dev.iesfranciscodelosrios.psp_async_navidad.Services.Simulacion;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO.CocheDAO;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.enums.Marca;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.time.LocalDate;

public class HomeController {

    @FXML
    private TextField input_mat;
    @FXML
    private Label pista;

    @FXML
    private Button btnSimulacion;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField textFieldModelo;

    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label info;


    @FXML
    private void initialize() {

        // Configurar el ComboBox con algunos valores de ejemplo
        for (Marca marca : Marca.values()) {
            comboBox.getItems().add(marca.toString());
        }
    }
    @FXML
    private void iniciarSimulacion() {
        // Obtener datos de los campos de texto y ComboBox
        String matricula = input_mat.getText();
        String marca = comboBox.getValue();
        String modelo = textFieldModelo.getText();


        Coche coche = new Coche(matricula, Marca.valueOf(marca), modelo);
        CocheDAO.getInstance().addCoche(coche);
        coche = CocheDAO.getInstance().getCocheByMat(coche.getMatricula());
        // Crear un objeto de revisión con los datos del vehículo
        Revision revision = new Revision(coche);
        // Iniciar la simulación y obtener el número total de pruebas realizadas
        revision.getIdentificacion().getCoche().run();
        new Thread(new Simulacion(revision,progressBar)).start();


        pista.setText("Se asigno la pista: "+ revision.getIdentificacion().getCoche().pista.numero);
        // Actualizar la barra de progreso basada en el progreso de la revisión
    }

    private void actualizarBarraProgreso() {
    }
}
