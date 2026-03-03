package br.com.rpg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage palcoPrincipal) {
        Label textoBoasVindas = new Label("O motor gráfico está funcionando!");
        StackPane layoutCentral = new StackPane(textoBoasVindas);
        Scene cena = new Scene(layoutCentral, 800, 600);
        palcoPrincipal.setTitle("Meu RPG Épico");
        palcoPrincipal.setScene(cena);
        palcoPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}