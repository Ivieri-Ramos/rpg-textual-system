package br.com.rpg.controller;

import br.com.rpg.model.core.SessaoJogo;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.mundo.Cidade;
import br.com.rpg.model.mundo.Masmorra;
import br.com.rpg.model.services.SaveService;
import br.com.rpg.view.GerenciadorTela;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

public class MenuCidadeControllerFX {

    @FXML
    private Label nomeCidadeLabel;

    @FXML
    private Label nomeHeroiLabel;

    @FXML
    private VBox caixaCidadeVBox;
    @FXML
    private VBox caixaMasmorrasVBox;
    @FXML
    private VBox caixaMenuMasmorrasVBox;

    @FXML
    private void initialize() {
        Heroi jogador = SessaoJogo.getInstancia().getHeroiJogo();
        jogador.retornouCidade();
        Cidade cidadeAtual = SessaoJogo.getInstancia().getCidadeJogo();
        nomeCidadeLabel.setText(cidadeAtual.getNome());
        nomeHeroiLabel.setText(jogador.getNome());
        for (Masmorra masmorra : SessaoJogo.getInstancia().getCidadeJogo().getMasmorrasProximas()) {
            Button novoButton = new Button();
            novoButton.setText(masmorra.getNome());
            novoButton.setPrefWidth(200);
            novoButton.setPrefHeight(40);
            novoButton.setFont(Font.font("Berry Rotunda", 14));
            novoButton.setOnAction(e -> {
                SessaoJogo.getInstancia().getStatusMasmorra().setMasmorraAtual(masmorra);
                GerenciadorTela.trocarTela("Batalha");
            });
            this.caixaMenuMasmorrasVBox.getChildren().add(novoButton);
        }
    }

    @FXML
    private void onBotaoMenuMasmorrasClick() {
        caixaCidadeVBox.setVisible(false);
        caixaMasmorrasVBox.setVisible(true);
    }

    @FXML
    private void onBotaoSalvarJogoClick() {
        SaveService salvador = new SaveService();
        salvador.salvarJogo(SessaoJogo.getInstancia().getHeroiJogo());
    }

    @FXML
    private void onBotaoSalvarESairJogoClick() {
        SaveService salvador = new SaveService();
        salvador.salvarJogo(SessaoJogo.getInstancia().getHeroiJogo());
        Platform.exit();
    }

    @FXML
    private void onBotaoVoltarMasmorrasClick() {
        caixaCidadeVBox.setVisible(true);
        caixaMasmorrasVBox.setVisible(false);
    }
}
