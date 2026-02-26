package br.com.rpg.model.mundo;

import br.com.rpg.model.habilidade.CatalogoHabilidades;

import java.util.List;
import java.util.stream.Collectors;

public class Cidade {
    private final String nome;
    private final String descricao;

    public Cidade(String nome, String descricao, List<String> chaveMasmorras) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
