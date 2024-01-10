package dev.iesfranciscodelosrios.psp_async_navidad.Controller;

import dev.iesfranciscodelosrios.psp_async_navidad.App;
import dev.iesfranciscodelosrios.psp_async_navidad.Components.card_cardController;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.DAO.RevisionDAO;
import dev.iesfranciscodelosrios.psp_async_navidad.domain.model.Revision;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class RegistroController {
    @FXML
    private VBox container;
    @FXML
    public void initialize(){
        loadData();
    }
    public void loadData(){
        List<Revision> list = RevisionDAO.getInstance().getAllRevisions();

        if(list != null){
            for(Revision r : list){
                System.out.println(r.getId());
                FXMLLoader loader = new FXMLLoader(App.class.getResource("Components/car_card.fxml"));
                try {
                    Node node = loader.load();
                    card_cardController controller = loader.getController();
                    controller.setRevision(r);
                    container.getChildren().add(node);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void setData(){

    }
    @FXML
    public void refrescar(){
        container.getChildren().clear();
        loadData();
    }
}
