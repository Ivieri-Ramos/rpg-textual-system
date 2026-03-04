package br.com.rpg.controller;

import br.com.rpg.view.GerenciadorTela;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MenuPrincipalControllerFX {
    /**
     * Quando o jogador clica no botão do menu principal "Novo Jogo",
     * direciona o usuário para criar um novo herói.
     */
    @FXML
    protected void onBotaoNovoJogoClick(){
        GerenciadorTela.trocarTela("CriarNovoPersonagem");
    }

    @FXML
    protected void onBotaoSairJogoClick() {
        Platform.exit();
    }
}
