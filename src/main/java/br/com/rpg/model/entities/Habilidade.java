package br.com.rpg.model.entities;

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
public record Habilidade(String nome, int custoMana, double razaoDano, TipoElemento elemento) {
	/**
	 * Construtor compacto que valida os parâmetros da habilidade.
	 * @throws IllegalArgumentException caso algum parâmetro seja inválido.
	 */
	public Habilidade {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome da habilidade não pode ser nulo ou vazio");
		}
		if (custoMana < 0) {
			throw new IllegalArgumentException("Custo de mana não pode ser negativo");
		}
		if (razaoDano <= 0) {
			throw new IllegalArgumentException("Razão de dano deve ser maior que zero");
		}
		if (elemento == null) {
			throw new IllegalArgumentException("Elemento da habilidade não pode ser nulo");
		}
	}
}
