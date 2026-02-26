package br.com.rpg.model.mundo;

import br.com.rpg.model.entities.inimigo.Inimigo;

import java.util.List;

public class Masmorra {
    private final String nome;
    private final String descricao;
    //private final List<Inimigo> inimigosDisponiveis;

    public Masmorra(String nome, String descricao, List<String> chaveInimigos) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
