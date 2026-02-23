package br.com.rpg.model.item;
import br.com.rpg.model.dto.ResultadoUsoItem;

/**
 * Armazena os atributos gerais das classes Equipamento e
 * Consumivel que herdarão dela.
 */
public abstract class Item {

    private final String nome;
    private final String descricao;
    private final int preco;

    /**
     * Construtor padrão da classe, apenas instancia os atributos base.
     * @param nome Identificação única.
     * @param descricao Detalhe o propósito do item.
     * @param preco Custo do item, será necessário posteriormente para um sistema de loja.
     */
    public Item(String nome, String descricao, int preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPreco() {
        return preco;
    }
}
