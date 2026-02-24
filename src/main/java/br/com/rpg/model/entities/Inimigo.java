package br.com.rpg.model.entities;

import br.com.rpg.model.dto.RelatorioInfoInimigo;
import br.com.rpg.model.enums.ClasseInimigo;
import br.com.rpg.util.Dado;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que será usada para criar inimigos no jogo.
 * <p>
 */
public class Inimigo extends Personagem {

    /**
     * Construtor especializado de Inimigo que define
     * atributos-base a partir de tipos de classes pré-definidas.
     * <p>
     * Utiliza o {@link ClasseInimigo} a partir das suas constantes Enum
     * e define os atributos-base (vida, dano, chanceCrit, etc.) usados pelo construtor
     * em {@link Personagem}, para criar a entidade Inimigo.
     * @param nome Nome identificador do inimigo.
     * @param tipoClasse Tipos de classes pré-definidas ({@code GOBLIN}, {@code ORC}, etc.) que atribui valores base.
     */
    public Inimigo(String nome, ClasseInimigo tipoClasse) {
        super(nome, tipoClasse.getVidaBase(), tipoClasse.getDanoBase(), tipoClasse.getManaBase(),
                tipoClasse.getDefesaBase(), tipoClasse.getChanceCritBase(),
                tipoClasse.getChanceEsqBase());
    }

    /**
     * Escolhe uma habilidade disponível do Inimigo, para ser usada contra o {@link Heroi}.
     * @return Habilidade que será usada, pode ser {@code null} caso não tenha mana suficiente.
     */
    public Habilidade retornarHabilidade() {
        List<Habilidade> habilidadesDisponiveis = new ArrayList<>();
        for (Habilidade habAtual : getMenuHabilidades()) { // Itera sobre cada habilidade dentro da lista.
            if (habAtual.custoMana() <= getMana()) { // Se tiver mana, adiciona nas disponíveis.
                habilidadesDisponiveis.add(habAtual);
            }
        }
        if (habilidadesDisponiveis.isEmpty()) { // Se tiver vazia (caso não tenha mana), retorna null.
            return null;
        }
        int qtdHabilidades =  habilidadesDisponiveis.size();
        int sorteio = Dado.rolar(0, (qtdHabilidades - 1)); // Escolhe uma habilidade aleatoriamente entre 0 e (total - 1), pois é um vetor.
        return habilidadesDisponiveis.get(sorteio);
        /*
        TODO: Futuramente adicionar um sistema mais complexo, usando interfaces, onde o Inimigo escolha uma
            habilidade a partir de um peso ponderado (Um "Ataque Normal" seja mais comum que "Ataque Forte"),
            ou um algoritmo que ele ataque de forma inteligente, ficando mais agressivo quanto menos vida tiver,
            ou usando certas habilidades a partir de condições (Caso fique muito tempo vivo).
         */
    }

    public RelatorioInfoInimigo gerarRelatorio(int numeroTurnos) {
        String vidaAtual = (numeroTurnos >= 1) ? String.valueOf(getVida()) : "???";
        List<String> habilidadesVisiveis = new ArrayList<>();
        int limite = Math.min(numeroTurnos, getMenuHabilidades().size());
        for (int i = 0; i < getMenuHabilidades().size(); i++) {
            if (i < limite) {
                habilidadesVisiveis.add(getMenuHabilidades().get(i).nome());
            }
            else {
                habilidadesVisiveis.add("???");
            }
        }
        return new RelatorioInfoInimigo(getNome(), vidaAtual, habilidadesVisiveis);
    }

    @Override
    public String toString() {
        return "Inimigo{" + super.toString() + '}';
    }


}