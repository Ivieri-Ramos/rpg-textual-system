package br.com.rpg.facade;

import br.com.rpg.model.dto.ResultadoTurno;
import br.com.rpg.model.habilidade.Habilidade;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.habilidade.ResultadoHabilidade;
import br.com.rpg.model.services.BatalhaService;

/**
 * Realiza a lógica adicional pedida pelo {@link br.com.rpg.controller.BatalhaController BatalhaController},
 * chamando métodos que alterem o estado das entidades, enquanto o controller
 * fica responsável por receber I/O (input e output).
 */
public class GameFachada {
    // TODO: Métodos que realizem a mediação entre Controller - View e mudar o estado das entidades

    private final BatalhaService calculadoraBatalha = new BatalhaService();

    /**
     * Atualiza o estado das entidades do tipo {@link Personagem}, em relação a {@link Habilidade} usada.
     * <p>
     * Consome mana do {@code atacante} e retira vida de {@code alvo}, chamando métodos próprios
     * das entidades.
     * @param conjurador Entidade que executa o ataque, pode ter sua mana consumida.
     * @param alvo Entidade que recebe o ataque, pode ter sua vida diminuída.
     * @param habUsar Poder usado pelo {@code atacante}, pode ser ofensiva ou não.
     * @return Um relatório completo do ataque que será impresso posteriormente.
     */
    public ResultadoTurno personagemAtacar(Personagem conjurador, Personagem alvo, Habilidade habUsar) {
        conjurador.consumirMana(habUsar.custoMana());
        ResultadoHabilidade resultado = habUsar.executar(conjurador, alvo, calculadoraBatalha);
        return new ResultadoTurno(
                conjurador.getNome(),
                alvo.getNome(),
                resultado,
                !alvo.isVivo()
        );
    }
}
