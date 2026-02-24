package br.com.rpg.exceptions;

public class EquipamentoNaoEncontradoException extends RuntimeException {
    public EquipamentoNaoEncontradoException(String nomeEquipamento) {
        super("Equipamento de nome: " + nomeEquipamento + " não foi encontrada no Catálogo existente!\nVerifique novamente.");
    }
}
