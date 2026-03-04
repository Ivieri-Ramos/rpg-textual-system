package br.com.rpg.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuPrincipalControllerFX {
    /**
     * Quando o jogador clica no botão do menu principal "Novo Jogo"
     */
    @FXML
    protected void onBotaoNovoJogoClick(ActionEvent event){
        try {
            Parent local = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/CriarNovoPersonagem.fxml")));
            Stage palco = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene novaCena = new Scene(local, 800, 600);
            palco.setScene(novaCena);
        }
        catch (IOException e) {
            System.err.println("Erro ao abrir fxml");
            e.printStackTrace();
        }

    }

    @FXML
    protected void onBotaoSairJogoClick() {
        Platform.exit();
    }
}
