package br.com.rpg.model.habilidade;

import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.enums.TipoElemento;

/**
 * Record Habilidade que armazena atributos dos poderes no jogo.
 * <p>
 * Define os atributos das habilidades que serão usadas por {@link Heroi} e {@link Inimigo}.
 * Usa o {@link TipoElemento} para definir os elementos das habilidades, e uma
 * {@code razaoDano} para multiplicar em relação ao {@link Personagem#getDano()}.
 *
 * @param nome      Identificação única.
 * @param custoMana Quantidade de mana usada para conjurar a habilidade (pode ser 0 em ataques comuns).
 * @param razaoDano Aumenta ou diminui o {@link Personagem#getDano()}.
 * @param elemento  Incrementa o poder da habilidade.
 */
public record Habilidade(String nome, int custoMana, double razaoDano, TipoElemento elemento) {}
