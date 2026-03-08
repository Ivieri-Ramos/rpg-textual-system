package br.com.rpg.controller;

import br.com.rpg.model.core.SessaoJogo;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.mundo.Cidade;
import br.com.rpg.model.services.SaveService;
import br.com.rpg.view.GerenciadorTela;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MenuCidadeControllerFX {

    @FXML
    private Label nomeCidadeLabel;

    @FXML
    private Label nomeHeroiLabel;

    @FXML
    private void initialize() {
        Heroi jogador = SessaoJogo.getInstancia().getHeroiJogo();
        jogador.retornouCidade();
        Cidade cidadeAtual = SessaoJogo.getInstancia().getCidadeJogo();
        nomeCidadeLabel.setText(cidadeAtual.getNome());
        nomeHeroiLabel.setText(jogador.getNome());
    }

    @FXML
    private void onBotaoMenuMasmorrasClick() {
        GerenciadorTela.trocarTela("MenuMasmorras");
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
}
