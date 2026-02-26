package br.com.rpg.model.habilidade;

import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.enums.TipoElemento;
import br.com.rpg.model.services.BatalhaService;
import br.com.rpg.model.services.results.CalculoDano;

/**
 * Armazena atributos dos poderes no jogo, além da sua própria lógica.
 * <p>
 * Define os atributos das habilidades que serão usadas por {@link Heroi} e {@link Inimigo}.
 * Usa o {@link TipoElemento} para definir os elementos das habilidades, e uma
 *
 * @param nome      Identificação única.
 * @param custoMana Quantidade de mana usada para conjurar a habilidade (pode ser 0 em ataques comuns).
 * @param elemento  Incrementa o poder da habilidade.
 * @param aplicador Interface Lambda que armazena a lógica de cada habilidade criada em {@link CatalogoHabilidades}.
 */
public record Habilidade(
        String nome,
        int custoMana,
        TipoElemento elemento,
        IAcaoHabilidade aplicador) {

    /**
     * Retorna o DTO após o uso da Habilidade, quando é ofensiva ou híbrida (ataca e cura, por exemplo).
     * @param conjurador O executor do poder (ataca o alvo).
     * @param alvo O alvo, pode ser atacado ou não receber nenhuma ação
     * @param calculadora Realiza o cálculo de dano.
     * @return DTO que guarda o relatório da ação.
     */
    public ResultadoHabilidade executar(Personagem conjurador, Personagem alvo, BatalhaService calculadora) {
        return aplicador.executar(this, conjurador, alvo, calculadora);
    }
}
