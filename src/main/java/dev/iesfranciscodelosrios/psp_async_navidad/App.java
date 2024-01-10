package dev.iesfranciscodelosrios.psp_async_navidad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;

public class App<T> extends Application {
    private static Scene scene;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(new FXMLLoader(getUrlResource("","Maqueta")).load(),1400,920);//,1400, 920
        stage.setTitle("PSP Async Navidad");
        stage.setScene(scene);
        stage.show();
    }

    public static <T> T setRoot(String route,String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getUrlResource(route,fxml));
            scene.setRoot(fxmlLoader.load());
            return fxmlLoader.getController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static URL getUrlResource(String route, String fxml) {
        return App.class.getResource(route+fxml+".fxml");
    }
    public static Scene newStage(Parent p) throws IOException {
        Stage stage2=new Stage();
        Scene scene2= new Scene(p);
        stage2.setScene(scene2);
        stage2.show();
        stage2.setOnCloseRequest((WindowEvent event) -> {
            // Evitar que la ventana se cierre directamente
            event.consume();
        });
        return scene2;
    }
    public static Scene getScene() {
        return scene;
    }
}
