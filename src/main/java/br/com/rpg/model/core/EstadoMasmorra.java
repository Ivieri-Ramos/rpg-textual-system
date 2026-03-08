package br.com.rpg.model.core;

import br.com.rpg.model.mundo.Masmorra;

public class EstadoMasmorra {

    private Masmorra masmorraAtual;
    private int andarAtual;

    public Masmorra getMasmorraAtual() {
        return masmorraAtual;
    }

    public void setMasmorraAtual(Masmorra masmorraAtual) {
        this.andarAtual = 1;
        this.masmorraAtual = masmorraAtual;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void incrementarAndar() {
        this.andarAtual++;
    }
}
