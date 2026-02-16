package br.com.rpg;

import br.com.rpg.model.entities.CatalogoHabilidades;
import br.com.rpg.model.entities.Heroi;
import br.com.rpg.model.enums.ClasseHeroi;
import br.com.rpg.view.BatalhaView;
import br.com.rpg.view.Teclado;

public class Main {
    public static void main(String[] args) {
        CatalogoHabilidades.iniciarCatalogo();
        Teclado.fecharTeclado();
    }
}