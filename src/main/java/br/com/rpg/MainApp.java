package br.com.rpg;

import br.com.rpg.view.GerenciadorTela;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage palcoPrincipal){
        try {
            Font.loadFont(getClass().getResourceAsStream("/fonts/fonte_rpg.ttf"), 10);
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