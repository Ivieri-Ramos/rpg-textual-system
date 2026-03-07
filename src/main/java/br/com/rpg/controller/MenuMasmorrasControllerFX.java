package br.com.rpg.controller;

import br.com.rpg.model.core.SessaoJogo;
import br.com.rpg.model.mundo.Masmorra;
import br.com.rpg.view.GerenciadorTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

public class MenuMasmorrasControllerFX {

    @FXML
    private VBox caixaMasmorrasVBox;

    @FXML
    private void initialize() {
        List<Masmorra> masmorras = SessaoJogo.getInstancia().getCidadeJogo().getMasmorrasProximas();
        int i = 0;
        for (Masmorra masmorra : masmorras) {
            Button novoButton = new Button();
            novoButton.setText(masmorra.getNome());
            novoButton.setPrefWidth(200);
            novoButton.setPrefHeight(40);
            novoButton.setFont(Font.font("Berry Rotunda", 14));
            int finalI = i;
            novoButton.setOnAction(e -> {
               SessaoJogo.getInstancia().setMasmorraAtual(
                       SessaoJogo.getInstancia().getCidadeJogo().getMasmorrasProximas().get(finalI));
               GerenciadorTela.trocarTela("Batalha");
            });
            this.caixaMasmorrasVBox.getChildren().add(novoButton);
            i++;
        }
    }

    @FXML
    private void onBotaoVoltarClick() {
        GerenciadorTela.trocarTela("MenuCidade");
    }
}
