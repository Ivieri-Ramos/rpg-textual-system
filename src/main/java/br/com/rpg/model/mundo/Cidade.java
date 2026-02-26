package br.com.rpg.model.mundo;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
    private final String nome;
    private final String descricao;
    private final List<Masmorra> masmorrasProximas = new ArrayList<>();

    public Cidade(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Masmorra> getMasmorrasProximas() {
        return List.copyOf(masmorrasProximas);
    }

    public void adicionarMasmorra(Masmorra novaMasmorra) {
        masmorrasProximas.add(novaMasmorra);
    }
}
