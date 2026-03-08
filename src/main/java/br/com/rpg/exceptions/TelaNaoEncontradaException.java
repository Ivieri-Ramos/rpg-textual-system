package br.com.rpg.exceptions;

/**
 * Dispara caso o programador digite o nome errado de um arquivo ou
 * tentar passar {@code null} em {@link br.com.rpg.view.GerenciadorTela#trocarTela(String) trocarTela}.
 */
public class TelaNaoEncontradaException extends RuntimeException {

    public TelaNaoEncontradaException(String nomeArquivoFXML) {
        super("Arquivo de nome: " + nomeArquivoFXML + ".fxml apresentou erro! O arquivo está corrompido!");
    }

    public TelaNaoEncontradaException() {
        super("Arquivo não existe! Verifique se digitou o nome corretamente!");
    }
}
