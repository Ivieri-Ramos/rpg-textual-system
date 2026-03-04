package br.com.rpg.model.core;

import br.com.rpg.model.entities.heroi.Heroi;

public final class SessaoJogo {
    private final static SessaoJogo instancia = new SessaoJogo();
    private Heroi heroiJogo;

    private SessaoJogo() {}

    public static SessaoJogo getInstancia() {
        return instancia;
    }

    public Heroi getHeroiJogo() {
        return heroiJogo;
    }

    public void setHeroiJogo(Heroi heroiJogo) {
        this.heroiJogo = heroiJogo;
    }
}
