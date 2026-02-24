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
    private AplicadorBonus aplicadorBonus;

    /**
     * Construtor do SistemaXP.
     * Inicializa o sistema no nível 1 com 0 XP e calcula o XP máximo necessário.
     *
     * @param aplicadorBonus O aplicador de bônus responsável por aplicar os efeitos
     */
    public SistemaXP(AplicadorBonus aplicadorBonus) {
        this.aplicadorBonus = aplicadorBonus;
        this.nivel = 1;
        this.xpAtual = 0;
        this.xpMaximo = CalculadoraXP.calcularXpParaNivel(this.nivel);
    }

    /**
     * Adiciona XP ao personagem e verifica se houve level up.
     *
     * @param xpGanho A quantidade de XP a adicionar
     */
    public void adicionarXp(int xpGanho) {
        if (xpGanho < 0) {
            throw new IllegalArgumentException("XP ganho não pode ser negativo");
        }

        this.xpAtual += xpGanho;

        while (this.xpAtual >= this.xpMaximo) {
            subirDeNivel();
        }
    }

    /**
     * Aumenta o nível do personagem e aplica os bônus através do {@link AplicadorBonus}.
     */
    private void subirDeNivel() {
        this.xpAtual -= this.xpMaximo;
        this.nivel++;

        // Atualiza o XP máximo para o novo nível
        this.xpMaximo = CalculadoraXP.calcularXpParaNivel(this.nivel);

        // Notifica o aplicador de bônus para aplicar os efeitos
        ResultadoBonus resultado = criarResultadoBonus();
        aplicadorBonus.aplicarBonus(resultado);
    }

    /**
     * Cria um {@link ResultadoBonus} com as informações do level up.
     * Os bônus são calculados pela classe {@link BonusLevelUp}.
     *
     * @return O resultado do bonus a ser aplicado
     */
    private ResultadoBonus criarResultadoBonus() {
        // Nota: Os valores reais de dano e vida virão do aplicador de bônus
        // Este método apenas cria o objeto com 0s, pois o aplicador terá acesso aos valores reais
        return new ResultadoBonus(0, 0, this.nivel);
    }

    // Getters
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