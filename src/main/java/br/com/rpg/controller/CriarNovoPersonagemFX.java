package br.com.rpg.controller;

import br.com.rpg.model.core.SessaoJogo;
import br.com.rpg.model.entities.heroi.CatalogoHeroi;
import br.com.rpg.model.entities.heroi.Heroi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class CriarNovoPersonagemFX implements Initializable {

    @FXML
    private TextField campoNomeHeroi;

    @FXML
    private ComboBox <String> comboClasse;

    @FXML
    private Label mensagemErro;

    private final Map<String, String> dicionarioClasses = new HashMap<>();

    /**
     * Sobrescreve o método de {@link Initializable}, que é executado no início do programa.
     * @param local Parâmetro de sobrescrita (não é usado por enquanto).
     * @param resources Parâmetro de sobrescrita (não é usado por enquanto).
     */
    @Override
    public void initialize(URL local, ResourceBundle resources) {
        criarCatalogo();
        ObservableList<String> nomesTela = FXCollections.observableArrayList(
                dicionarioClasses.keySet() // Puxa apenas a chave de dicionarioClasses, que é o nome a ser amostrado ao usuário.
        );
        comboClasse.setItems(nomesTela);
    }

    /**
     * Instancia a variável {@code dicionarioClasses}, ela serve para amostrar
     * ao usuário o nome da classe na interface gráfica, enquanto o código usa
     * a chave para localizar o herói correto.
     */
    private void criarCatalogo() {
        dicionarioClasses.put("Guerreiro", "GUERREIRO");
        dicionarioClasses.put("Mago", "MAGO");
    }

    @FXML
    protected void onBotaoConfirmarClick() {
        String nome = this.campoNomeHeroi.getText().trim();
        String classe = this.comboClasse.getValue();
        if (classe == null) {
            this.mensagemErro.setText("Selecione uma classe para o seu Herói!");
            return;
        }
        if (nome.isEmpty()) {
            this.mensagemErro.setText("O nome não pode estar vazio!");
            return;
        }
        if (nome.contains(" ")) {
            this.mensagemErro.setText("O nome deve ser apenas uma palavra!");
            return;
        }
        if (!nome.matches("^[a-zA-ZÀ-ÿ]+$")) {
            this.mensagemErro.setText("O nome deve conter apenas letras!");
            return;
        }
        if (nome.length() < 2 || nome.length() > 12) {
            this.mensagemErro.setText("O nome deve ter entre 2 e 12 letras!");
            return;
        }
        this.mensagemErro.setText(""); // Retira a mensagem de erro (caso exista).
        String nomeFormatado = nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
        String chaveHeroi = dicionarioClasses.get(classe);
        Heroi jogador = CatalogoHeroi.enviarHeroi(chaveHeroi, nomeFormatado);
        SessaoJogo.getInstancia().setHeroiJogo(jogador);
    }
}
