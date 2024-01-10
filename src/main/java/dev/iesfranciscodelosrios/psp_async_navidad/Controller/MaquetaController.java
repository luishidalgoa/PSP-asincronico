package dev.iesfranciscodelosrios.psp_async_navidad.Controller;

import dev.iesfranciscodelosrios.psp_async_navidad.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MaquetaController {
    @FXML
    private AnchorPane uno;
    @FXML
    private AnchorPane dos;

    public void initialize(){
        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Home.fxml"));
            try {
                Node node = fxmlLoader.load();
                HomeController homeController = fxmlLoader.getController();
                uno.getChildren().add(node);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Registro.fxml"));
            try {
                Node node = fxmlLoader.load();
                RegistroController registro = fxmlLoader.getController();
                dos.getChildren().add(node);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
