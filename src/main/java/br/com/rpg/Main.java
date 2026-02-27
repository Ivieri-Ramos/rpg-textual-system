package br.com.rpg;

import br.com.rpg.controller.BatalhaController;
import br.com.rpg.controller.ExploracaoController;
import br.com.rpg.model.entities.inimigo.CatalogoInimigo;
import br.com.rpg.model.entities.inimigo.RankInimigo;
import br.com.rpg.model.habilidade.CatalogoHabilidades;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.entities.inimigo.Inimigo;
import br.com.rpg.model.enums.ClasseHeroi;
import br.com.rpg.model.entities.inimigo.ClasseInimigo;
import br.com.rpg.model.mundo.Cidade;
import br.com.rpg.model.mundo.MundoBuilder;
import br.com.rpg.view.Teclado;
import br.com.rpg.view.utils.ConsoleUtils;

public class Main {

    public static void main(String[] args) {
        Teclado input = new Teclado();
        try {
            // Esse bloco de inicializações é apenas para testes, será futuramente retirado isso.
            MundoBuilder construtor = new MundoBuilder();
            Heroi meuHeroi = new Heroi("Ivieri", ClasseHeroi.GUERREIRO);
            meuHeroi.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_VAMPIRICO"));
            meuHeroi.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("CURA_MENOR"));
            // meuInimigo.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_FORTE"));
            Cidade cidadeInicial = construtor.gerarCidadePrincipal();
            ExploracaoController jogo = new ExploracaoController(cidadeInicial);
            jogo.centroJogo(meuHeroi);
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