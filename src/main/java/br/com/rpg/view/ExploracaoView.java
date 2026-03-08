package br.com.rpg.view;

import br.com.rpg.model.mundo.Cidade;

public class ExploracaoView {
    public void imprimirMenuCidade(Cidade cidadeImprimir) {
        System.out.println("Você está na cidade de: " + cidadeImprimir.getNome());
        System.out.println(cidadeImprimir.getDescricao());
        System.out.println();
        System.out.println("Para onde você quer ir?");
        System.out.println("[1] " + cidadeImprimir.getMasmorrasProximas().getFirst().getNome());
        System.out.println("[2] " + cidadeImprimir.getMasmorrasProximas().get(1).getNome());
        System.out.println("[3] " + cidadeImprimir.getMasmorrasProximas().get(2).getNome());
        System.out.println("[4] " + cidadeImprimir.getMasmorrasProximas().get(3).getNome()); // Por enquanto é a última
        System.out.println("[5] Salvar o jogo");
        System.out.println("[6] Salvar e sair");
    }
}
