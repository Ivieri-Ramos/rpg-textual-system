package br.com.rpg.view;

import br.com.rpg.exceptions.TelaNaoEncontradaException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public final class GerenciadorTela {

    private static Stage palcoAtual;

    private GerenciadorTela() {}

    /**
     * Instancia o primeiro palco do jogo, deve ser chamado no início do código.
     * @param palcoInicial Palco inicial do jogo, o menu principal.
     */
    public static void setPalcoInicial(Stage palcoInicial) {
        palcoAtual = palcoInicial;
    }

    /**
     * Troca a tela a partir do nome de um arquivo FXML.
     * <p>
     * <b>Importante</b>: Não deve conter o ".fxml", apenas o nome do arquivo em si.
     * @param nomeArquivoFXML Nome do arquivo que será usado para trocar a tela.
     */
    public static void trocarTela(String nomeArquivoFXML) {
        String caminhoArquivo = "/fxml/" + nomeArquivoFXML + ".fxml";
        URL urlArquivo = GerenciadorTela.class.getResource(caminhoArquivo);
        if (urlArquivo == null) { // Verifica se o arquivo existe.
            throw new TelaNaoEncontradaException();
        }
        try {
            Parent raiz = FXMLLoader.load(urlArquivo);
            Scene novaCena = new Scene(raiz, 800, 600);
            palcoAtual.setScene(novaCena);
        } catch (IOException e) { // Caso o FXML esteja corrompido
            throw new TelaNaoEncontradaException(nomeArquivoFXML);
        }
    }
}
