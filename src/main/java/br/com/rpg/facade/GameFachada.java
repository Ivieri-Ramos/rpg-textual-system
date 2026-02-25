package br.com.rpg.facade;

import br.com.rpg.model.dto.ResultadoAtaque;
import br.com.rpg.model.habilidade.Habilidade;
import br.com.rpg.model.entities.Personagem;
import br.com.rpg.model.habilidade.ResultadoHabilidade;
import br.com.rpg.model.services.BatalhaService;
import br.com.rpg.model.services.results.CalculoDano;

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
     * @param atacante Entidade que executa o ataque, pode ter sua mana consumida.
     * @param alvo Entidade que recebe o ataque, pode ter sua vida diminuída.
     * @param habUsar Ataque usado pelo {@code atacante}.
     * @return Um relatório completo do ataque que será imprimido posteriormente.
     */
    public ResultadoAtaque personagemAtacar(Personagem atacante, Personagem alvo, Habilidade habUsar) {
        atacante.consumirMana(habUsar.custoMana());
        ResultadoHabilidade resultado = habUsar.executar(atacante, alvo, calculadoraBatalha);
        return new ResultadoAtaque(
                atacante.getNome(),
                alvo.getNome(),
                habUsar.nome(),
                resultado.relatorioDano().danoFinal(),
                resultado.relatorioDano().esquivou(),
                resultado.relatorioDano().critico(),
                resultado.relatorioDano().defendeu(),
                !alvo.isVivo()
        );
    }
}
