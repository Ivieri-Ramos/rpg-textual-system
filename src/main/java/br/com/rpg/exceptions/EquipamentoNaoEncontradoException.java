package br.com.rpg.exceptions;

import br.com.rpg.model.entities.CatalogoEquipamentos;

public class EquipamentoNaoEncontradoException extends RuntimeException {
    public EquipamentoNaoEncontradoException(String nomeEquipamento) {
        super("Equipamento de nome: " + nomeEquipamento + " não foi encontrada no Catálogo existente!\nVerifique novamente.");
    }
}
