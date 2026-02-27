package br.com.rpg;

import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.entities.heroi.ClasseHeroi;
import br.com.rpg.model.mundo.MundoBuilder;
import br.com.rpg.view.Teclado;

public class Main {

    public static void main(String[] args) {
        Teclado input = new Teclado();
        try {
            // Esse bloco de inicializações é apenas para testes, será futuramente retirado isso.
            MundoBuilder construtor = new MundoBuilder();
            Heroi meuHeroi = new Heroi("Ivieri", ClasseHeroi.GUERREIRO);
            // meuInimigo.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_FORTE"));
            // Cidade cidadeInicial = construtor.gerarCidadePrincipal();
            // ExploracaoController jogo = new ExploracaoController(cidadeInicial);
            // jogo.centroJogo(meuHeroi);
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