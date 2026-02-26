package br.com.rpg;

import br.com.rpg.controller.BatalhaController;
import br.com.rpg.model.entities.inimigo.CatalogoInimigo;
import br.com.rpg.model.entities.inimigo.RankInimigo;
import br.com.rpg.model.habilidade.CatalogoHabilidades;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.inimigo.Inimigo;
import br.com.rpg.model.enums.ClasseHeroi;
import br.com.rpg.model.entities.inimigo.ClasseInimigo;
import br.com.rpg.view.Teclado;

public class Main {

    public static void main(String[] args) {
        Teclado input = new Teclado();
        try {
            // Esse bloco de inicializações é apenas para testes, será futuramente retirado isso.
            BatalhaController jogo = new BatalhaController();
            Heroi meuHeroi = new Heroi("Ivieri", ClasseHeroi.GUERREIRO);
            Inimigo meuInimigo = CatalogoInimigo.enviarInimigo("ORC_COMUM", RankInimigo.CHEFE);
            meuHeroi.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_VAMPIRICO"));
            meuHeroi.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("CURA_MENOR"));
            meuInimigo.receberDano(50);
            // meuInimigo.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_FORTE"));
            jogo.iniciarBatalha(meuHeroi, meuInimigo);
        }
        catch (Exception e) {
            System.err.println("========================================================================================================");
            System.err.println(e.getMessage());
            System.err.println("========================================================================================================");
            e.printStackTrace();
        }
        finally {
            input.fecharTeclado();
        }
    }
}