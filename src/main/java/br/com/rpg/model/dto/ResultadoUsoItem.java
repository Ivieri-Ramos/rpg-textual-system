package br.com.rpg.model.dto;

/**
 *
 * @param sucesso Se o uso deu certo
 * @param mensagem Mensagem que vai ser exibida ao jogador
 * @param deltaVida Mudança na vida
 * @param deltaMana Mudança na mana
 */
public record ResultadoUsoItem (
        boolean sucesso,
        String mensagem,
        int deltaVida,
        int deltaMana
){
    /**
     *
     * Cria resultado de sucesso para itens de cura/mana
     */
    public static ResultadoUsoItem sucesso(String mensagem, int deltaVida, int deltaMana) {
        return new ResultadoUsoItem(true, mensagem, deltaVida, deltaMana);
    }

    /**
     * Cria resultado de sucesso para itens de buff, tipo o elixir da força
     */
    public static ResultadoUsoItem sucessoComBuff(String mensagem) {
        return new ResultadoUsoItem(true, mensagem, 0, 0);
    }

    /**
     * Cria resultado de falha
     */
    public static ResultadoUsoItem falha(String mensagem) {
        return new ResultadoUsoItem(false, mensagem, 0, 0);
    }

}

