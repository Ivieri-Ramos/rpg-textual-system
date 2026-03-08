package br.com.rpg.controller;

import br.com.rpg.facade.GameFachada;
import br.com.rpg.model.core.SessaoJogo;
import br.com.rpg.model.dto.ResultadoTurno;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.entities.inimigo.Inimigo;
import br.com.rpg.model.habilidade.Habilidade;
import br.com.rpg.view.GeradorNarrativa;
import br.com.rpg.view.GerenciadorTela;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class BatalhaController {

    @FXML
    private Label nomeHeroiLabel;
    @FXML
    private Label vidaHeroiLabel;
    @FXML
    private ProgressBar vidaHeroiProgressBar;
    @FXML
    private Label manaHeroiLabel;
    @FXML
    private ProgressBar manaHeroiProgressBar;

    @FXML
    private Label nomeInimigoLabel;
    @FXML
    private Label vidaInimigoLabel;
    @FXML
    private ProgressBar vidaInimigoProgressBar;

    @FXML
    private VBox caixaAcoesVBox;
    @FXML
    private VBox caixaHabilidadesVBox;
    @FXML
    private VBox caixaMenuHabilidadesVBox;
    @FXML
    private TextArea mensagemTurnoTextArea;

    private Heroi jogador;
    private Inimigo oponente;
    private final SessaoJogo sessaoJogo = SessaoJogo.getInstancia();
    private final GameFachada batalha = new GameFachada();

    @FXML
    private void initialize(){
        this.jogador = sessaoJogo.getHeroiJogo();
        this.oponente = sessaoJogo.getStatusMasmorra().getMasmorraAtual().gerarInimigo(sessaoJogo.getStatusMasmorra().getAndarAtual());
        int i = 0;
        for (Habilidade habAtual: jogador.getMenuHabilidades()) {
            Button novaHabilidadeButton = new Button();
            novaHabilidadeButton.setText(habAtual.nome());
            novaHabilidadeButton.setFont(Font.font("Berry Rotunda", 12));
            int finalI = i;
            novaHabilidadeButton.setOnAction(e -> {
                ResultadoTurno result = batalha.personagemAtacar(jogador, oponente, jogador.getMenuHabilidades().get(finalI));
                caixaMenuHabilidadesVBox.setVisible(false);
                caixaAcoesVBox.setVisible(true);
                fimTurnoHeroi(GeradorNarrativa.traduzirResultadoTurno(result));
            });
            i++;
            caixaHabilidadesVBox.getChildren().add(novaHabilidadeButton);
        }
        atualizarInterface();
    }

    @FXML
    private void onBotaoHabilidadesClick() {
        caixaAcoesVBox.setVisible(false);
        caixaMenuHabilidadesVBox.setVisible(true);
    }

    @FXML
    private void onBotaoDefenderClick() {
        jogador.setDefendendo(true);
        fimTurnoHeroi("Armou sua defesa");
    }

    @FXML
    private void onBotaoVoltarHabilidadeClick() {
        caixaMenuHabilidadesVBox.setVisible(false);
        caixaAcoesVBox.setVisible(true);
    }

    private void atualizarInterface() {
        nomeHeroiLabel.setText(jogador.getNome());
        vidaHeroiLabel.setText(String.valueOf(jogador.getVida()));
        vidaHeroiProgressBar.setProgress((double) jogador.getVida() / jogador.getVidaMaxima());
        vidaHeroiProgressBar.setStyle("-fx-accent: red;");
        manaHeroiLabel.setText(String.valueOf(jogador.getMana()));
        manaHeroiProgressBar.setProgress((double) jogador.getMana() / jogador.getManaMaxima());
        manaHeroiProgressBar.setStyle("-fx-accent: blue;");
        nomeInimigoLabel.setText(oponente.getNome());
        vidaInimigoLabel.setText(String.valueOf(oponente.getVida()));
        vidaInimigoProgressBar.setProgress((double) oponente.getVida() / oponente.getVidaMaxima());
        vidaInimigoProgressBar.setStyle("-fx-accent: red;");
    }

    private void fimTurnoHeroi(String mensagem) {
        //narrarTurno(mensagem, this::executarTurnoInimigo);
        atualizarInterface();
        if (!oponente.isVivo()) {
            jogadorVenceu();
        }
        executarTurnoInimigo();
    }

    private void executarTurnoInimigo() {
        ResultadoTurno result = batalha.personagemAtacar(oponente, jogador, oponente.retornarHabilidade());
        // narrarTurno(GeradorNarrativa.traduzirResultadoTurno(result), () -> caixaAcoesVBox.setDisable(false));
        atualizarInterface();
        if (!jogador.isVivo()) {
            jogadorPerdeu();
        }
    }
    /*
    private void narrarTurno(String mensagem, Runnable acaoFinal) {
        mensagemTurnoTextArea.setText("");
        mensagemTurnoTextArea.setVisible(true);
        final int[] indiceChar = {0};
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
            mensagemTurnoTextArea.appendText(String.valueOf(mensagem.charAt(indiceChar[0])));
            indiceChar[0]++;
        }));
        timeline.setCycleCount(mensagem.length());
        timeline.setOnFinished(event -> {
            PauseTransition pausa = new PauseTransition(Duration.seconds(1));
            pausa.setOnFinished(e -> {
                if (acaoFinal != null) acaoFinal.run();
                mensagemTurnoTextArea.setVisible(false);
                caixaAcoesVBox.setVisible(true);
            });
            pausa.play();
        });
        timeline.play();
    }
    */

    private void jogadorVenceu() {
        jogador.venceu();
        if (sessaoJogo.getStatusMasmorra().getAndarAtual() == sessaoJogo.getStatusMasmorra().getMasmorraAtual().getTotalAndares()) {
            GerenciadorTela.trocarTela("MenuCidade");
        }
        else {
            GerenciadorTela.trocarTela("Batalha");
        }
        sessaoJogo.getStatusMasmorra().incrementarAndar();
    }

    private void jogadorPerdeu() {
        Platform.exit();
    }
}
