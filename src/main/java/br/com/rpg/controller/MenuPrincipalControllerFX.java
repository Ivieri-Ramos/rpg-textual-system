package br.com.rpg.controller;

import br.com.rpg.model.core.SessaoJogo;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.mundo.Cidade;
import br.com.rpg.model.mundo.MundoBuilder;
import br.com.rpg.model.services.SaveService;
import br.com.rpg.view.GerenciadorTela;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class MenuPrincipalControllerFX {
    /**
     * Quando o jogador clica no botão do menu principal "Novo Jogo",
     * direciona o usuário para criar um novo herói.
     */
    @FXML
    private void onBotaoNovoJogoClick(){
        GerenciadorTela.trocarTela("CriarNovoPersonagem");
    }

    @FXML
    private void onBotaoCarregarJogoSalvoClick(){
        SaveService carregarSave = new SaveService();
        Heroi jogador = carregarSave.carregarJogo();
        if (jogador != null) {
            MundoBuilder construtor = new MundoBuilder();
            Cidade cidadeJogo = construtor.gerarCidadePrincipal();
            SessaoJogo.getInstancia().setHeroiJogo(jogador);
            SessaoJogo.getInstancia().setCidadeJogo(cidadeJogo);
            GerenciadorTela.trocarTela("MenuCidade");
        }
        else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Erro ao carregar jogo");
            alerta.setHeaderText("Nenhum Jogo Salvo Encontrado");
            alerta.setContentText("Não foi possível carregar seu salvamento. Inicie um novo jogo para continuarmos sua aventura!");
            alerta.showAndWait();
        }
    }

    @FXML
    private void onBotaoSairJogoClick() {
        Platform.exit();
    }
}
