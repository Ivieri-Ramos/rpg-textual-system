package br.com.rpg.model.mundo;

import br.com.rpg.model.entities.inimigo.CatalogoInimigo;
import br.com.rpg.model.entities.inimigo.Inimigo;
import br.com.rpg.model.entities.inimigo.RankInimigo;
import br.com.rpg.util.Dado;

import java.util.List;

public class Masmorra {
    private final String nome;
    private final String descricao;
    private final int totalAndares;
    private boolean chefeMorreu = false;
    private final String chaveChefe;
    private final List<String> chaveInimigos;

    public Masmorra(String nome, String descricao, int totalAndares, List<String> chaveInimigos, String chaveChefe) {
        this.nome = nome;
        this.descricao = descricao;
        this.totalAndares = totalAndares;
        this.chaveInimigos = chaveInimigos;
        this.chaveChefe = chaveChefe;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    /**
     * Retorna um Inimigo que pertencem à Masmorra, usado quando não for a última camada.
     * @return Inimigo dentre os permitidos, pode ter atributos modificados.
     */
    public Inimigo gerarInimigo(int andarAtual) {
        if (andarAtual == getTotalAndares() && !this.chefeMorreu) {
            // Se for o último andar (e o chefe não tiver morrido), devolve o chefe da Masmorra.
            return CatalogoInimigo.enviarInimigo(chaveChefe, RankInimigo.COMUM);
        }
        int indiceInimigoSorteado = Dado.rolar(0, (this.chaveInimigos.size() - 1));
        RankInimigo rankEscolhido = RankInimigo.COMUM;
        int chanceRank = Dado.rolarD100();
        if (chanceRank < 25) { // 20% de chance de ser um Elite.
            rankEscolhido = RankInimigo.ELITE;
        }
        if (chanceRank < 5) { // 5% de chance de ser um Chefe (muito azar).
            rankEscolhido = RankInimigo.CHEFE;
        }
        return CatalogoInimigo.enviarInimigo(this.chaveInimigos.get(indiceInimigoSorteado), rankEscolhido);
    }

    public void chefeMorreu() {
        this.chefeMorreu = true;
    }
}