package br.com.rpg.controller;

import br.com.rpg.facade.GameFachada;
import br.com.rpg.model.core.SessaoJogo;
import br.com.rpg.model.dto.ResultadoTurno;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.entities.inimigo.Inimigo;
import br.com.rpg.model.habilidade.Habilidade;
import br.com.rpg.view.GeradorNarrativa;
import br.com.rpg.view.GerenciadorTela;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

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
        for (Habilidade habAtual: jogador.getMenuHabilidades()) {
            Button novaHabilidadeButton = new Button();
            novaHabilidadeButton.setText(habAtual.nome());
            novaHabilidadeButton.setFont(Font.font("Berry Rotunda", 12));
            novaHabilidadeButton.setOnAction(e -> {
                caixaMenuHabilidadesVBox.setVisible(false);
                caixaAcoesVBox.setVisible(true);
                gerenciarRodada(() -> {
                    ResultadoTurno result = batalha.personagemAtacar(jogador, oponente, habAtual);
                    narrarTurno(GeradorNarrativa.traduzirResultadoTurno(result));
                });
            });
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
        gerenciarRodada(() -> {
            jogador.setDefendendo(true);
            narrarTurno("Você armou sua defesa, o próximo dano será reduzido pela metade!");
        });
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

    private void executarTurnoInimigo() {
        ResultadoTurno result = batalha.personagemAtacar(oponente, jogador, oponente.retornarHabilidade());
        narrarTurno(GeradorNarrativa.traduzirResultadoTurno(result));
        Platform.runLater(this::atualizarInterface);
    }

    private void gerenciarRodada(Runnable acaoJogador) {
        caixaAcoesVBox.setVisible(false);
        Thread threadRodada = new Thread(() -> {
            acaoJogador.run();
            Platform.runLater(this::atualizarInterface);
            if (!oponente.isVivo()) {
                Platform.runLater(this::jogadorVenceu);
                return;
            }
            executarTurnoInimigo();
            if (!jogador.isVivo()) {
                Platform.runLater(this::jogadorPerdeu);
                return;
            }
            Platform.runLater(() -> caixaAcoesVBox.setVisible(true));
        });
        threadRodada.setDaemon(true);
        threadRodada.start();
    }

    private void narrarTurno(String mensagem) {
        mensagemTurnoTextArea.setText("");
        mensagemTurnoTextArea.setVisible(true);
        for (char c : mensagem.toCharArray()) {
            Platform.runLater(() -> mensagemTurnoTextArea.appendText(String.valueOf(c)));
            try {Thread.sleep(50); } catch (InterruptedException ignored) {}
        }
        try {Thread.sleep(1000); } catch (InterruptedException ignored) {}
        mensagemTurnoTextArea.setVisible(false);
    }

    private void jogadorVenceu() {
        jogador.venceuBatalha();
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
