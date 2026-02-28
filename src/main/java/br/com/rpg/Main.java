package br.com.rpg;

import br.com.rpg.controller.ExploracaoController;
import br.com.rpg.controller.InicializarJogoController;
import br.com.rpg.model.entities.heroi.CatalogoHeroi;
import br.com.rpg.model.entities.heroi.Heroi;
import br.com.rpg.model.mundo.Cidade;
import br.com.rpg.model.mundo.MundoBuilder;
import br.com.rpg.model.services.SaveService;
import br.com.rpg.view.Teclado;

public class Main {

    public static void main(String[] args) {
        Teclado input = new Teclado();
        try {
            // Esse bloco de inicializações é apenas para testes, será futuramente retirado isso.
            InicializarJogoController jogo = new InicializarJogoController();
            jogo.iniciarJogo();
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