package br.com.rpg;

import br.com.rpg.view.GerenciadorTela;
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
    public void start(Stage palcoPrincipal){
        try {
            GerenciadorTela.setPalcoInicial(palcoPrincipal);
            GerenciadorTela.trocarTela("MenuPrincipal");
            palcoPrincipal.setTitle("RPG");
            palcoPrincipal.show();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}