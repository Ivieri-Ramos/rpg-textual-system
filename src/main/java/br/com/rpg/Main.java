package br.com.rpg;

import br.com.rpg.controller.BatalhaController;
import br.com.rpg.model.entities.CatalogoHabilidades;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.Inimigo;
import br.com.rpg.model.enums.ClasseHeroi;
import br.com.rpg.model.enums.ClasseInimigo;
import br.com.rpg.view.Teclado;

public class Main {

    public static void main(String[] args) {
        Teclado input = new Teclado();
        // Esse bloco de inicializações é apenas para testes, será futuramente retirado isso.
        BatalhaController jogo  = new BatalhaController();
        Heroi meuHeroi = new Heroi("Ivieri", ClasseHeroi.GUERREIRO);
        Inimigo meuInimigo = new Inimigo("Orc", ClasseInimigo.ORC);
        meuHeroi.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_NORMAL"));
        meuHeroi.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_FORTE"));
        meuInimigo.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_NORMAL"));
        meuInimigo.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_FORTE"));
        jogo.iniciarBatalha(meuHeroi, meuInimigo);
        input.fecharTeclado();
    }
}