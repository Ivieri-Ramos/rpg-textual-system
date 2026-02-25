package br.com.rpg.model.sistemaxp;

/**
 * Sistema de XP e progressão de níveis.
 * <p>
 * Regras:
 * - Nível 1: 10 XP necessário para upar
 * - A partir do nível 2: aumenta 5 XP a cada nível
 * - Cada nível aumenta dano e pontos de vida em 10%
 * <p>
 * O sistema é independente e utiliza {@link AplicadorBonus} para aplicar efeitos.
 */
public class SistemaXP {

    private int xpAtual;
    private int xpMaximo;
    private int nivel;

    /**
     * Construtor do SistemaXP.
     * Inicializa o sistema no nível 1 com 0 XP e calcula o XP máximo necessário.
     *
     * @param aplicadorBonus O aplicador de bônus responsável por aplicar os efeitos
     */
    public SistemaXP() {
        this.nivel = 1;
        this.xpAtual = 0;
        this.xpMaximo = CalculadoraXP.calcularXpParaNivel(this.nivel);
    }

    /**
     * Adiciona XP ao personagem e verifica se houve level up.
     *
     * @param xpGanho A quantidade de XP a adicionar
     * @return A quantidade de níveis ganhos
     */
    public int adicionarXp(int xpGanho) {
        if (xpGanho < 0) {
            throw new IllegalArgumentException("XP ganho não pode ser negativo");
        }

        this.xpAtual += xpGanho;
        int upou = 0;

        while (this.xpAtual >= this.xpMaximo) {
            subirDeNivel();
            upou++;
        }
        
        return upou;
    }

    private void subirDeNivel() {
        this.xpAtual -= this.xpMaximo;
        this.nivel++;

        // Atualiza o XP máximo para o novo nível
        this.xpMaximo = CalculadoraXP.calcularXpParaNivel(this.nivel);

    }

    public int getXpAtual() {
        return xpAtual;
    }

    public int getXpMaximo() {
        return xpMaximo;
    }

    public int getNivel() {
        return nivel;
    }
}