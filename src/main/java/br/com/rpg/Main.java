package br.com.rpg;

import br.com.rpg.model.entities.CatalogoHabilidades;
import br.com.rpg.view.Teclado;

public class Main {
    public static void main(String[] args) {
        CatalogoHabilidades.iniciarCatalogo();

        Teclado.fecharTeclado();
    }
}