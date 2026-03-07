package br.com.rpg.controller;

import br.com.rpg.model.core.SessaoJogo;
import br.com.rpg.model.entities.heroi.CatalogoHeroi;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.mundo.Cidade;
import br.com.rpg.model.mundo.MundoBuilder;
import br.com.rpg.view.GerenciadorTela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class CriarNovoPersonagemFX {

    @FXML
    private TextField campoNomeHeroiTextField;

    @FXML
    private ComboBox <String> comboClasseComboBox;

    @FXML
    private Label mensagemErroLabel;

    private final Map<String, String> dicionarioClasses = new HashMap<>();

    /**
     * Inicializa as classes de herói que serão expostas ao usuário.
     */
    @FXML
    private void initialize() {
        criarCatalogo();
        ObservableList<String> nomesTela = FXCollections.observableArrayList(
                dicionarioClasses.keySet() // Puxa apenas a chave de dicionarioClasses, que é o nome a ser amostrado ao usuário.
        );
        comboClasseComboBox.setItems(nomesTela);
    }

    /**
     * Instancia a variável {@code dicionarioClasses}, ela serve para mostrar
     * ao usuário o nome da classe na interface gráfica, enquanto o código usa
     * a chave para localizar o herói correto.
     */
    private void criarCatalogo() {
        dicionarioClasses.put("Guerreiro", "GUERREIRO");
        dicionarioClasses.put("Mago", "MAGO");
    }

    @FXML
    private void onBotaoConfirmarClick() {
        String nome = this.campoNomeHeroiTextField.getText().trim();
        String classe = this.comboClasseComboBox.getValue();
        if (classe == null) {
            this.mensagemErroLabel.setText("Selecione uma classe para o seu Herói!");
            return;
        }
        if (nome.isEmpty()) {
            this.mensagemErroLabel.setText("O nome não pode estar vazio!");
            return;
        }
        if (nome.contains(" ")) {
            this.mensagemErroLabel.setText("O nome deve ser apenas uma palavra!");
            return;
        }
        if (!nome.matches("^[a-zA-ZÀ-ÿ]+$")) {
            this.mensagemErroLabel.setText("O nome deve conter apenas letras!");
            return;
        }
        if (nome.length() < 2 || nome.length() > 12) {
            this.mensagemErroLabel.setText("O nome deve ter entre 2 e 12 letras!");
            return;
        }
        this.mensagemErroLabel.setText(""); // Retira a mensagem de erro (caso exista).
        String nomeFormatado = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        String chaveHeroi = dicionarioClasses.get(classe);
        Heroi jogador = CatalogoHeroi.enviarHeroi(chaveHeroi, nomeFormatado);
        MundoBuilder construtor = new MundoBuilder();
        Cidade cidadeJogo = construtor.gerarCidadePrincipal();
        SessaoJogo.getInstancia().setHeroiJogo(jogador);
        SessaoJogo.getInstancia().setCidadeJogo(cidadeJogo);
        GerenciadorTela.trocarTela("MenuCidade");
    }
}
