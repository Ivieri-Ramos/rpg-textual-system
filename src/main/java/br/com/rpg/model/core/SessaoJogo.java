package br.com.rpg.model.core;

import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.mundo.Cidade;
import br.com.rpg.model.mundo.Masmorra;

public final class SessaoJogo {
    private final static SessaoJogo instancia = new SessaoJogo();
    private Heroi heroiJogo;
    private Cidade cidadeJogo;
    private final EstadoMasmorra statusMasmorra = new EstadoMasmorra();

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

    public Cidade getCidadeJogo() {
        return cidadeJogo;
    }

    public void setCidadeJogo(Cidade cidadeJogo) {
        this.cidadeJogo = cidadeJogo;
    }

    public EstadoMasmorra getStatusMasmorra() {
        return statusMasmorra;
    }
}
