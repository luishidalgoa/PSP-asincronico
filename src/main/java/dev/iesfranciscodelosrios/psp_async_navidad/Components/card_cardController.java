package dev.iesfranciscodelosrios.psp_async_navidad.Components;

import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class card_cardController {

    @FXML
    private Label label_estado;
    @FXML
    private Label label_fecha;
    @FXML
    private Label label_marca;
    @FXML
    private Label label_mat2;
    @FXML
    private Label label_mat;
    @FXML
    private Label label_modelo;
    @FXML
    private Label label_antideslizante;
    @FXML
    private Label label_antirobo;
    @FXML
    private Label label_frenado;
    @FXML
    private Label label_luces;
    @FXML
    private Label label_limpiaparabrisas;
    @FXML
    private Label label_cinturones;
    @FXML
    private Label label_deposito;
    @FXML
    private Label label_fugas;
    @FXML
    private Label label_volante;
    @FXML
    private Label label_direccion;
    @FXML
    private Label label_amortiguacion;
    @FXML
    private Label label_emisiones;

    private Revision revision;

    // Constructor
    public card_cardController() {
    }

    // Método para configurar la revisión en el controlador
    public void setRevision(Revision revision) {
        this.revision = revision;
        // Actualizar las etiquetas con los datos de la revisión
        label_estado.setText(String.valueOf(revision.isEstado()));
        label_fecha.setText(revision.getFecha().toString());
        label_marca.setText(revision.getIdentificacion().getCoche().getMarca().toString());
        label_mat.setText(revision.getIdentificacion().getCoche().getMatricula());
        label_modelo.setText(revision.getIdentificacion().getCoche().getModelo());
        label_antideslizante.setText(String.valueOf(revision.getInterior().isAntideslizante()));
        label_antirobo.setText(String.valueOf(revision.getInterior().isAntirobo()));
        label_frenado.setText(String.valueOf(revision.getInterior().isFrenado()));
        label_luces.setText(String.valueOf(revision.getExterior().isTestLuces()));
        label_limpiaparabrisas.setText(String.valueOf(revision.getExterior().isTestLimpiaParabrisas()));
        label_cinturones.setText(String.valueOf(revision.getExterior().isTestCinturones()));
        label_deposito.setText(String.valueOf(revision.getExterior().isTestDeposito()));
        label_fugas.setText(String.valueOf(revision.getAlineacion().isTestFugas()));
        label_volante.setText(String.valueOf(revision.getAlineacion().isVolante()));
        label_direccion.setText(String.valueOf(revision.getAlineacion().isTestDireccion()));
        label_amortiguacion.setText(String.valueOf(revision.getAlineacion().isAmortiguacion()));
        label_emisiones.setText(String.valueOf(revision.getEmisores().isTestEmisiones()));
        label_mat2.setText(revision.getIdentificacion().getCoche().getMatricula());
    }
}