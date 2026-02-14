package br.com.rpg.model.entities;

import br.com.rpg.model.enums.TipoElemento;

public class Habilidade {
    private String nome;
    private int danoBase;
    TipoElemento elemento;

    public Habilidade(String nome, int danoBase, TipoElemento elemento) {
        this.nome = nome;
        this.danoBase = danoBase;
        this.elemento = elemento;
    }

    public String getNome() {
        return nome;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public TipoElemento getElemento() {
        return elemento;
    }
}
