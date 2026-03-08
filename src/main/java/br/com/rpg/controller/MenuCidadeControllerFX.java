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

public class MenuCidadeControllerFX {

    @FXML
    private Label nomeCidadeLabel;
    @FXML
    private Label nomeHeroiLabel;

    /**
     * Representa a VBox que armazena os botões {@code Masmorras}, {@code Salvar o Jogo} e
     * {@code Salvar e Sair do Jogo}.
     */
    @FXML
    private VBox caixaCidadeVBox;
    /**
     * Representa a VBox que armazena a VBox {@code caixaMenuMasmorrasVBox} e o botão {@code Voltar}.
     */
    @FXML
    private VBox caixaMasmorrasVBox;
    /**
     * Representa a VBox que armazena os botões que possuem as masmorras disponíveis.
     */
    @FXML
    private VBox caixaMenuMasmorrasVBox;

    /**
     * Inicializa os componentes da tela, nesse caso, instancia o
     * Menu de Masmorras, que contém as masmorras disponíveis na cidade.
     * Além de setar textos nos Labels definidos.
     */
    @FXML
    private void initialize() {
        Heroi jogador = SessaoJogo.getInstancia().getHeroiJogo();
        jogador.retornouCidade();
        Cidade cidadeAtual = SessaoJogo.getInstancia().getCidadeJogo();
        nomeCidadeLabel.setText(cidadeAtual.getNome());
        nomeHeroiLabel.setText(jogador.getNome());
        for (Masmorra masmorra : SessaoJogo.getInstancia().getCidadeJogo().getMasmorrasProximas()) {
            // Itera sobre cada masmorra daquela cidade, nesse caso a principal,
            // criando um método único para cada botão que envia o jogador para aquela masmorra específica.
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

    /**
     * Deixa o bloco {@code caixaCidadeVBox} invisível e torna o {@code caixaMasmorrasVBox} visível.
     */
    @FXML
    private void onBotaoMenuMasmorrasClick() {
        caixaCidadeVBox.setVisible(false);
        caixaMasmorrasVBox.setVisible(true);
    }

    /**
     * Salva o jogo usando o {@link SaveService#salvarJogo(Heroi) salvarJogo}.
     */
    @FXML
    private void onBotaoSalvarJogoClick() {
        SaveService salvador = new SaveService();
        salvador.salvarJogo(SessaoJogo.getInstancia().getHeroiJogo());
    }

    /**
     * Salva o jogo usando o {@link SaveService#salvarJogo(Heroi) salvarJogo},
     * além de fechar o jogo de forma segura.
     */
    @FXML
    private void onBotaoSalvarESairJogoClick() {
        SaveService salvador = new SaveService();
        salvador.salvarJogo(SessaoJogo.getInstancia().getHeroiJogo());
        Platform.exit();
    }

    /**
     * Torna o {@code caixaCidadeVBox} visível, tornando o {@code caixaMasmorrasVBox} invisível.
     */
    @FXML
    private void onBotaoVoltarMasmorrasClick() {
        caixaCidadeVBox.setVisible(true);
        caixaMasmorrasVBox.setVisible(false);
    }
}
