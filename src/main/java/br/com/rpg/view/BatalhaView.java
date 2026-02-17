package br.com.rpg.view;

import br.com.rpg.model.entities.Heroi;

public class BatalhaView {

    /**
     * Método que imprime todas as informações contidas no {@link Heroi}.
     * @param jogador Entidade que será imprimida.
     */
    public void mostrarInfoCompletaHeroi(Heroi jogador) {
        String formato = "│ %-25s %15s │%n";
        System.out.println("┌───────────────────────────────────────────┐");
        System.out.printf("│ NOME: %-35s │%n", jogador.getNome());
        System.out.println("├───────────────────────────────────────────┤");
        System.out.printf(formato, "Sua vida total:", jogador.getVida());
        System.out.printf(formato, "Sua mana total:", jogador.getMana());
        System.out.printf(formato, "Seu dano base:", jogador.getDano());
        System.out.printf(formato, "Sua defesa total:", jogador.getDefesa() + "%");
        System.out.printf(formato, "Sua chance de crítico:", jogador.getChanceCrit() + "%");
        System.out.printf(formato, "Sua chance de esquiva:", jogador.getChanceEsq() + "%");
        System.out.println("└───────────────────────────────────────────┘");
    }


    public void mostrarInfoBatalhaJogador(Heroi jogador) {
        System.out.println("[1] Use uma habilidade aprendida");
        System.out.println("[2] Defenda-se");
        System.out.println("[3] Use algum item");
        System.out.println("[4] Analise seu inimigo");
        System.out.println("[5] Fuja");
    }
}
