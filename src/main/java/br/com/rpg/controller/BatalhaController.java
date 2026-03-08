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

    /**
     * Armazena as ações principais como {@code Habilidades}, {@code Defender}.
     */
    @FXML
    private VBox caixaAcoesVBox;
    /**
     * Armazena o VBox {@code caixaMenuHabilidadesVBox} e o botão {@code Voltar}.
     */
    @FXML
    private VBox caixaHabilidadesVBox;
    /**
     * Armazena o menu que possui todas as habilidades disponíveis ao jogador.
     */
    @FXML
    private VBox caixaMenuHabilidadesVBox;
    /**
     * Imprime um "log" que representa a ação de um Personagem em um turno.
     */
    @FXML
    private TextArea mensagemTurnoTextArea;

    private Heroi jogador;
    private Inimigo oponente;
    private final SessaoJogo sessaoJogo = SessaoJogo.getInstancia();
    private final GameFachada batalha = new GameFachada();

    /**
     * Inicializa todas as habilidades disponíveis para o jogador usar e a interface.
     */
    @FXML
    private void initialize(){
        this.jogador = sessaoJogo.getHeroiJogo();
        this.oponente = sessaoJogo.getStatusMasmorra().getMasmorraAtual().gerarInimigo(sessaoJogo.getStatusMasmorra().getAndarAtual());
        for (Habilidade habAtual: jogador.getMenuHabilidades()) {
            Button novaHabilidadeButton = new Button();
            // Configura cada botão
            novaHabilidadeButton.setText(habAtual.nome());
            novaHabilidadeButton.setFont(Font.font("Berry Rotunda", 12));
            novaHabilidadeButton.setOnAction(e -> {
                // Quando o jogador selecionar, irá realizar essa lógica
                caixaMenuHabilidadesVBox.setVisible(false);
                caixaAcoesVBox.setVisible(true);
                gerenciarRodada(() -> { // Usa a habilidade em questão, e gasta seu turno
                    ResultadoTurno result = batalha.personagemAtacar(jogador, oponente, habAtual);
                    narrarTurno(GeradorNarrativa.traduzirResultadoTurno(result));
                });
            });
            caixaHabilidadesVBox.getChildren().add(novaHabilidadeButton);
        }
        atualizarInterface();
    }

    /**
     * Torna o {@code caixaAcoesVBox} invisível e o {@code caixaMenuHabilidadesVBox} visível.
     */
    @FXML
    private void onBotaoHabilidadesClick() {
        caixaAcoesVBox.setVisible(false);
        caixaMenuHabilidadesVBox.setVisible(true);
    }

    /**
     * Realiza a açõa de defender para o jogador, custando seu turno.
     */
    @FXML
    private void onBotaoDefenderClick() {
        gerenciarRodada(() -> {
            jogador.setDefendendo(true);
            narrarTurno("Você armou sua defesa, o próximo dano será reduzido pela metade!");
        });
    }

    /**
     * Torna o {@code caixaMenuHabilidadesVBox} invisível e o {@code CaixaAcoesVBox} visível.
     */
    @FXML
    private void onBotaoVoltarHabilidadeClick() {
        caixaMenuHabilidadesVBox.setVisible(false);
        caixaAcoesVBox.setVisible(true);
    }

    /**
     * Atualiza a interface gráfica com as novas informações atualizadas, ou seja,
     * o estado atual do {@code jogador} e do {@code oponente}.
     */
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

    /**
     * Realiza a lógica de turno do {@code oponente}, ou seja, ele ataca.
     */
    private void executarTurnoInimigo() {
        ResultadoTurno result = batalha.personagemAtacar(oponente, jogador, oponente.retornarHabilidade());
        narrarTurno(GeradorNarrativa.traduzirResultadoTurno(result));
        Platform.runLater(this::atualizarInterface);
    }

    /**
     * Gerencia o fluxo da rodada, onde o {@code jogador} age primeiro e
     * depois o {@code oponente}.
     * @param acaoJogador Ação escolhida pelo usuário, pode ser atacar, defender.
     */
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

    /**
     * Personaliza o {@code mensagemTurnoTextArea} a partir do resultado do turno em
     * uma {@link Thread} secundária.
     * @param mensagem Mensagem que será impressa.
     */
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

    /**
     * Só executa se o {@code oponente} morrer, verificando se existe um próximo andar,
     * além de recuperar um pouco os atributos do {@code jogador}.
     */
    private void jogadorVenceu() {
        jogador.venceuBatalha();
        if (sessaoJogo.getStatusMasmorra().getAndarAtual() == sessaoJogo.getStatusMasmorra().getMasmorraAtual().getTotalAndares()) {
            // Se chegou ao fim da Masmorra, manda de volta para a cidade
            GerenciadorTela.trocarTela("MenuCidade");
        }
        else { // Do contrário, vai para o próximo andar
            GerenciadorTela.trocarTela("Batalha");
        }
        sessaoJogo.getStatusMasmorra().incrementarAndar();
    }

    /**
     * Fecha o jogo, pois se o {@code jogador} morreu, é fim de jogo automático.
     */
    private void jogadorPerdeu() {
        Platform.exit();
    }
}
