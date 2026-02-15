package br.com.rpg.model.entities;

import br.com.rpg.model.enums.TipoElemento;

public class Habilidade {
    private final String nome;
    private final double razaoDano;
    private final TipoElemento elemento;

    /**
     * Construtor padrão de Habilidade.
     * <p>
     * Ela define as habilidades que serão usadas por {@link Heroi} e {@link Inimigo}.
     * Usa o {@link TipoElemento} para definir os elementos das habilidades, e uma
     * {@code razaoDano} para multiplicar em relação ao {@link Personagem#getDano()}.
     * @param nome Identificação única.
     * @param razaoDano Aumenta ou diminui o {@link Personagem#getDano()}.
     * @param elemento Incrementa o poder da habilidade.
     */
    public Habilidade(String nome, double razaoDano, TipoElemento elemento) {
        this.nome = nome;
        this.razaoDano = razaoDano;
        this.elemento = elemento;
    }

    public String getNome() {
        return nome;
    }

    public double getDanoBase() {
        return razaoDano;
    }

    public TipoElemento getElemento() {
        return elemento;
    }
}
