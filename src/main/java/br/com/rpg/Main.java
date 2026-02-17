package br.com.rpg;

import br.com.rpg.model.entities.CatalogoHabilidades;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.enums.ClasseHeroi;
import br.com.rpg.view.ListagemView;
import br.com.rpg.view.Teclado;

public class Main {
    public static void main(String[] args) {
        CatalogoHabilidades.iniciarCatalogo();
        Heroi meuHeroi = new Heroi("Ivieri", ClasseHeroi.GUERREIRO);
        meuHeroi.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_NORMAL"));
        meuHeroi.aprenderHabilidade(CatalogoHabilidades.enviarHabilidade("ATAQUE_FORTE"));
        ListagemView.mostrarHabilidades(meuHeroi.getMenuHabilidades());
        Teclado.fecharTeclado();
    }
}