package br.com.rpg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;

public class MainApp extends Application {

    @Override
    public void start(Stage palcoPrincipal) throws Exception{
        URL caminhoFXML = getClass().getResource("/fxml/MenuPrincipal.fxml");
        if (caminhoFXML == null) {
            throw new RuntimeException("Verifique a URL se está apontando corretamente ao FXML");
        }
        Parent layoutCentral = FXMLLoader.load(caminhoFXML);
        Scene cena = new Scene(layoutCentral, 800, 600);
        palcoPrincipal.setTitle("Meu RPG Épico");
        palcoPrincipal.setScene(cena);
        palcoPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}