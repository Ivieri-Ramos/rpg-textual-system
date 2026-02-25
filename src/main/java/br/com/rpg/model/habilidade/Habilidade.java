package br.com.rpg.model.habilidade;

import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.enums.TipoElemento;
import br.com.rpg.model.services.BatalhaService;
import br.com.rpg.model.services.results.CalculoDano;

/**
 * Record Habilidade que armazena atributos dos poderes no jogo.
 * <p>
 * Define os atributos das habilidades que serão usadas por {@link Heroi} e {@link Inimigo}.
 * Usa o {@link TipoElemento} para definir os elementos das habilidades, e uma
 * {@code razaoDano} para multiplicar em relação ao {@link Personagem#getDano()}.
 *
 * @param nome      Identificação única.
 * @param custoMana Quantidade de mana usada para conjurar a habilidade (pode ser 0 em ataques comuns).
 * @param elemento  Incrementa o poder da habilidade.
 * @param aplicador Interface que armazena o contâiner que terá a lógica de cada habilidade.
 */
public record Habilidade(
        String nome,
        int custoMana,
        TipoElemento elemento,
        IAcaoHabilidade aplicador) {

    public ResultadoHabilidade executar(Personagem atacante, Personagem alvo, BatalhaService calculadora) {
        return aplicador.executar(atacante, alvo, calculadora);
    }
}
